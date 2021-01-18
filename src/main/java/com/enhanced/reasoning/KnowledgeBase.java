package com.enhanced.reasoning;

import com.enhanced.parser.SimpleBooleanLexer;
import com.enhanced.parser.SimpleBooleanParser;
import com.enhanced.reasoning.exceptions.KnowledgeException;
import com.enhanced.reasoning.exceptions.MissingKnowledgeException;
import com.shared.Item;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.misc.ParseCancellationException;
import org.jetbrains.annotations.NotNull;

@SuppressWarnings("ALL")
public class KnowledgeBase implements Serializable {

   private static final long serialVersionUID = -3641841224766299640L;

   private List<GenericFrame> genericFrames;
   private List<SpecificFrame> specificFrames;
   private ConditionEvaluationVisitor conditionEvaluationVisitor;
   private boolean firstError = true;
   private String errorHeader = "\n" + DateTimeFormatter.ofPattern("yyyyMMdd-HH:mm").format(LocalDateTime.now()) + "\n";


   private String replaceSpaces(String name){
      return name.replace(" ", "-");
   }

   public List<SpecificFrame> getSpecificFrames() {
      return new ArrayList<>(specificFrames);
   }

   public List<GenericFrame> getGenericFrames() {
      return new ArrayList<>(genericFrames);
   }

   public KnowledgeBase() {
      this.genericFrames = new ArrayList<>();
      this.specificFrames = new ArrayList<>();
      conditionEvaluationVisitor = new ConditionEvaluationVisitor(this);
   }

   public boolean addGenericFrame(GenericFrame g) {
      if (!this.genericFrames.contains(g)) {
         this.genericFrames.add(g);
         return true;
      }
      else{
         return false;
      }
   }

   public boolean addSpecificFrame(SpecificFrame s) {
      if (!this.specificFrames.contains(s)) {
         this.specificFrames.add(s);
         return true;
      }
      else{
         return false;
      }
   }

   public static String stripUnderscore(String s) {
      if (s.charAt(0) == '_') {
         return s.substring(1);
      }
      else {
         return s;
      }
   }


   public boolean frameNameEquals(String s1, String s2) {
      return stripUnderscore(s1).equals(stripUnderscore(s2));
   }
   // TODO: ALL of these need to throw MISSING Knowledge exception

   private List<String> frameAndSlot(String text) throws KnowledgeException {
      String knowledgeRegex = KnowledgeRegex.knowledgeExpr;
      Pattern p = Pattern.compile(knowledgeRegex);
      Matcher m = p.matcher(text);
      if (m.matches()) {
         String frame = m.group(1);
         String slot = m.group(2);
         return List.of(frame, slot);
      }
      else {
         throw new KnowledgeException("Invalid syntax for query: " + text);
      }
   }

   private static String queryResultToString(Object queryResult) {
      if(queryResult instanceof Double) {
         double num = (double) queryResult;
         if ((int) num == num) return Integer.toString((int) num); //for you, StackOverflowException
         return String.valueOf(num); //and for you, Christian Kuetbach
      }
      return queryResult.toString();
   }

   public String fillQueryString(String failureMessage) {
      // TODO: Replace all possible query strings that start with _ in the strings. Don't replace values
      String valueRegex = KnowledgeRegex.knowledgeExpr;

      Pattern valuePattern = Pattern.compile(valueRegex);
      Matcher valueMatcher = valuePattern.matcher(failureMessage);
      String halfway = failureMessage;
      while (valueMatcher.find()) {
         String match = valueMatcher.group();
         List<String> frameAndSlot = null;
         try {
            frameAndSlot = frameAndSlot(match);
         } catch (KnowledgeException e) {
            this.printLogToFile("Failed subsequence match for fillQueryString " + failureMessage);
            continue;
         }
         int start = valueMatcher.start();
         int end = valueMatcher.end();
         try {
            Object queryResult = this.query(frameAndSlot.get(0), frameAndSlot.get(1));
            halfway = halfway.substring(0, start) + queryResultToString(queryResult) + halfway.substring(end);
         } catch (MissingKnowledgeException | KnowledgeException e) {
            this.printLogToFile("Couldn't query in fillQueryString for " + frameAndSlot.get(0) + frameAndSlot.get(1));
            this.printLogToFile(e.getMessage());
            halfway = halfway;
         }
      }

      String frameIdRegex = KnowledgeRegex.frameNameExpr;
      Pattern pattern = Pattern.compile(frameIdRegex);
      Matcher matcher = pattern.matcher(halfway);

      String result = matcher.replaceAll(matchResult -> stripUnderscore(matchResult.group()));

      return result;
   }

