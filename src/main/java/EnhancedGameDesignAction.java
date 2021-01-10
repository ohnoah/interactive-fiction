import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EnhancedGameDesignAction implements Serializable {
   // These all need to be true for the action to go ahead
   // In the Game Editor the default text
   // Do a folding AND to get if this passes or not
   private List<Condition> preconditions; // This is written in ANTLR syntax. This should only reference global state.
   // TODO: use fillQueryString on this to allow for richer messages.
   private String message;
   // TODO: Do we need to add support for executing code based on prev value?
   // Frame-name -> slot-name -> new filler value
   private List<KnowledgeUpdate> updateState;

   public EnhancedGameDesignAction(List<Condition> preconditions, String message, List<KnowledgeUpdate> updateState) {
      this.preconditions = new ArrayList<>(preconditions);
      this.message = message;
      this.updateState = new ArrayList<>(updateState);
   }

   public EnhancedGameDesignAction() {

   }


   public List<Condition> getPreconditions() {
      return new ArrayList<>(preconditions);
   }

   public List<KnowledgeUpdate> getUpdateState() {
      return new ArrayList<>(updateState);
   }

   public String getMessage() {
      return message;
   }

   public void setMessage(String message) {
      this.message = message;
   }
}
