public class KnowledgeBase {

   public String fillQueryString(String failureMessage) {
      // TODO: Replace all possible query strings that start with _ in the strings.
      return null;
   }

   public boolean validateCondition(String booleanExpr) throws InvalidKnowledgeSyntaxException {
      // TODO: Run the SimpleBoolean thing on the condition and change so that the identifier
      // TODO: gets values from the Frames
      // TODO: If the string is invalid, throw an exception
      return true;
   }

   public void update(KnowledgeUpdate knowledgeUpdate) {
      // TODO: Use a method on the knowledgeBase to update it. This method needs to understand
      // TODO: the engineering of the KnowledgeUpdate
      // TODO: It also needs to notice type failures when using +=, -=, *=, /= on non-numeric
      // TODO: failure mode will be to write the type failure to an error file and ignore the update
   }

}
