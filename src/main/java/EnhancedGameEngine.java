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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.jetbrains.annotations.NotNull;

public class EnhancedGameEngine extends GameEngine implements Serializable {
   private static final long serialVersionUID = 4644570525716437816L;
   private Map<Room, Map<InstantiatedGameAction, EnhancedGameDesignAction>> designerActions;
   private KnowledgeBase knowledgeBase;
   // Implemented actions stuff
   private static Map<ActionFormat, List<Condition>> implementedConditionsMap;
   private static Map<ActionFormat, String> implementedSuccessMessageMap;
   private static Map<ActionFormat, List<KnowledgeUpdate>> implementedKnowledgeUpdateMap;
   private static boolean firstError = true;
   private static String errorLogHeader = "\n" + DateTimeFormatter.ofPattern("yyyyMMdd-HH:mm").format(LocalDateTime.now()) + "\n";
   private static String errorLogFName = "error-log-game.txt";

   static {
      // Initialize maps for implementedLogic
      implementedConditionsMap = new HashMap<>();
      implementedSuccessMessageMap = new HashMap<>();
      implementedKnowledgeUpdateMap = new HashMap<>();

      ActionFormat putIn = new ActionFormat("put", "put ([\\w\\s]+) in ([\\w\\s]+)$");
      Condition putConditionIsContainer = new Condition("_arg1::isContainer",
          "You can't do that because _arg1 is not a container.");
      Condition putConditionVolume = new Condition("_arg0::volume <= _arg1::internalVolume",
          "_arg1 is not big enough to contain _arg0.");
      Condition putConditionNotContained = new Condition("NOT _arg0::isContained",
          "_arg0 is already inside of something.");
      // We can use knowledgeEngine constructs here

      implementedSuccessMessageMap.put(putIn, "You put the _arg0 in the _arg1.");
      implementedConditionsMap.put(putIn, List.of(putConditionIsContainer, putConditionVolume, putConditionNotContained));
      // TODO: Create KnowledgeUpdate to subtract from the internalVolume, add _arg1 to _arg2's contains
      // TODO: and add _arg2 to _arg2's inside field.
      try {
         KnowledgeUpdate putMinusVolume = new KnowledgeUpdate("_arg1::internalVolume -= _arg0::volume");
         KnowledgeUpdate putContains = new KnowledgeUpdate("_arg1::contains += _arg0");
         KnowledgeUpdate putContained = new KnowledgeUpdate("_arg0::isContained := TRUE");
         implementedKnowledgeUpdateMap.put(putIn, List.of(putMinusVolume, putContains, putContained));
      } catch (KnowledgeException e) {
         printExceptionToLog(e);
      }

      ActionFormat remove = new ActionFormat("remove", "remove ([\\w\\s]+) from ([\\w\\s]+)$");
   }


   public EnhancedGameEngine() {
      super();
      this.designerActions = new HashMap<>();
      this.knowledgeBase = new KnowledgeBase();
      SpecificFrame worldFrame = new SpecificFrame("world");
      worldFrame.updateFiller("room", "");
      this.knowledgeBase.addSpecificFrame(worldFrame);
   }

   @Override
   public Set<Item> possibleItems() {
      return currentRoom.getItems();
   }

   public void setCurrentRoom(Room newRoom) {
      this.currentRoom = newRoom;
      try {
         this.updateSingleKnowledgeBase(new KnowledgeUpdate(String.format("_world::room := \"%s\"", currentRoom.getName())));
      } catch (KnowledgeException e) {
         printExceptionToLog(e);
      }
   }

   protected boolean conditionSucceeds(String condition) throws KnowledgeException, MissingKnowledgeException {
      return knowledgeBase.conditionSucceeds(condition);
   }


   protected Condition fillConditionWithArgs(@NotNull Condition condition, @NotNull List<String> nouns) {
      String newBooleanExpr = replaceArgsWithNouns(condition.getBooleanExpr(), nouns);
      String newFailureMessage = replaceArgsWithNouns(condition.getFailureMessage(), nouns);
      return new Condition(newBooleanExpr, newFailureMessage);
   }

