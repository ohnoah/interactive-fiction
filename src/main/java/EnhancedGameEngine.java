import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.jetbrains.annotations.NotNull;

public class EnhancedGameEngine extends GameEngine implements Serializable {
   private static final long serialVersionUID = -8553667082678456914L;
   private Map<Room, Map<InstantiatedGameAction, EnhancedGameDesignAction>> designerActions;
   private KnowledgeBase knowledgeBase;
   // Implemented actions stuff
   private static Map<ActionFormat, List<Condition>> implementedConditionsMap;
   private static Map<ActionFormat, String> implementedSuccessMessageMap;
   private static Map<ActionFormat, List<KnowledgeUpdate>> implementedKnowledgeUpdateMap;
   private String errorLogFName = "error-log-" + DateTimeFormatter.ofPattern("yyyy/MM/dd-HH:mm").format(LocalDateTime.now());

   static {
      ActionFormat putIn = new ActionFormat("put", "put ([\\w\\s]+) in ([\\w\\s]+)$");
      Condition putConditionIsContainer = new Condition("_arg2::isContainer",
          "You can't do that because _arg2 is not a container");
      Condition putConditionVolume = new Condition("_arg1::volume <= _arg2::volume",
          "_arg2 is not big enough to contain _arg1");
      // We can use knowledgeEngine constructs here
      implementedSuccessMessageMap.put(putIn, "You put the smaller _arg1 in _arg2");
      implementedConditionsMap.put(putIn, List.of(putConditionIsContainer, putConditionVolume));
      // TODO: Create KnowledgeUpdate to subtract from the volume, add _arg1 to _arg2's contains
      // TODO: and add _arg2 to _arg2's inside field.


      ActionFormat remove = new ActionFormat("remove", "remove ([\\w\\s]+) from ([\\w\\s]+)$");
   }


   @Override
   public Set<Item> possibleItems() {
      return currentRoom.getItems();
   }

   public EnhancedGameEngine() {
      this.knowledgeBase = new KnowledgeBase();
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
      try {
         knowledgeBase.update(knowledgeUpdate);
      } catch (KnowledgeException e) {
         printExceptionToLog(e);
      }
      if (knowledgeBase.frameNameEquals(knowledgeUpdate.getForeignFrame(), "world") &&
          knowledgeBase.frameNameEquals(knowledgeUpdate.getForeignSlot(), "room")) {
         if (!knowledgeUpdate.getUpdateType().equals(UpdateType.SET)) {
            this.printToErrorLog("Treating non-setting as setting because this is current room");
         }
         Object moveTo = null;
         if (knowledgeUpdate.isConstantUpdate()) {
            moveTo = knowledgeUpdate.getUpdateConstant();
         }
         else {
            try {
               moveTo = knowledgeBase.query(knowledgeUpdate.getFrameToUpdate(), knowledgeUpdate.getSlotToUpdate());
            } catch (KnowledgeException e) {
               this.printExceptionToLog(e);
               this.printToErrorLog("Failed to move room");
               return;
            }
         }
         if (moveTo instanceof String) {
            boolean success = moveRoom((String) moveTo);
            if (!success) {
               printToErrorLog("updateKnowledgeBase call for " + knowledgeUpdate.toString() +
                   " failed due to non-existent room name");
            }
         }
         else {
            printToErrorLog("updateKnowledgeBase call for " + knowledgeUpdate.toString() +
                " failed due to wrong type in room");
         }
      }
   }

   private void printToErrorLog(String s) {
      try {
         File file = new File(errorLogFName);
         file.createNewFile();
         Files.write(file.toPath(), s.getBytes(), StandardOpenOption.APPEND);
      } catch (IOException e) {
         System.err.println("Couldn't write to error");
         System.err.println(s);
         e.printStackTrace();
      }
   }

   private void printExceptionToLog(KnowledgeException e) {
      try {
         FileWriter fw = new FileWriter(errorLogFName, true);
         PrintWriter pw = new PrintWriter(fw);
         e.printStackTrace (pw);
      } catch (IOException openException) {
         System.err.println("Couldn't write to error");
         e.printStackTrace();
         openException.printStackTrace();
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
            if (knowledgeBase.conditionFails(condition.getBooleanExpr())) {
               valid = false;
               reasoning = knowledgeBase.fillQueryString(condition.getFailureMessage());
               break;
            }
         } catch (KnowledgeException e) {
            valid = false;
            reasoning = "There was an error behind the scenes. Try performing another action.";
            // TODO: Print stack trace using PrintStream
            this.printExceptionToLog(e);
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
      return conditionallyPerformAction(designConditions, instGameAction.getArguments(), placeholderMessage, designUpdates);
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
      }
      else {
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
      }
      else { // Implemented and accepts or not implemented
         message = implJust.getReasoning();
      }

      // Then check the GameDesignActions and prepend another message
      EnhancedGameDesignAction enhancedGameDesignAction = getGameDesignAction(gameAction, currentRoom);

      if (enhancedGameDesignAction == null) {
         if (message.equals("")) { // It's an implemented action
            return "You can't do that right now";
         }
         else { // It's implemented but not designed
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
