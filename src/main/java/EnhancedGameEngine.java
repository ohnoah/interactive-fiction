import com.enhanced.EnhancedGameDesignAction;
import com.enhanced.reasoning.*;
import com.enhanced.reasoning.exceptions.*;
import com.shared.*;
import gherkin.lexer.Kn;
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
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.antlr.v4.runtime.misc.ParseCancellationException;
import org.jetbrains.annotations.NotNull;

public class EnhancedGameEngine extends GameEngine implements Serializable {
   private static final long serialVersionUID = 945796226650933506L;
   private Map<Room, Map<InstantiatedGameAction, EnhancedGameDesignAction>> designerActions;
   private KnowledgeBase knowledgeBase;
   // Implemented actions stuff
   private static Map<ActionFormat, List<Condition>> implementedConditionsMap;
   private static Map<ActionFormat, String> implementedSuccessMessageMap;
   private static Map<ActionFormat, List<KnowledgeUpdate>> implementedKnowledgeUpdateMap;
   private static boolean firstError = true;
   private static String errorLogHeader = "\n" + DateTimeFormatter.ofPattern("yyyyMMdd-HH:mm").format(LocalDateTime.now()) + "\n";
   private static String errorLogFName = "error-log-game.txt";
   private Map<String, Item> inventoryItems;

