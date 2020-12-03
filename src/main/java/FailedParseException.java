public class FailedParseException extends Exception{

   public FailedParseException(){
      super("I don't understand that command.");
   }
   public FailedParseException(String msg){
      super(msg);
   }
}
