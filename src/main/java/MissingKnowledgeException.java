public class MissingKnowledgeException extends Exception {
   public String getMissingString() {
      return missingString;
   }

   private String missingString;

   public MissingKnowledgeException(){
      super("That object doesn't have that trait.");
   }
   public MissingKnowledgeException(String msg, String missingString){
      super(msg); this.missingString = missingString;
   }
}