   static {
      // Initialize maps for implementedLogic
      implementedConditionsMap = new HashMap<>();
      implementedSuccessMessageMap = new HashMap<>();
      implementedKnowledgeUpdateMap = new HashMap<>();

      /* PUT IN
      --------
       */

      {
         ActionFormat putIn = new ActionFormat("put", "put ([\\w\\s]+) in ([\\w\\s]+)$");
         Condition putConditionNotContained0 = new Condition("NOT _arg0::isContained",
             "The _arg0 is already inside of something.");
         Condition putConditionIsContainer = new Condition("_arg1::isContainer",
             "You can't do that because _arg1 is not a container.");
         Condition putConditionVolume = new Condition("_arg0::volume <= _arg1::internalVolume",
             "The _arg1 is not big enough to contain the _arg0.");
         Condition putConditionNotContained1 = new Condition("NOT _arg1::isContained",
             "You can't do that because _arg1 is inside of something.");
         Condition putConditionMass = new Condition("_world::liftingPower >= _arg0::mass",
             "The _arg0 is too heavy for you to put in the _arg1.");
         // We can use knowledgeEngine constructs here

         implementedSuccessMessageMap.put(putIn, "You put the _arg0 in the _arg1.");
         implementedConditionsMap.put(putIn, List.of(putConditionNotContained0,
             putConditionIsContainer, putConditionVolume,
             putConditionNotContained1, putConditionMass));
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
      }


      /* PUT ON
      --------
       */
      {
         ActionFormat putOn = new ActionFormat("put", "put ([\\w\\s]+) on ([\\w\\s]+)$");
         Condition pushConditionSolid = new Condition("_arg0::state = \"solid\"",
             "You can't put the _arg0 anywhere because it's not solid.");
         Condition pushConditionNotContained = new Condition("NOT _arg0::isContained",
             "The _arg0 is too heavy for you to carry.");
         Condition pushConditionMass = new Condition("_world::liftingPower >= _arg0::mass",
             "The _arg0 is too heavy for you to put on the _arg1.");
         implementedConditionsMap.put(putOn, List.of(pushConditionSolid, pushConditionNotContained, pushConditionMass));
         implementedSuccessMessageMap.put(putOn, "You push the _arg0.");
      }

      /* REMOVE
      --------
       */

      {
         ActionFormat remove = new ActionFormat("remove", "remove ([\\w\\s]+) from ([\\w\\s]+)$");

         Condition removeConditionIsContained0 = new Condition("_arg0::isContained",
             "The _arg0 is not inside of anything.");
         Condition removeConditionSolid = new Condition("_arg0::state = \"solid\"",
             "You can't remove the _arg0 because it's not solid.");
         Condition removeConditionIsContained1 = new Condition("NOT _arg1::isContained",
             "The _arg1 is inside of something so you can't remove _arg0 from it.");
         Condition removeConditionIsContainer = new Condition("_arg1::isContainer",
             "The _arg0 is not inside of the _arg1 because _arg1 doesn't have things inside of it.");
         Condition removeConditionContains = new Condition("\"_arg0\" IN _arg1::contains",
             "The _arg0 is not inside of the _arg1");
         Condition removeConditionMass = new Condition("_world::liftingPower >= _arg0::mass",
             "The _arg0 is too heavy for you to remove from the _arg1.");

         implementedConditionsMap.put(remove, List.of(removeConditionIsContained0, removeConditionSolid, removeConditionIsContained1,
             removeConditionIsContainer, removeConditionContains, removeConditionMass));
         implementedSuccessMessageMap.put(remove, "You removed the _arg0 from the _arg1.");
         try {
            KnowledgeUpdate removePlusVolume = new KnowledgeUpdate("_arg1::internalVolume += _arg0::volume");
            KnowledgeUpdate removeContains = new KnowledgeUpdate("_arg1::contains -= _arg0");
            KnowledgeUpdate removeContained = new KnowledgeUpdate("_arg0::isContained := FALSE");
            implementedKnowledgeUpdateMap.put(remove, List.of(removePlusVolume, removeContains, removeContained));
         } catch (KnowledgeException e) {
            printExceptionToLog(e);
         }
      }

      /* TAKE
      --------
       */

      {
         ActionFormat take = new ActionFormat("take", null);
         Condition takeConditionTaken = new Condition("NOT (\"_arg0\" IN world::inventory)",
             "The _arg0 is already on your person.");
         Condition takeConditionSolid = new Condition("_arg0::state = \"solid\"",
             "You can't take the _arg0 because it's not solid.");
         Condition takeConditionIsTakeable = new Condition("_arg0::isTakeable",
             "You can't take the _arg0 right now.");
         Condition takeConditionNotContained = new Condition("NOT _arg0::isContained",
             "The _arg0 is inside of something else.");
         Condition takeConditionMass = new Condition("_world::liftingPower >= _arg0::mass",
             "The _arg0 is too heavy for you to carry.");
         implementedConditionsMap.put(take, List.of(takeConditionTaken, takeConditionSolid, takeConditionIsTakeable, takeConditionNotContained, takeConditionMass));
         implementedSuccessMessageMap.put(take, "You take the _arg0.");
         try {
            KnowledgeUpdate takeInventory = new KnowledgeUpdate("world::inventory += _arg0");
            implementedKnowledgeUpdateMap.put(take, List.of(takeInventory));
         } catch (KnowledgeException e) {
            printExceptionToLog(e);
         }
      }


      /* PUSH
      --------
      */
      {
         ActionFormat push = new ActionFormat("push", null);
         Condition pushConditionSolid = new Condition("_arg0::state = \"solid\"",
             "You can't push the _arg0 because it's not solid.");
         Condition pushConditionNotContained = new Condition("NOT _arg0::isContained",
             "The _arg0 is inside of something else.");
         Condition pushConditionMass = new Condition("_world::liftingPower >= _arg0::mass",
             "The _arg0 is too heavy for you to push.");
         implementedConditionsMap.put(push, List.of(pushConditionSolid, pushConditionNotContained, pushConditionMass));
         implementedSuccessMessageMap.put(push, "You push the _arg0.");
      }
      /* PULL
      --------
      */
      {
         ActionFormat pull = new ActionFormat("pull", null);
         Condition pullConditionSolid = new Condition("_arg0::state = \"solid\"",
             "You can't pull the _arg0 because it's not solid.");
         Condition pullConditionNotContained = new Condition("NOT _arg0::isContained",
             "The _arg0 is inside of something else.");
         Condition pullConditionMass = new Condition("_world::liftingPower >= _arg0::mass",
             "The _arg0 is too heavy for you to pull.");
         implementedConditionsMap.put(pull, List.of(pullConditionSolid, pullConditionNotContained, pullConditionMass));
         implementedSuccessMessageMap.put(pull, "You pull the _arg0.");
      }

      /* DROP
      --------
       */
      {
         ActionFormat drop = new ActionFormat("drop", null);
         Condition dropConditionTaken = new Condition("\"_arg0\" IN world::inventory",
             "You can't drop the _arg0 because you haven't picked it up.");
         implementedConditionsMap.put(drop, List.of(dropConditionTaken));
         implementedSuccessMessageMap.put(drop, "You drop the _arg0 next to you.");
         try {
            KnowledgeUpdate dropInventory = new KnowledgeUpdate("world::inventory -= _arg0");
            implementedKnowledgeUpdateMap.put(drop, List.of(dropInventory));
         } catch (KnowledgeException e) {
            printExceptionToLog(e);
         }
      }

      /* TURN
      --------
       */
      {
         ActionFormat turn = new ActionFormat("turn", null);
         Condition turnConditionNotContained = new Condition("NOT _arg0::isContained",
             "The _arg0 is inside of something else.");
         Condition turnConditionSolid = new Condition("_arg0::state = \"solid\"",
             "You can't turn the _arg0 because it's not solid.");
         implementedConditionsMap.put(turn, List.of(turnConditionNotContained, turnConditionSolid));
         implementedSuccessMessageMap.put(turn, "You turn the _arg0.");
      }
      
      /* search
      --------
       */
      {
         ActionFormat search = new ActionFormat("search", null);
         Condition searchConditionNotContained = new Condition("NOT _arg0::isContained",
             "The _arg0 is inside of something else.");
         Condition searchConditionSolid = new Condition("_arg0::state = \"solid\"",
             "You can't search the _arg0 because it's not solid.");
         implementedConditionsMap.put(search, List.of(searchConditionNotContained, searchConditionSolid));
         implementedSuccessMessageMap.put(search, "You search the _arg0.");
      }

      /* search
      --------
       */
      {
         ActionFormat search = new ActionFormat("search", null);
         Condition searchConditionNotContained = new Condition("NOT _arg0::isContained",
             "The _arg0 is inside of something else.");
         Condition searchConditionSolid = new Condition("_arg0::state = \"solid\"",
             "You can't search the _arg0 because it's not solid.");
         implementedConditionsMap.put(search, List.of(searchConditionNotContained, searchConditionSolid));
         implementedSuccessMessageMap.put(search, "You search the _arg0.");
      }
      

   }


