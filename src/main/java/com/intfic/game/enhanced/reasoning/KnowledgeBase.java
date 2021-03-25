package com.intfic.game.enhanced.reasoning;

import com.intfic.game.enhanced.FileErrorHandler;
import com.intfic.game.enhanced.parser.SimpleBooleanLexer;
import com.intfic.game.enhanced.parser.SimpleBooleanParser;
import com.intfic.game.enhanced.reasoning.error.KnowledgeException;
import com.intfic.game.enhanced.reasoning.error.MissingKnowledgeException;
import com.intfic.game.enhanced.reasoning.frames.GenericFrame;
import com.intfic.game.enhanced.reasoning.frames.SpecificFrame;
import com.intfic.game.enhanced.reasoning.updates.KnowledgeUpdate;
import com.intfic.game.enhanced.reasoning.visitors.ConditionEvaluationVisitor;
import com.intfic.game.shared.Item;
import com.intfic.game.shared.Util;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.misc.ParseCancellationException;
import org.jetbrains.annotations.NotNull;

@SuppressWarnings("ALL")
public class KnowledgeBase implements Serializable {

   private static final long serialVersionUID = -3641841224766299640L;

   private Map<String, GenericFrame> genericFrames;
   private Map<String, SpecificFrame> specificFrames;
   private ConditionEvaluationVisitor conditionEvaluationVisitor;
   private boolean firstError = true;
   private String errorHeader = "\n" + DateTimeFormatter.ofPattern("yyyyMMdd-HH:mm").format(LocalDateTime.now()) + "\n";

   public static char SEPARATOR = '_';

   private String replaceSpaces(String name) {
      return name.replace(' ', SEPARATOR);
   }

   public Map<String, SpecificFrame> getSpecificFrames() {
      return specificFrames;
   }

   public Map<String, GenericFrame> getGenericFrames() {
      return genericFrames;
   }

   public KnowledgeBase() {
      this.genericFrames = new LinkedHashMap<>();
      this.specificFrames = new LinkedHashMap<>();
      conditionEvaluationVisitor = new ConditionEvaluationVisitor(this);
   }

   public boolean addGenericFrame(GenericFrame g) {
      if (!this.genericFrames.containsValue(g)) {
         this.genericFrames.put(g.getId(), g);
         return true;
      }
      else {
         return false;
      }
   }

   public boolean addSpecificFrame(SpecificFrame s) {
      if (!this.specificFrames.containsValue(s)) {
         this.specificFrames.put(s.getId(), s);
         return true;
      }
      else {
         return false;
      }
   }

   public static String stripExclamationMark(String s) {
      if (s.charAt(0) == '!') {
         return s.substring(1);
      }
      else {
         return s;
      }
   }


   public boolean frameNameEquals(String s1, String s2) {
      return stripExclamationMark(s1).equals(stripExclamationMark(s2));
   }
   // TODO: ALL of these need to throw MISSING Knowledge exception

   private List<String> frameAndSlot(String text) throws KnowledgeException {
      String knowledgeRegex = KnowledgeRegex.KNOWLEDGE_EXPR;
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
      if (queryResult instanceof Double) {
         double num = (double) queryResult;
         if ((int) num == num) {
            return Integer.toString((int) num); //for you, StackOverflowException
         }
         return String.valueOf(num); //and for you, Christian Kuetbach
      }
      return queryResult.toString();
   }

   public String fillQueryString(String failureMessage) {
      return fillQueryString(failureMessage, null);
   }

   public String fillQueryString(String failureMessage, List<String> itemIdentifiersToFill) {
      // TODO: Replace all possible query strings that start with _ in the strings. Don't replace values
      String valueRegex = KnowledgeRegex.KNOWLEDGE_EXPR;

      Pattern valuePattern = Pattern.compile(valueRegex);
      Matcher valueMatcher = valuePattern.matcher(failureMessage);
      String halfway = failureMessage;
      while (valueMatcher.find()) {
         String match = valueMatcher.group();
         List<String> frameAndSlot = null;
         try {
            frameAndSlot = frameAndSlot(match);
            if (itemIdentifiersToFill != null && !itemIdentifiersToFill.contains(frameAndSlot.get(0))) {
               continue;
            }
         }
         catch (KnowledgeException e) {
            this.printLogToFile("Failed subsequence match for fillQueryString " + failureMessage);
            continue;
         }
         int start = valueMatcher.start();
         int end = valueMatcher.end();
         try {
            Object queryResult = this.query(frameAndSlot.get(0), frameAndSlot.get(1));
            halfway = halfway.substring(0, start) + queryResultToString(queryResult) + halfway.substring(end);
         }
         catch (MissingKnowledgeException | KnowledgeException e) {
            this.printLogToFile("Couldn't query in fillQueryString for " + frameAndSlot.get(0) + frameAndSlot.get(1));
            this.printLogToFile(e.getMessage());
            halfway = halfway;
         }
      }

      String frameIdRegex = KnowledgeRegex.FRAME_NAME_EXPR;
      Pattern pattern = Pattern.compile(frameIdRegex);
      Matcher matcher = pattern.matcher(halfway);

      String result = matcher.replaceAll(matchResult -> stripExclamationMark(matchResult.group()));

      return result;
   }