   private KnowledgeUpdate fillKnowledgeUpdateWithArgs(KnowledgeUpdate knowledgeUpdate, List<String> nouns) {
      KnowledgeUpdate newKnowledgeUpdate = new KnowledgeUpdate(knowledgeUpdate);
      newKnowledgeUpdate.setFrameToUpdate(replaceArgsWithNouns(newKnowledgeUpdate.getFrameToUpdate(), nouns));
      newKnowledgeUpdate.setSlotToUpdate(replaceArgsWithNouns(newKnowledgeUpdate.getSlotToUpdate(), nouns));
      if (newKnowledgeUpdate.getSettingType() == KnowledgeUpdate.SettingType.KNOWLEDGE) {
         String foreignFrame = newKnowledgeUpdate.getForeignFrame();
         newKnowledgeUpdate.setForeignFrame(replaceArgsWithNouns(foreignFrame, nouns));
         String foreignSlot = newKnowledgeUpdate.getForeignSlot();
         newKnowledgeUpdate.setForeignSlot(replaceArgsWithNouns(foreignSlot, nouns));
      }
      else if (newKnowledgeUpdate.getSettingType() == KnowledgeUpdate.SettingType.FRAME) {
         String foreignFrame = newKnowledgeUpdate.getForeignFrame();
         newKnowledgeUpdate.setForeignFrame(replaceArgsWithNouns(foreignFrame, nouns));
      }
      return newKnowledgeUpdate;
   }

   protected String replaceArgsWithNouns(@NotNull String s, @NotNull List<String> nouns) {
      return this.replaceArgsWithNouns(s, nouns, "-");
   }

   protected String replaceArgsWithNouns(@NotNull String s, @NotNull List<String> nouns, String spaceReplacer) {
      String newString = s;
      for (int i = 0; i < nouns.size(); i++) {
         String argString = "_arg" + i;
         String nounNoSpaces = nouns.get(i).replace(" ", spaceReplacer);
         if (newString.contains(argString)) {
            newString = newString.replaceAll(argString, nounNoSpaces);
         }
      }
      for (int i = 0; i < nouns.size(); i++) {
         String argString = "arg" + i;
         String nounNoSpaces = nouns.get(i).replace(" ", spaceReplacer);
         if (newString.contains(argString)) {
            newString = newString.replaceAll(argString, nounNoSpaces);
         }
      }
      return newString;
   }