   public EnhancedGameEngine() {
      super();
      this.designerActions = new HashMap<>();
      this.knowledgeBase = new KnowledgeBase();
      this.inventoryItems = new HashMap<>();
      SpecificFrame worldFrame = new SpecificFrame("world");
      worldFrame.updateFiller("room", "");
      worldFrame.updateFiller("inventory", new ArrayList<>());
      worldFrame.updateFiller("liftingPower", 100.0);
      this.knowledgeBase.addSpecificFrame(worldFrame);

      // ADD parents here
      {
         GenericFrame nonContainer = new GenericFrame("nonContainer");
         GenericFrame container = new GenericFrame("container");
         GenericFrame massive = new GenericFrame("massive");
         GenericFrame voluminous = new GenericFrame("voluminous");
         GenericFrame takeable = new GenericFrame("takeable");
         // DEFAULT
         nonContainer.addSlots(Map.of("isContained", false,
             "isContainer", false,
             "state", "solid",
             "isTakeable", false
         ));
         container.addSlots(Map.of("isContained", false,
             "isContainer", true,
             "volume", 50.0,
             "internalVolume", 50.0,
             "contains", new ArrayList<>()
         ));
         massive.addSlot("mass", 50.0);
         voluminous.addSlot("volume", 50.0);
         takeable.addSlot("isTakeable", true);
         knowledgeBase.addGenericFrame(nonContainer);
         knowledgeBase.addGenericFrame(container);
         knowledgeBase.addGenericFrame(massive);
         knowledgeBase.addGenericFrame(voluminous);
         knowledgeBase.addGenericFrame(takeable);
      }

   }