   private void printLogToFile(String s) {
      FileErrorHandler.printToErrorLog("\n Writing KNOWLEDGEBASE error string to log \n" + s);
   }


   public boolean conditionSucceeds(String expression) throws KnowledgeException, MissingKnowledgeException {
      // TODO: Run the SimpleBoolean thing on the condition and change so that the identifier
      // TODO: gets values from the Frames
      // TODO: If the string is invalid, throw an exception
      try {
         Boolean result = VisitorHelper.evaluateCondition(conditionEvaluationVisitor, expression);
         //System.out.printf("%-70s -> %s | ", expression, result);
         return result;
      }
      catch (RecognitionException | ParseCancellationException e) {
         throw new ParseCancellationException("Couldn't parse expression " + expression + " ." + e.getMessage());
      }
   }

   private SpecificFrame findSpecificFrameAlways(String frameId) {
      return this.specificFrames.getOrDefault(frameId, new SpecificFrame(frameId));
   }

   private SpecificFrame findSpecificFrame(String frameId) throws KnowledgeException {
      if (this.specificFrames.containsKey(frameId)) {
         return this.specificFrames.get(frameId);
      }
      else {
         throw new KnowledgeException(String.format("Frame: %s doesn't exist", frameId));
      }
   }

   public Object rhsValueFromKnowledgeUpdate(KnowledgeUpdate knowledgeUpdate) throws MissingKnowledgeException, KnowledgeException {
      Object rhsValue;
      if (knowledgeUpdate.getSettingType() == KnowledgeUpdate.SettingType.CONSTANT) {
         rhsValue = knowledgeUpdate.getUpdateConstant();
      }
      else if (knowledgeUpdate.getSettingType() == KnowledgeUpdate.SettingType.FRAME) {
         rhsValue = knowledgeUpdate.getForeignFrame();
      }
      else {
         try {
            rhsValue = this.query(knowledgeUpdate.getForeignFrame(), knowledgeUpdate.getForeignSlot());
         }
         catch (KnowledgeException e) {
            throw new KnowledgeException("Couldn't fulfill update with KnowledgeUpdate: " + knowledgeUpdate.toString() + e.getMessage());
         }
      }
      return rhsValue;
   }

