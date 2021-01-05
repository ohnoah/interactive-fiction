import com.enhanced.parser.SimpleBooleanLexer;
import com.enhanced.parser.SimpleBooleanParser;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RecognitionException;

public class KnowledgeBase {

   private List<GenericFrame> genericFrames;
   private List<SpecificFrame> specificFrames;

   private String stripUnderscore(String s) {
      if (s.charAt(0) == '_') {
         return s.substring(1);
      } else {
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
      } else {
         throw new KnowledgeException("Invalid syntax for query: " + text);
      }
   }

   public String fillQueryString(String failureMessage) throws KnowledgeException {
      // TODO: Replace all possible query strings that start with _ in the strings. Don't replace values
      String valueRegex = KnowledgeRegex.knowledgeExpr;

      Pattern valuePattern = Pattern.compile(valueRegex);
      Matcher valueMatcher = valuePattern.matcher(failureMessage);
      String halfway = failureMessage;
      while (valueMatcher.find()) {
         String match = valueMatcher.group();
         List<String> frameAndSlot = frameAndSlot(match);
         int start = valueMatcher.start();
         int end = valueMatcher.end();
         halfway = halfway.substring(0, start) + this.query(frameAndSlot.get(0), frameAndSlot.get(1)).toString() + halfway.substring(end);
      }

      String frameIdRegex = KnowledgeRegex.frameNameExpr;
      Pattern pattern = Pattern.compile(frameIdRegex);
      Matcher matcher = pattern.matcher(halfway);

      String result = matcher.replaceAll(matchResult -> stripUnderscore(matchResult.group()));

      return result;
   }


   public boolean conditionFails(String expression) throws KnowledgeException {
      // TODO: Run the SimpleBoolean thing on the condition and change so that the identifier
      // TODO: gets values from the Frames
      // TODO: If the string is invalid, throw an exception
      SimpleBooleanLexer lexer = new SimpleBooleanLexer(CharStreams.fromString(expression));
      try {
         SimpleBooleanParser parser = new SimpleBooleanParser(new CommonTokenStream(lexer));
         Boolean result = (Boolean) new ConditionEvaluationVisitor(this).visit(parser.parse());
         System.out.printf("%-70s -> %s\n", expression, result);
         return result;
      } catch (RecognitionException e) {
         throw new KnowledgeException("Couldn't parse expression" + expression + " ." + e.getMessage());
      } catch (RuntimeKnowledgeException e) {
         throw new KnowledgeException("Error when parsing expression " + expression + " ." + e.getMessage());
      }
   }

   public void update(KnowledgeUpdate knowledgeUpdate) throws KnowledgeException {
      // TODO: Use a method on the knowledgeBase to update it. This method needs to understand
      // TODO: the engineering of the KnowledgeUpdate
      // TODO: It also needs to notice type failures when using
      // TODO *=, /= on non-numeric
      // TODO: failure mode will be to write the type failure to an error file and ignore the update
   }

   public Object query(String frame, String slot) throws KnowledgeException {
      throw new KnowledgeException(String.format("Frame: %s, Slot: %s doesn't exist", frame, slot));
   }

   public String queryString(String frame, String slot) throws KnowledgeException{
      Object queryResult = this.query(frame, slot);
      if(queryResult instanceof String) {
         return (String) queryResult;
      }
      else{
         throw new KnowledgeException(String.format("Couldn't cast the result of query for frame: %s" +
             ", slot: %s - %s - to String", frame, slot, queryResult.toString()));
      }
   }

   public Double queryDouble(String frame, String slot) throws KnowledgeException{
      Object queryResult = this.query(frame, slot);
      if(queryResult instanceof Double){
         return (Double) queryResult;
      }
      else{
         throw new KnowledgeException(String.format("Couldn't cast the result of query for frame: %s" +
             ", slot: %s - %s - to Double", frame, slot, queryResult.toString()));
      }
   }
   public Boolean queryBoolean(String frame, String slot) throws KnowledgeException {
      Object queryResult = this.query(frame, slot);
      if (queryResult instanceof Boolean) {
         return (Boolean) queryResult;
      } else {
         throw new KnowledgeException(String.format("Couldn't cast the result of query for frame: %s" +
             ", slot: %s - %s - to Boolean", frame, slot, queryResult.toString()));
      }
   }

   public List<Double> queryDoubleList(String frame, String slot) throws KnowledgeException{
      Object queryResult = this.query(frame, slot);
      if(queryResult instanceof List && (queryResult == null || (((List) queryResult).size() == 0) || (((List) queryResult).size() > 0 && ((List) queryResult).get(0) instanceof Double))){
         return (List<Double>) queryResult;
      }
      else{
         throw new KnowledgeException(String.format("Couldn't cast the result of query for frame: %s" +
             ", slot: %s - %s - to List<Double>", frame, slot, queryResult.toString()));
      }
   }

   public List<String> queryStringList(String frame, String slot) throws KnowledgeException{
      Object queryResult = this.query(frame, slot);
      if(queryResult instanceof List && (queryResult == null || (((List) queryResult).size() == 0) || (((List) queryResult).size() > 0 && ((List) queryResult).get(0) instanceof String))){
         return (List<String>) queryResult;
      }
      else{
         throw new KnowledgeException(String.format("Couldn't cast the result of query for frame: %s" +
             ", slot: %s - %s - to List<String>", frame, slot, queryResult.toString()));
      }
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