   private String notDesignedImplementedFollow(String message) {
      if (message.contains("You pull") || message.contains("You push")) {
         return message.substring(0, message.length() - 1) + " slightly but nothing interesting happens so you put it back.";
      }
      return message + " Nothing important happens.";
   }

   @Override
   public String progressStory(@NotNull InstantiatedGameAction gameAction) {
      String message = "";
      // if it returns a healthy String message, prepend that and let the GameDesignAction continue

      Justification implJust = performImplementedLogic(gameAction);
      message = capitalize(implJust.getReasoning());
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
            return notDesignedImplementedFollow(message);
         }
      }
      Justification designJust = performDesignLogic(gameAction, enhancedGameDesignAction);
      message += capitalize(designJust.getReasoning());
      return message.trim();
   }

   public KnowledgeBase getKnowledgeBase() {
      return knowledgeBase;
   }

   public Map<String, Item> globalItems() {
      return worldRooms.stream().map(Room::getItems).flatMap(Collection::stream).collect(Collectors.toMap(Item::getName, i -> i));
   }

   @Override
   public Set<Item> possibleItems() {
      Set<Item> possibleItems = new HashSet<>(currentRoom.getItems());
/*      try {
         inventory = knowledgeBase.queryStringList("world", "inventory");
         Map<String, Item> globalItems = this.globalItems();
         Set<Item> inventoryItems = inventory.stream().map(s -> globalItems.getOrDefault(s, null)).collect(Collectors.toSet());
         if (inventoryItems.contains(null)) {
            printToErrorLog("Null in inventory items");
         }*/
      possibleItems.addAll(this.inventoryItems.values());

  /*    } catch (KnowledgeException | MissingKnowledgeException e) {
         printToErrorLog("This should never happen because inventory is always defined.");
         printExceptionToLog(e);
      }
   */
      return possibleItems;
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
      String newBooleanExpr = replaceArgsWithNouns(condition.getBooleanExpr(), nouns, "-", "");
      String newFailureMessage = replaceArgsWithNouns(condition.getFailureMessage(), nouns, " ");
      /*newBooleanExpr = newBooleanExpr.replaceAll(KnowledgeRegex.loneFrameNameExpr, "\"$1\"");*/
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
      else if (newKnowledgeUpdate.getSettingType() == KnowledgeUpdate.SettingType.CONSTANT) {
         Object updateConstant = newKnowledgeUpdate.getUpdateConstant();
         if (updateConstant instanceof String) {
            newKnowledgeUpdate.setUpdateConstant(replaceArgsWithNouns((String) updateConstant, nouns));
         }
      }
      return newKnowledgeUpdate;
   }

   protected String replaceArgsWithNouns(@NotNull String s, @NotNull List<String> nouns) {
      return this.replaceArgsWithNouns(s, nouns, "-", "");
   }

   protected String replaceArgsWithNouns(@NotNull String s, @NotNull List<String> nouns, @NotNull String spaceReplacer) {
      return this.replaceArgsWithNouns(s, nouns, spaceReplacer, "");
   }

   protected String replaceArgsWithNouns(@NotNull String s, @NotNull List<String> nouns, String spaceReplacer, String quotation) {
      String newString = s;
      for (int i = 0; i < nouns.size(); i++) {
         String argString = "_arg" + i + "::";
         String nounNoSpaces = nouns.get(i).replace(" ", spaceReplacer) + "::";
         if (newString.contains(argString)) {
            newString = newString.replaceAll(argString, nounNoSpaces);
         }
      }
      for (int i = 0; i < nouns.size(); i++) {
         String argString = "arg" + i + "::";
         String nounNoSpaces = nouns.get(i).replace(" ", spaceReplacer) + "::";
         if (newString.contains(argString)) {
            newString = newString.replaceAll(argString, nounNoSpaces);
         }
      }
      for (int i = 0; i < nouns.size(); i++) {
         String argString = "_arg" + i;
         String nounNoSpaces = quotation + nouns.get(i).replace(" ", spaceReplacer) + quotation;
         if (newString.contains(argString)) {
            newString = newString.replaceAll(argString, nounNoSpaces);
         }
      }
      for (int i = 0; i < nouns.size(); i++) {
         String argString = "arg" + i;
         String nounNoSpaces = quotation + nouns.get(i).replace(" ", spaceReplacer) + quotation;
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
      Object moveTo;
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

      if (knowledgeBase.frameNameEquals(knowledgeUpdate.getFrameToUpdate(), "world") &&
          knowledgeBase.frameNameEquals(knowledgeUpdate.getSlotToUpdate(), "inventory")) {
         updateInventoryWithKnowledgeUpdate(knowledgeUpdate);
      }
   }

   private void updateInventoryWithKnowledgeUpdate(KnowledgeUpdate knowledgeUpdate) {
      Object item;
      if (knowledgeUpdate.getSettingType() == KnowledgeUpdate.SettingType.CONSTANT) {
         item = knowledgeUpdate.getUpdateConstant();
      }
      else if (knowledgeUpdate.getSettingType() == KnowledgeUpdate.SettingType.FRAME) {
         item = (knowledgeUpdate.getForeignFrame());
      }
      else {
         try {
            item = knowledgeBase.query(knowledgeUpdate.getForeignFrame(), knowledgeUpdate.getForeignSlot());
         } catch (KnowledgeException | MissingKnowledgeException e) {
            printExceptionToLog(e);
            printToErrorLog("Failed to add inventory or subtract");
            return;
         }
      }
      Item itemInRoom;
      if (item instanceof String) {
         if (knowledgeUpdate.getUpdateType() == UpdateType.ADD) {
            itemInRoom = currentRoom.getItems().stream().filter(i -> i.getName().equals(item)).findAny().orElse(null);
            if (itemInRoom == null) {
               printToErrorLog(item + " is an invalid item that was attempted to be removed from inventory or added to.");
               return;
            }
            this.inventoryItems.put(itemInRoom.getName(), itemInRoom);
            currentRoom.removeItem(itemInRoom);
         }
         else if (knowledgeUpdate.getUpdateType() == UpdateType.SUBTRACT) {
            Item returned = this.inventoryItems.remove(item);
            if (returned != null) {
               currentRoom.addItem(returned);
            }
            else {
               printToErrorLog("Tried to remove item not in inventory");
            }
         }
         else{
            printToErrorLog("Wrong Update type when updating items for world");
         }
      }
      else {
         printToErrorLog("updateKnowledgeBase call for " + knowledgeUpdate.toString() +
             " failed due to wrong type of item");
         return;
      }


   }

   public void updateKnowledgeBase(@NotNull KnowledgeUpdate... knowledgeUpdates) {
      for (KnowledgeUpdate knowledgeUpdate : knowledgeUpdates) {
         updateSingleKnowledgeBase(knowledgeUpdate);
      }
   }

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
         } catch (ParseCancellationException | KnowledgeException e) {
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

   private static String capitalize(String s) {
      if (s.length() > 0) {
         return s.substring(0, 1).toUpperCase() + s.substring(1);
      }
      else {
         return s;
      }
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
            knowledgeBase.createSpecificFrame(i, "nonContainer", "massive");
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

   @Override
   public String toString() {
      return "EnhancedGameEngine{" +
          "designerActions=" + designerActions +
          ", knowledgeBase=" + knowledgeBase +
          ", worldRooms=" + worldRooms +
          ", currentRoom=" + currentRoom +
          '}';
   }

   public boolean addParent(String child, String parent) {
      Map<String, SpecificFrame> specificFrameMap = this.knowledgeBase.getSpecificFrames();
      Map<String, GenericFrame> genericFrameMap = this.knowledgeBase.getGenericFrames();
      if(specificFrameMap.containsKey(child)){
         if(genericFrameMap.containsKey(parent)){
            specificFrameMap.get(child).addParent(genericFrameMap.get(parent));
            return true;
         }
         return false;
      }
      return false;
   }
}