   private void printLogToFile(String s) {
      try {
         System.err.println("\n Writing KNOWLEDGEBASE error string to log \n");
         File file = new File("error-knowledgebase-log.txt");
         file.createNewFile();
         if(firstError) Files.write(file.toPath(), errorHeader.getBytes(), StandardOpenOption.APPEND); firstError = false;
         Files.write(file.toPath(), (s + "\n").getBytes(), StandardOpenOption.APPEND);
      } catch (IOException e) {
         System.err.println("Couldn't write to error");
         System.err.println(s);
         e.printStackTrace();
      }
   }


   public boolean conditionSucceeds(String expression) throws KnowledgeException, MissingKnowledgeException {
      // TODO: Run the SimpleBoolean thing on the condition and change so that the identifier
      // TODO: gets values from the Frames
      // TODO: If the string is invalid, throw an exception
      try {
         Boolean result = VisitorHelper.evaluateCondition(conditionEvaluationVisitor, expression);
         //System.out.printf("%-70s -> %s | ", expression, result);
         return result;
      } catch (RecognitionException | ParseCancellationException e) {
         throw new ParseCancellationException("Couldn't parse expression" + expression + " ." + e.getMessage());
      }
   }

   private SpecificFrame findSpecificFrameAlways(String frameId) {
      return this.specificFrames.stream().filter(frame -> frame.getId().equals(frameId)).findAny().orElse(new SpecificFrame(frameId));

   }

   private SpecificFrame findSpecificFrame(String frameId) throws KnowledgeException {
      return this.specificFrames.stream().filter(frame -> frame.getId().equals(frameId)).findAny()
          .orElseThrow(() -> new KnowledgeException(String.format("Frame: %s doesn't exist", frameId)));
   }

