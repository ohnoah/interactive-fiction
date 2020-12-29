import java.io.Serializable;
import java.util.Map;
import java.util.Set;

public class EnhancedGameEngine extends GameEngine implements Serializable {
   private static final long serialVersionUID = -285490537820866832L;
   private Map<Room, Map<InstantiatedGameAction, EnhancedGameDesignAction>> designerActions;
   private KnowledgeBase knowledgeBase;


   @Override
   public Set<Item> possibleItems() {
      return null;
   }

   public EnhancedGameEngine() {
   }

   @Override
   public String progressStory(InstantiatedGameAction gameAction) {
      String message = "";
      // if it returns a healthy String message, prepend that and let the GameDesignAction continue
      ActionLogic logicOfAction = new ActionLogic(gameAction, knowledgeBase);
      message = logicOfAction.textReason();
      if(!logicOfAction.isValid()){
         return message;
      }



      // Then check the GameDesignActions and prepend another message




      return null;
   }
}
