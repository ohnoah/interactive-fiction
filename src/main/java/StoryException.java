public class StoryException extends Exception {
   public StoryException(){
      super("Story error occured.");
   }
   public StoryException(String msg){
      super(msg);
   }
}