   public void update(KnowledgeUpdate knowledgeUpdate) throws KnowledgeException, MissingKnowledgeException {
      // TODO: Use a method on the knowledgeBase to update it. This method needs to understand
      // TODO: the engineering of the com.enhanced.reasoning.KnowledgeUpdate
      // TODO: It also needs to notice type failures when using
      // TODO *=, /= on non-numeric
      // TODO: failure mode will be to write the type failure to an error file and ignore the update
      Object rhsValue;
      if (knowledgeUpdate.getSettingType() == KnowledgeUpdate.SettingType.CONSTANT)  {
         rhsValue = knowledgeUpdate.getUpdateConstant();
      }
      else if(knowledgeUpdate.getSettingType() == KnowledgeUpdate.SettingType.FRAME){
         rhsValue = knowledgeUpdate.getForeignFrame();
      }
      else {
         try {
            rhsValue = this.query(knowledgeUpdate.getForeignFrame(), knowledgeUpdate.getForeignSlot());
         } catch (KnowledgeException e) {
            throw new KnowledgeException("Couldn't fulfill update with KnowledgeUpdate: " + knowledgeUpdate.toString() + e.getMessage());
         }
      }
      SpecificFrame frameToSet = this.findSpecificFrameAlways(knowledgeUpdate.getFrameToUpdate());
      String slotToSet = knowledgeUpdate.getSlotToUpdate();

      // TODO: FIX THIS
      Object result = null;
      switch (knowledgeUpdate.getUpdateType()) {
         case SET:
            result = rhsValue;
            break;
         case ADD:
            Object addValue = frameToSet.getFiller(slotToSet);
            if (addValue instanceof Double && rhsValue instanceof Double) {
               result = (Double) addValue + (Double) rhsValue;
            }
            else if (addValue instanceof String && rhsValue instanceof String) {
               result = (String) addValue + (String) rhsValue;
            }
            else if (addValue instanceof List && rhsValue instanceof Double) {
               if (isPotentiallyDoubleList(addValue)) {
                  ((List) addValue).add(rhsValue);
               }
               else {
                  throw new KnowledgeException("Mismatched list types when updating with ADD "
                      + knowledgeUpdate.toString() +
                      "for currentval: " + addValue.toString() + " settingVal: " + rhsValue.toString());
               }
               result = addValue;
            }
            else if(addValue instanceof List && rhsValue instanceof String){
               if (isPotentiallyStringList(addValue)) {
                  ((List) addValue).add(rhsValue);
               }
               else {
                  throw new KnowledgeException("Mismatched list types when updating with ADD "
                      + knowledgeUpdate.toString() +
                      "for currentval: " + addValue.toString() + " settingVal: " + rhsValue.toString());
               }
               result = addValue;
            }
            break;
         case SUBTRACT:
            Object subtractValue = frameToSet.getFiller(slotToSet);
            if (subtractValue instanceof Double && rhsValue instanceof Double) {
               result = (Double) subtractValue - (Double) rhsValue;
            }
            else if(subtractValue instanceof List && rhsValue instanceof String){
               if (isPotentiallyStringList(subtractValue)) {
                  ((List) subtractValue).remove(rhsValue);
               }
               else {
                  throw new KnowledgeException("Mismatched list types when updating with SUB "
                      + knowledgeUpdate.toString() +
                      "for currentval: " + subtractValue.toString() + " settingVal: " + rhsValue.toString());
               }
               result = subtractValue;
            }
            else if (subtractValue instanceof List && rhsValue instanceof Double) {
               if (isPotentiallyDoubleList(subtractValue)) {
                  ((List) subtractValue).remove(rhsValue);
               }
               else {
                  throw new KnowledgeException("Mismatched list types when updating with SUB "
                      + knowledgeUpdate.toString() +
                      "for currentval: " + subtractValue.toString() + " settingVal: " + rhsValue.toString());
               }
               result = subtractValue;
            }
            break;
         case MULTIPLY:
            Object multiplyValue = frameToSet.getFiller(slotToSet);
            if (multiplyValue instanceof Double && rhsValue instanceof Double) {
               result = (Double) multiplyValue * (Double) rhsValue;
            }
            else {
               throw new KnowledgeException("Mismatched types when updating with SUB "
                   + knowledgeUpdate.toString() +
                   "for currentval: " + multiplyValue.toString() + " settingVal: " + rhsValue.toString());
            }
            break;
         default:
            throw new KnowledgeException("Not implemented KnowledgeUpdateType " + knowledgeUpdate.toString());
      }
      if(result == null) throw new KnowledgeException("Result is somehow null" + knowledgeUpdate.toString());
      frameToSet.updateFiller(slotToSet, result);


   }

   public Object query(@NotNull String frame, @NotNull String slot) throws KnowledgeException, MissingKnowledgeException {
      SpecificFrame frameQueried = findSpecificFrame(stripUnderscore(frame));
      return frameQueried.getFiller(slot);
   }

   public String queryString(@NotNull String frame, @NotNull String slot) throws KnowledgeException, MissingKnowledgeException {
      Object queryResult = this.query(frame, slot);
      if (queryResult instanceof String) {
         return (String) queryResult;
      }
      else {
         throw new KnowledgeException(String.format("Couldn't cast the result of query for frame: %s" +
             ", slot: %s - %s - to String", frame, slot, queryResult.toString()));
      }
   }

   public Double queryDouble(@NotNull String frame, @NotNull String slot) throws KnowledgeException, MissingKnowledgeException {
      Object queryResult = this.query(frame, slot);
      if (queryResult instanceof Double) {
         return (Double) queryResult;
      }
      else {
         throw new KnowledgeException(String.format("Couldn't cast the result of query for frame: %s" +
             ", slot: %s - %s - to Double", frame, slot, queryResult.toString()));
      }
   }

   @Override
   public String toString() {
      return "KnowledgeBase{" +
          "genericFrames=" + genericFrames +
          ", specificFrames=" + specificFrames +
          '}';
   }

