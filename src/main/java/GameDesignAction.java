import java.util.Map;

public class GameDesignAction {
   private Map<String, String> preconditions;
   private String message;
   private Map<String, String> updateState;

   public GameDesignAction(Map<String, String> preconditions, String message, Map<String, String> updateState) {
      this.preconditions = preconditions;
      this.message = message;
      this.updateState = updateState;
   }


   public Map<String, String> getPreconditions() {
      return preconditions;
   }

   public void setPreconditions(Map<String, String> preconditions) {
      this.preconditions = preconditions;
   }

   public Map<String, String> getUpdateState() {
      return updateState;
   }

   public void setUpdateState(Map<String, String> updateState) {
      this.updateState = updateState;
   }


   public String getMessage() {
      return message;
   }

   public void setMessage(String message) {
      this.message = message;
   }
}