   public void update(KnowledgeUpdate knowledgeUpdate) throws KnowledgeException, MissingKnowledgeException {
      // TODO: Use a method on the knowledgeBase to update it. This method needs to understand
      // TODO: the engineering of the com.interactivefiction.game.enhanced.reasoning.updates.KnowledgeUpdate
      // TODO: It also needs to notice type failures when using
      // TODO *=, /= on non-numeric
      // TODO: failure mode will be to write the type failure to an error file and ignore the update
      Object rhsValue = rhsValueFromKnowledgeUpdate(knowledgeUpdate);

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
               if (Util.isPotentiallyDoubleList(addValue)) {
                  ((List) addValue).add(rhsValue);
               }
               else {
                  throw new KnowledgeException("Mismatched list types when updating with ADD "
                      + knowledgeUpdate.toString() +
                      "for currentval: " + addValue.toString() + " settingVal: " + rhsValue.toString());
               }
               result = addValue;
            }
            else if (addValue instanceof List && rhsValue instanceof String) {
               if (Util.isPotentiallyStringList(addValue)) {
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
            else if (subtractValue instanceof List && rhsValue instanceof String) {
               if (Util.isPotentiallyStringList(subtractValue)) {
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
               if (Util.isPotentiallyDoubleList(subtractValue)) {
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
      if (result == null) {
         throw new KnowledgeException("Result is somehow null" + knowledgeUpdate.toString());
      }
      frameToSet.updateFiller(slotToSet, result);


   }

   public Object query(@NotNull String frame, @NotNull String slot) throws KnowledgeException, MissingKnowledgeException {
      SpecificFrame frameQueried = findSpecificFrame(stripExclamationMark(frame));
      return frameQueried.getFiller(slot);
   }

   public String queryString(@NotNull String frame, @NotNull String slot) throws KnowledgeException, MissingKnowledgeException {
      Object queryResult = this.query(frame, slot);
      if (queryResult instanceof String) {
         return (String) queryResult;
      }
      else {
         throw new KnowledgeException(String.format("Couldn't cast the result of query for frame: %s" +
             ", slot: %s - %s (%s) - to String", frame, slot, queryResult.toString(), queryResult.getClass().getName()));
      }
   }

   public Double queryDouble(@NotNull String frame, @NotNull String slot) throws KnowledgeException, MissingKnowledgeException {
      Object queryResult = this.query(frame, slot);
      if (queryResult instanceof Double) {
         return (Double) queryResult;
      }
      else {
         throw new KnowledgeException(String.format("Couldn't cast the result of query for frame: %s" +
             ", slot: %s - %s (%s) - to Double", frame, slot, queryResult.toString(), queryResult.getClass().getName()));
      }
   }

   @Override
   public String toString() {
      return "KnowledgeBase{ \n " +
          "genericFrames=" + String.join(",\n", genericFrames.values().stream().map(GenericFrame::toString).collect(Collectors.toList())) +
          ",\n specificFrames=" + String.join(",\n", specificFrames.values().stream().map(SpecificFrame::toString).collect(Collectors.toList())) +
          '}';
   }

   // THIS IS THE ONLY FUNCTION THAT RETURNS A DEFAULT VALUE.
   public Boolean queryBoolean(@NotNull String frame, @NotNull String slot) throws KnowledgeException, MissingKnowledgeException {
      Object queryResult = findSpecificFrame(stripExclamationMark(frame)).getFiller(slot, false);

      if (queryResult instanceof Boolean) {
         return (Boolean) queryResult;
      }
      else {
         throw new KnowledgeException(String.format("Couldn't cast the result of query for frame: %s" +
             ", slot: %s - %s (%s) - to Boolean", frame, slot, queryResult.toString(), queryResult.getClass().getName()));
      }
   }


   public List<Double> queryDoubleList(String frame, String slot) throws KnowledgeException, MissingKnowledgeException {
      Object queryResult = this.query(frame, slot);
      if (Util.isPotentiallyDoubleList(queryResult)) {
         return (List<Double>) queryResult;
      }
      else {
         throw new KnowledgeException(String.format("Couldn't cast the result of query for frame: %s" +
             ", slot: %s - %s (%s) - to List<Double>", frame, slot, queryResult.toString(), queryResult.getClass().getName()));
      }
   }

   public List<?> queryList(String frame, String slot) throws KnowledgeException, MissingKnowledgeException {
      Object queryResult = this.query(frame, slot);
      if (queryResult instanceof List) {
         return (List<?>) queryResult;
      }
      else {
         throw new KnowledgeException(String.format("Couldn't cast the result of query for frame: %s" +
             ", slot: %s - %s (%s) - to List<?>", frame, slot, queryResult.toString(), queryResult.getClass().getName()));
      }
   }

   public List<String> queryStringList(String frame, String slot) throws KnowledgeException, MissingKnowledgeException {
      Object queryResult = this.query(frame, slot);
      if (Util.isPotentiallyStringList(queryResult)) {
         return (List<String>) queryResult;
      }
      else {
         throw new KnowledgeException(String.format("Couldn't cast the result of query for frame: %s" +
             ", slot: %s - %s (%s) - to List<String>", frame, slot, queryResult.toString(), queryResult.getClass().getName()));
      }
   }

   public static String getItemIdentifier(Item i) {
      return i.getID();
   }

   public boolean createSpecificFrame(String i, String... gs) {
      SpecificFrame specificFrame = new SpecificFrame(replaceSpaces(i));
      for (String g : gs) {
         if (genericFrames.containsKey(g)) {
            specificFrame.addParent(genericFrames.get(g));
         }
         else {
            printLogToFile("No such parent " + g);
         }
      }
      return this.addSpecificFrame(specificFrame);
   }

   public SpecificFrame removeSpecificFrame(String itemName) {
      return this.specificFrames.remove(itemName);
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) {
         return true;
      }
      if (o == null || getClass() != o.getClass()) {
         return false;
      }
      KnowledgeBase that = (KnowledgeBase) o;
      boolean gfEquals = genericFrames.equals(that.genericFrames);
      boolean sfEquals = specificFrames.equals(that.specificFrames);
      return gfEquals && sfEquals;
   }

   @Override
   public int hashCode() {
      return Objects.hash(genericFrames, specificFrames);
   }
}