   public Boolean queryBoolean(@NotNull String frame, @NotNull String slot) throws KnowledgeException, MissingKnowledgeException {
      Object queryResult = this.query(frame, slot);
      if (queryResult instanceof Boolean) {
         return (Boolean) queryResult;
      }
      else {
         throw new KnowledgeException(String.format("Couldn't cast the result of query for frame: %s" +
             ", slot: %s - %s - to Boolean", frame, slot, queryResult.toString()));
      }
   }

   private boolean isPotentiallyStringList(Object object) {
      return object instanceof List && ((((List) object).size() == 0) || (((List) object).size() > 0 && ((List) object).get(0) instanceof String));
   }

   private boolean isPotentiallyDoubleList(Object object) {
      return object instanceof List && ((((List) object).size() == 0) || (((List) object).size() > 0 && ((List) object).get(0) instanceof Double));
   }

   public List<Double> queryDoubleList(String frame, String slot) throws KnowledgeException, MissingKnowledgeException {
      Object queryResult = this.query(frame, slot);
      if (isPotentiallyDoubleList(queryResult)) {
         return (List<Double>) queryResult;
      }
      else {
         throw new KnowledgeException(String.format("Couldn't cast the result of query for frame: %s" +
             ", slot: %s - %s - to List<Double>", frame, slot, queryResult.toString()));
      }
   }

   public List<?> queryList(String frame, String slot) throws KnowledgeException, MissingKnowledgeException {
      Object queryResult = this.query(frame, slot);
      if (queryResult instanceof List) {
         return (List<?>) queryResult;
      }
      else {
         throw new KnowledgeException(String.format("Couldn't cast the result of query for frame: %s" +
             ", slot: %s - %s - to List<?>", frame, slot, queryResult.toString()));
      }
   }

   public List<String> queryStringList(String frame, String slot) throws KnowledgeException, MissingKnowledgeException {
      Object queryResult = this.query(frame, slot);
      if (isPotentiallyStringList(queryResult)) {
         return (List<String>) queryResult;
      }
      else {
         throw new KnowledgeException(String.format("Couldn't cast the result of query for frame: %s" +
             ", slot: %s - %s - to List<String>", frame, slot, queryResult.toString()));
      }
   }

   public boolean createSpecificFrame(Item i) {
      SpecificFrame specificFrame = new SpecificFrame(replaceSpaces(i.getName()));
      specificFrame.updateFiller("isContainer", false);
      return this.addSpecificFrame(specificFrame);
   }

   public static void main(String[] args) {

/*      Map<String, Object> variables = new HashMap<String, Object>() {{
         put("A", true);
         put("a", true);
         put("B", false);
         put("b", false);
         put("C", 42.0);
         put("c", 42.0);
         put("D", -999.0);
         put("d", -1999.0);
         put("E", 42.001);
         put("e", 142.001);
         put("F", 42.001);
         put("f", 42.001);
         put("G", -1.0);
         put("g", -1.0);
      }};*/

      String[] expressions = {
          "1 = 2",
          "1 > 2",
          "1 >= 1.0",
          "\"HI\" = \"HI\"",
          "TRUE = FALSE",
          "test::test = FALSE",/*
          "A OR B",
          "B",
          "A = B",
          "c = C",
          "E > D",
          "B OR (c = B OR (A = A AND c = C AND E > D))",
          "(A = a OR B = b OR C = c AND ((D = d AND E = e) OR (F = f AND G = g)))"*/
      };

      for (String expression : expressions) {
         SimpleBooleanLexer lexer = new SimpleBooleanLexer(CharStreams.fromString(expression));
         try {
            SimpleBooleanParser parser = new SimpleBooleanParser(new CommonTokenStream(lexer));
            Object result = new ConditionEvaluationVisitor(new KnowledgeBase()).visit(parser.parse());
            System.out.printf("%-70s -> %s\n", expression, result);
         } catch (RecognitionException e) {
            System.out.println("Couldn't parse");
            e.printStackTrace();
         } catch (NullPointerException e) {
            System.out.println("Null pointer expection. Probably due to invalid syntax " + e.getMessage());
            throw e;
         } catch (RuntimeException e) {
            System.out.println("Invalid syntax " + e.getMessage());
         }
      }
   }


}
