import java.io.Serializable;
import java.util.Map;
import java.util.Set;

public class EnhancedGameEngine extends GameEngine implements Serializable {
   private static final long serialVersionUID = -285490537820866832L;
   private Map<Room, Map<InstantiatedGameAction, EnhancedGameDesignAction>> designerActions;


   @Override
   public Set<Item> possibleItems() {
      return null;
   }

   @Override
   public String progressStory(InstantiatedGameAction gameAction) {
      String message = "";
      // Game Logic validation here. Try to checkGameLogic(gameAction).
      // catch a GameLogicError and return message if so
      // if it returns a healthy String message, prepend that and let the GameDesignAction continue
      ActionLogic logicOfAction = new ActionLogic(gameAction);
      message = logicOfAction.textReason();
      if(!logicOfAction.isValid()){
         return message;
      }



      // Then check the GameDesignActions




      return null;
   }
}