   private void updateRoomWithKnowledgeUpdate(@NotNull KnowledgeUpdate knowledgeUpdate) {
      if (!knowledgeUpdate.getUpdateType().equals(UpdateType.SET)) {
         printToErrorLog("Treating non-setting as setting because this is current room");
      }
      Object moveTo = null;
      if (knowledgeUpdate.getSettingType() == KnowledgeUpdate.SettingType.CONSTANT) {
         moveTo = knowledgeUpdate.getUpdateConstant();
      }
      else if (knowledgeUpdate.getSettingType() == KnowledgeUpdate.SettingType.FRAME) {
         // TODO: This case doesn't really make sense
         moveTo = (knowledgeUpdate.getForeignFrame());
      }
      else {
         try {
            moveTo = knowledgeBase.query(knowledgeUpdate.getForeignFrame(), knowledgeUpdate.getForeignSlot());
         } catch (KnowledgeException | MissingKnowledgeException e) {
            printExceptionToLog(e);
            printToErrorLog("Failed to move room");
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

   // TODO: This is where we intercept calls and do IF-CHANGED PROCEDURES
   private void updateSingleKnowledgeBase(@NotNull KnowledgeUpdate knowledgeUpdate) {
      try {
         knowledgeBase.update(knowledgeUpdate);
      } catch (KnowledgeException | MissingKnowledgeException e) {
         printExceptionToLog(e);
         return;
      }
      if (knowledgeBase.frameNameEquals(knowledgeUpdate.getFrameToUpdate(), "world") &&
          knowledgeBase.frameNameEquals(knowledgeUpdate.getSlotToUpdate(), "room")) {
         updateRoomWithKnowledgeUpdate(knowledgeUpdate);
      }
   }

   public void updateKnowledgeBase(@NotNull KnowledgeUpdate... knowledgeUpdates) {
      for (KnowledgeUpdate knowledgeUpdate : knowledgeUpdates) {
         updateSingleKnowledgeBase(knowledgeUpdate);
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
         // replace _arg something in the string
         Condition populatedCondition = fillConditionWithArgs(condition, nouns);
         try {
            if (!knowledgeBase.conditionSucceeds(populatedCondition.getBooleanExpr())) {
               valid = false;
               reasoning = knowledgeBase.fillQueryString(populatedCondition.getFailureMessage());
               break;
            }
         } catch (KnowledgeException e) {
            valid = false;
            reasoning = "There was an error behind the scenes. Try performing another action.";
            printExceptionToLog(e);
            break;
         } catch (MissingKnowledgeException e) {
            valid = false;
            reasoning = e.getMissingString();
            printExceptionToLog(e);
            break;
         }
      }
      if (valid) {
         String populatedSuccessMessage = replaceArgsWithNouns(successMessage, nouns, " ");

         for (KnowledgeUpdate knowledgeUpdate : knowledgeUpdates) {
            KnowledgeUpdate populatedKnowledgeUpdate = fillKnowledgeUpdateWithArgs(knowledgeUpdate, nouns);
            updateSingleKnowledgeBase(populatedKnowledgeUpdate);
         }

         reasoning = knowledgeBase.fillQueryString(populatedSuccessMessage);

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
      message = implJust.getReasoning();
      if (!implJust.isAccepted()) { // Implemented but fails
         return implJust.getReasoning();
      }
      // Then check the GameDesignActions and prepend another message
      EnhancedGameDesignAction enhancedGameDesignAction = getGameDesignAction(gameAction, currentRoom);

      if (enhancedGameDesignAction == null) {
         if (message.equals("")) { // It's not an implemented action
            return "You can't do that right now";
         }
         else { // It's implemented but not designed
            return message + " Nothing important happens.";
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

   public void addAction(Room room, InstantiatedGameAction instantiatedAction, EnhancedGameDesignAction enhancedAction) {
      Map<InstantiatedGameAction, EnhancedGameDesignAction> actionsInRoom = designerActions.getOrDefault(room, new HashMap<>());
      actionsInRoom.put(instantiatedAction, enhancedAction);
   }

   // TODO: This should probably use exceptions
   public void addRoom(@NotNull Room room) {
      if (!worldRooms.contains(room)) {
         worldRooms.add(room);
         designerActions.putIfAbsent(room, new HashMap<>());

         for (Item i : room.getItems()) {
            knowledgeBase.createSpecificFrame(i);
         }
      }
   }

   private static void printToErrorLog(String s) {
      try {
         System.err.println("Writing error string to log");
         File file = new File(errorLogFName);
         file.createNewFile();
         if (firstError) {
            Files.write(file.toPath(), errorLogHeader.getBytes(), StandardOpenOption.APPEND);
         }
         firstError = false;

         Files.write(file.toPath(), (s + "\n").getBytes(), StandardOpenOption.APPEND);
      } catch (IOException e) {
         System.err.println("Couldn't write to error");
         System.err.println(s);
         e.printStackTrace();
      }
   }

   private static void printExceptionToLog(Exception e) {
      try {
         System.err.println("Writing error to log");
         File file = new File(errorLogFName);
         file.createNewFile();
         if (firstError) {
            Files.write(file.toPath(), errorLogHeader.getBytes(), StandardOpenOption.APPEND);
         }
         firstError = false;
         FileWriter fw = new FileWriter(file, true);
         PrintWriter pw = new PrintWriter(fw);
         e.printStackTrace(pw);
         Files.write(file.toPath(), (e.getMessage() + "\n").getBytes(), StandardOpenOption.APPEND);
      } catch (IOException openException) {
         System.err.println("Couldn't write to error");
         e.printStackTrace();
         openException.printStackTrace();
      }
   }

}
