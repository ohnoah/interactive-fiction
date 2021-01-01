import com.enhanced.parser.SimpleBooleanLexer;
import com.enhanced.parser.SimpleBooleanParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RecognitionException;

public class KnowledgeBase {


   private String stripUnderscore(String s) {
      if (s.charAt(0) == '_') {
         return s.substring(1);
      } else {
         return s;
      }
   }

   private boolean evaluateExpression(String expression){
      SimpleBooleanLexer lexer = new SimpleBooleanLexer(CharStreams.fromString(expression));
      try {
         SimpleBooleanParser parser = new SimpleBooleanParser(new CommonTokenStream(lexer));
         Object result = new EvalVisitor(this).visit(parser.parse());
         System.out.printf("%-70s -> %s\n", expression, result);

      }
      catch(RecognitionException e){
         System.out.println("Couldn't parse");
         e.printStackTrace();
      }
      catch(RuntimeException e){
         System.out.println("Invalid syntax " + e.getMessage());
      }
      return false;
   }

   public boolean frameNameEquals(String s1, String s2) {
      return stripUnderscore(s1).equals(stripUnderscore(s2));
   }
   // TODO: ALL of these need to throw MISSING Knowledge exception

   public String fillQueryString(String failureMessage) {
      // TODO: Replace all possible query strings that start with _ in the strings.
      return null;
   }

   public boolean conditionFails(String booleanExpr) throws InvalidKnowledgeSyntaxException {
      // TODO: Run the SimpleBoolean thing on the condition and change so that the identifier
      // TODO: gets values from the Frames
      // TODO: If the string is invalid, throw an exception
      return false;
   }

   public void update(KnowledgeUpdate knowledgeUpdate) {
      // TODO: Use a method on the knowledgeBase to update it. This method needs to understand
      // TODO: the engineering of the KnowledgeUpdate
      // TODO: It also needs to notice type failures when using
      // TODO *=, /= on non-numeric
      // TODO: failure mode will be to write the type failure to an error file and ignore the update
   }

   public void printExceptionToLog(InvalidKnowledgeSyntaxException e) {
   }

   public String query(String frame, String slot) {
      return null;
   }

   public void printToErrorLog(String s) {
   }

   public Object query(String text) {
      return null;
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
          "1 > 2",
          "1 >= 1.0",
          "TRUE = FALSE",
          "FALSE = FALSE"/*,
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
            Object result = new EvalVisitor(new KnowledgeBase()).visit(parser.parse());
            System.out.printf("%-70s -> %s\n", expression, result);
         }
         catch(RecognitionException e){
            System.out.println("Couldn't parse");
            e.printStackTrace();
         }
         catch(RuntimeException e){
            System.out.println("Invalid syntax " + e.getMessage());
         }
      }
   }
}
