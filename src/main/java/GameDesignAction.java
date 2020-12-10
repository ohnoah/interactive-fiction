import java.util.Map;

public class GameDesignAction {
   private ConcreteGameAction verbAndArgs;
   private Map<String, String> preconditions;
   private String message;

   public ConcreteGameAction getVerbAndArgs() {
      return verbAndArgs;
   }

   public void setVerbAndArgs(ConcreteGameAction verbAndArgs) {
      this.verbAndArgs = verbAndArgs;
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

   private Map<String, String> updateState;

   public String getMessage() {
      return message;
   }

   public void setMessage(String message) {
      this.message = message;
   }
}
