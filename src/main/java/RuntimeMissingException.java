public class RuntimeMissingException extends RuntimeException {
   public String getMissingString() {
      return missingString;
   }

   private String missingString;

   public RuntimeMissingException(){
      super("That object doesn't have that trait.");
   }

   public RuntimeMissingException(String message, Throwable cause, String missingString) {
      super(message, cause);
      this.missingString = missingString;
   }

   public RuntimeMissingException(String msg, String missingString){
      super(msg); this.missingString = missingString;
   }
}
