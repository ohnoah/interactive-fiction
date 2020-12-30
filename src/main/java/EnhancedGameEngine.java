import com.jetbrains.rd.util.Maybe;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.jetbrains.annotations.NotNull;

public class EnhancedGameEngine extends GameEngine implements Serializable {
   private static final long serialVersionUID = -5723053787789695459L;
   private Map<Room, Map<InstantiatedGameAction, EnhancedGameDesignAction>> designerActions;
   private KnowledgeBase knowledgeBase;
   // Implemented actions stuff
   private Map<ActionFormat, List<Condition>> implementedConditionsMap;
   private Map<ActionFormat, String> implementedSuccessMessageMap;
   private Map<ActionFormat, List<KnowledgeUpdate>> implementedKnowledgeUpdateMap;


   @Override
   public Set<Item> possibleItems() {
      return currentRoom.getItems();
   }

   public EnhancedGameEngine() {
   }

   protected void fillConditionWithArgs(@NotNull Condition condition, @NotNull List<String> nouns) {
      String newBooleanExpr = replaceArgsWithNouns(condition.getBooleanExpr(), nouns);
      String newFailureMessage = replaceArgsWithNouns(condition.getFailureMessage(), nouns);
      condition.setBooleanExpr(newBooleanExpr);
      condition.setFailureMessage(newFailureMessage);
   }

   protected String replaceArgsWithNouns(@NotNull String s, @NotNull List<String> nouns) {
      String newString = s;
      for (int i = 1; i <= nouns.size(); i++) {
         newString = newString.replaceAll("_arg" + i, nouns.get(i));
      }
      return newString;
   }

   private void updateKnowledgeBase(@NotNull KnowledgeUpdate knowledgeUpdate) {
      knowledgeBase.update(knowledgeUpdate);
      if (knowledgeBase.frameNameEquals(knowledgeUpdate.getUpdatingFrameID(), "world") &&
          knowledgeBase.frameNameEquals(knowledgeUpdate.getUpdatingSlot(), "room")) {
         List<Room> rooms;
         if (!knowledgeUpdate.getUpdateType().equals(UpdateType.SET)) {
            knowledgeBase.printToErrorLog("Treating non-setting as setting because this is current room");
         }
         if (knowledgeUpdate.isConstantUpdate()) {
            moveRoom(knowledgeUpdate.getUpdateConstant());
         } else {
            moveRoom(knowledgeBase.query(knowledgeUpdate.getSettingFrameID(), knowledgeUpdate.getSettingSlot()));
         }
      }
   }


   // TODO: We are going to want the exact same logic for the GameDesignActiosn later
   protected Justification conditionallyPerformAction(@NotNull List<Condition> conditions,
                                                      @NotNull List<String> nouns,
                                                      @NotNull String successMessage,
                                                      @NotNull List<KnowledgeUpdate> knowledgeUpdates) {
      boolean valid = true;
      String reasoning = "";

      for (Condition condition : conditions) {
         // This will populate the errorMessage in Condition if fails
         fillConditionWithArgs(condition, nouns);
         try {
            if (!knowledgeBase.validateCondition(condition.getBooleanExpr())) {
               valid = false;
               reasoning = knowledgeBase.fillQueryString(condition.getFailureMessage());
               break;
            }
         } catch (InvalidKnowledgeSyntaxException e) {
            valid = false;
            reasoning = "There was an error behind the scenes. Try performing another action.";
            // TODO: Print stack trace using PrintStream
            knowledgeBase.printExceptionToLog(e);
            break;
         }
      }
      if (valid) {
         String populatedSuccessMessage = replaceArgsWithNouns(successMessage, nouns);
         reasoning = knowledgeBase.fillQueryString(populatedSuccessMessage);

         for (KnowledgeUpdate knowledgeUpdate : knowledgeUpdates) {
            updateKnowledgeBase(knowledgeUpdate);
         }
      }

      return new Justification(valid, reasoning);
   }

   private Justification performDesignLogic(@NotNull InstantiatedGameAction instGameAction, @NotNull EnhancedGameDesignAction designAction) {
      List<Condition> designConditions = designAction.getPreconditions();
      List<KnowledgeUpdate> designUpdates = designAction.getUpdateState();
      String placeholderMessage = designAction.getMessage();
      Justification justification =
          conditionallyPerformAction(designConditions, instGameAction.getArguments(), placeholderMessage, designUpdates);
      return justification;
   }


   protected Justification performImplementedLogic(@NotNull InstantiatedGameAction gameAction) {
      ActionFormat actionFormat = gameAction.getAbstractActionFormat();
      // If action is implemented
      List<String> nouns = gameAction.getArguments();
      Justification justification;
      if (implementedConditionsMap.containsKey(actionFormat)) {
         List<Condition> conditions = implementedConditionsMap.get(actionFormat);
         // TODO: Encapsulate this in a method that can be used in EnhancedGameDesignAction as well
         String successMessage = implementedSuccessMessageMap.get(actionFormat);
         List<KnowledgeUpdate> knowledgeUpdates = implementedKnowledgeUpdateMap.getOrDefault(actionFormat, new ArrayList<>());
         justification = conditionallyPerformAction(conditions, nouns, successMessage, knowledgeUpdates);
      } else {
         justification = new Justification(true, "");
      }
      return justification;
   }

   @Override
   public String progressStory(@NotNull InstantiatedGameAction gameAction) {
      String message = "";
      // if it returns a healthy String message, prepend that and let the GameDesignAction continue

      Justification implJust = performImplementedLogic(gameAction);
      if (!implJust.isAccepted()) { // Implemented but fails
         return message;
      } else { // Implemented and accepts or not implemented
         message = implJust.getReasoning();
      }

      // Then check the GameDesignActions and prepend another message
      EnhancedGameDesignAction enhancedGameDesignAction = getGameDesignAction(gameAction, currentRoom);

      if (enhancedGameDesignAction == null) {
         if (message.equals("")) { // It's an implemented action
            return "You can't do that right now";
         } else { // It's implemented but not designed
            return message + "Nothing important happens.";
         }
      }
      Justification designJust = performDesignLogic(gameAction, enhancedGameDesignAction);
      message += designJust.getReasoning();
      return message;
   }

   protected EnhancedGameDesignAction getGameDesignAction(InstantiatedGameAction gameAction, Room currentRoom) {
      if (designerActions.containsKey(currentRoom)) {
         Map<InstantiatedGameAction, EnhancedGameDesignAction> gameDesignActions = designerActions.get(currentRoom);
         if (gameDesignActions.containsKey(gameAction)) {
            return gameDesignActions.get(gameAction);
         }
      }
      return null;
   }
}
