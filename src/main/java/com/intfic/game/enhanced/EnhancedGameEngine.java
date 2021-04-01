package com.intfic.game.enhanced;

import com.intfic.game.enhanced.reasoning.updates.DefaultUpdateStrategy;
import com.intfic.game.enhanced.reasoning.updates.UpdateStrategy;
import com.intfic.game.enhanced.reasoning.wrappers.Condition;
import com.intfic.game.enhanced.reasoning.wrappers.Justification;
import com.intfic.game.shared.GameEngine;
import com.intfic.game.enhanced.reasoning.*;
import com.intfic.game.enhanced.reasoning.error.*;
import com.intfic.game.enhanced.reasoning.frames.GenericFrame;
import com.intfic.game.enhanced.reasoning.frames.SpecificFrame;
import com.intfic.game.enhanced.reasoning.updates.KnowledgeUpdate;
import com.intfic.game.enhanced.reasoning.updates.UpdateType;
import com.intfic.game.shared.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.antlr.v4.runtime.misc.ParseCancellationException;
import org.jetbrains.annotations.NotNull;

public class EnhancedGameEngine extends GameEngine implements Serializable {

   private static final long serialVersionUID = -4347326551883534303L;
   private Map<Room, Map<InstantiatedGameAction, EnhancedGameDesignAction>> designerActions;
   private KnowledgeBase knowledgeBase;
   private UpdateStrategy updateStrategy = new DefaultUpdateStrategy();
   private static final String DEFAULT_ERROR_MESSAGE = "You can't do that right now.";

   // Use this as a special room so that item IDs are valid before initialization

   private Map<String, Item> inventoryItems;


   public EnhancedGameEngine() {
      super();
      this.designerActions = new HashMap<>();
      this.knowledgeBase = new KnowledgeBase();
      this.inventoryItems = new HashMap<>();
      SpecificFrame worldFrame = new SpecificFrame("world");
      worldFrame.updateFiller("room", "");
      worldFrame.updateFiller("items", new ArrayList<>());
      worldFrame.updateFiller("inventory", new ArrayList<>());
      worldFrame.updateFiller("liftingPower", 100.0);
      worldFrame.updateFiller("errorMessage", DEFAULT_ERROR_MESSAGE);
      this.knowledgeBase.addSpecificFrame(worldFrame);

      for (GenericFrame g : ImplementedActionLogic.defaultGenericFrames) {
         knowledgeBase.addGenericFrame(g);
      }

   }

   private String notDesignedImplementedFollow(String message) {
      if (message.contains("You pull")) {
         return message.substring(0, message.length() - 1) + " slightly but nothing interesting happens so you pull it back.";
      }
      else if (message.contains("You push")) {
         return message.substring(0, message.length() - 1) + " slightly but nothing interesting happens so you push it back.";
      }
      else if (message.contains("You listen")) {
         return message.substring(0, message.length() - 1) + " but hear nothing of interest.";
      }
      else if (message.contains("You examine") || message.contains("You search")) {
         return message.substring(0, message.length() - 1) + " but find nothing of interest.";
      }
      return message + " Nothing important happens.";
   }

   @Override
   public Justification progressStory(@NotNull InstantiatedGameAction gameAction) {
      String message = "";
      // if it returns a healthy String message, prepend that and let the GameDesignAction continue
      /*Set<String> possibleItemNames = this.possibleItemNames();*/
      Set<Item> possibleItems = this.possibleItems();
      if (gameAction.getActualArguments() == null) {
         return new Justification(false, "Arguments are not initialized. Contact game admin.");
      }
      for (Item argument : gameAction.getActualArguments()) {
         if (!possibleItems.contains(argument)) {
            return new Justification(false, String.format("There is no %s in your environment.", itemNameInUserSpace(argument)));
         }
      }


      EnhancedGameDesignAction enhancedGameDesignAction = getGameDesignActions(gameAction, currentRoom);

      // dont allow purposefully designed not-allowed actions
      if (enhancedGameDesignAction != null) {
         Justification designedJustification = validatePreconditions(enhancedGameDesignAction.getPreconditions(), gameAction.getActualArguments());
         if (!designedJustification.isAccepted()) {
            return new Justification(false, designedJustification.getReasoning());
         }
      }

      // Perform implemented logic and fail fast if fails
      Justification implJust = performImplementedLogic(gameAction);
      message = capitalize(implJust.getReasoning());
      if (!implJust.isAccepted()) { // Implemented but fails
         return implJust;
      }
      // Then check the GameDesignActions and prepend another message
      if (enhancedGameDesignAction == null) {
         if (message.equals("")) { // It's not an implemented action
            String errorMessage = DEFAULT_ERROR_MESSAGE;
            try {
               errorMessage = knowledgeBase.queryString("world", "errorMessage");
            }
            catch (KnowledgeException | MissingKnowledgeException e) {
               FileErrorHandler.printToErrorLog("Error while querying dynamic errorMessage" +
                   " on world frame after non-implemented action.");
               FileErrorHandler.printExceptionToLog(e);
            }
            return new Justification(false, errorMessage);
         }
         else { // It's implemented and succeeds but not designed
            return new Justification(true, notDesignedImplementedFollow(message));
         }
      }
      // TODO: Think about edge case where the action itself breaks the precondition. That is a misdesign
      Justification designJust = performDesignLogic(gameAction, enhancedGameDesignAction);
      message += capitalize(designJust.getReasoning());
      return new Justification(true, message.trim());
   }

   public KnowledgeBase getKnowledgeBase() {
      return knowledgeBase;
   }


   // TODO: Look into if this should be a set or a map in NLPEngine
   @Override
   public Set<Item> possibleItems() {
      Set<Item> possibleItems = new HashSet<>(currentRoom.getItems().values());
      possibleItems.addAll(this.inventoryItems.values());
      return possibleItems;
   }


   public Map<String, Item> getInventoryItems() {
      return inventoryItems;
   }

   private Set<String> possibleItemNames() {
      Set<Item> possibleItems = this.possibleItems();
      return possibleItems.stream().map(Item::getName).collect(Collectors.toSet());
   }

   public void setCurrentRoom(Room newRoom) {
      this.currentRoom = newRoom;
      /*this.updateKnowledgeBase(new KnowledgeUpdate(String.format("!world::room := \"%s\"", currentRoom.getName())));*/
      this.updateKnowledgeBase(new KnowledgeUpdate(UpdateType.SET, "world", "room",
          String.format("\"%s\"", currentRoom.getName())));

   }

   public boolean conditionSucceeds(String condition) throws KnowledgeException, MissingKnowledgeException {
      return knowledgeBase.conditionSucceeds(condition);
   }

   private static String itemNameInUserSpace(Item i) {
      return i.getName();
   }

   protected Condition fillConditionWithArgs(@NotNull Condition condition, @NotNull List<Item> items) {
      List<String> itemIdentifiers = itemsToStrings(items, KnowledgeBase::getItemIdentifier);
      List<String> itemNames = itemsToStrings(items, EnhancedGameEngine::itemNameInUserSpace);

      String newBooleanExpr = replacePlaceHolderArgsWithStrings(condition.getBooleanExpr(), itemIdentifiers, "_", "");
      String newFailureMessage = replacePlaceHolderArgsWithStrings(condition.getFailureMessage(), itemIdentifiers, itemNames, " ");
      /*newBooleanExpr = newBooleanExpr.replaceAll(KnowledgeRegex.loneFrameNameExpr, "\"$1\"");*/
      return new Condition(newBooleanExpr, newFailureMessage);
   }

   private KnowledgeUpdate fillKnowledgeUpdateWithArgs(KnowledgeUpdate knowledgeUpdate, List<String> itemIdentifiers) {
      KnowledgeUpdate newKnowledgeUpdate = new KnowledgeUpdate(knowledgeUpdate);
      newKnowledgeUpdate.setFrameToUpdate(replacePlaceHolderArgsWithStrings(newKnowledgeUpdate.getFrameToUpdate(), itemIdentifiers));
      newKnowledgeUpdate.setSlotToUpdate(replacePlaceHolderArgsWithStrings(newKnowledgeUpdate.getSlotToUpdate(), itemIdentifiers));
      if (newKnowledgeUpdate.getSettingType() == KnowledgeUpdate.SettingType.KNOWLEDGE) {
         String foreignFrame = newKnowledgeUpdate.getForeignFrame();
         newKnowledgeUpdate.setForeignFrame(replacePlaceHolderArgsWithStrings(foreignFrame, itemIdentifiers));
         String foreignSlot = newKnowledgeUpdate.getForeignSlot();
         newKnowledgeUpdate.setForeignSlot(replacePlaceHolderArgsWithStrings(foreignSlot, itemIdentifiers));
      }
      else if (newKnowledgeUpdate.getSettingType() == KnowledgeUpdate.SettingType.FRAME) {
         String foreignFrame = newKnowledgeUpdate.getForeignFrame();
         newKnowledgeUpdate.setForeignFrame(replacePlaceHolderArgsWithStrings(foreignFrame, itemIdentifiers));
      }
      else if (newKnowledgeUpdate.getSettingType() == KnowledgeUpdate.SettingType.CONSTANT) {
         Object updateConstant = newKnowledgeUpdate.getUpdateConstant();
         if (updateConstant instanceof String) {
            newKnowledgeUpdate.setUpdateConstant(replacePlaceHolderArgsWithStrings((String) updateConstant, itemIdentifiers));
         }
      }
      return newKnowledgeUpdate;
   }


   protected String replacePlaceHolderArgsWithStrings(@NotNull String s, @NotNull List<String> knowledgeExprList) {
      return this.replacePlaceHolderArgsWithStrings(s, knowledgeExprList, "_", "");
   }

   protected String replacePlaceHolderArgsWithStrings(@NotNull String s, @NotNull List<String> knowledgeExprList, @NotNull List<String> frameExprList) {
      return this.replacePlaceHolderArgsWithStrings(s, knowledgeExprList, frameExprList, "_", "");
   }

   protected String replacePlaceHolderArgsWithStrings(@NotNull String s, @NotNull List<String> stringList, @NotNull String spaceReplacer, @NotNull String quotation) {
      return this.replacePlaceHolderArgsWithStrings(s, stringList, stringList, spaceReplacer, quotation);
   }

   protected String replacePlaceHolderArgsWithStrings(@NotNull String s, @NotNull List<String> knowledgeExprList, @NotNull List<String> frameExprList, @NotNull String spaceReplacer) {
      return this.replacePlaceHolderArgsWithStrings(s, knowledgeExprList, frameExprList, spaceReplacer, "");
   }

   protected String replacePlaceHolderArgsWithStrings(@NotNull String s, @NotNull List<String> stringList, @NotNull String spaceReplacer) {
      return this.replacePlaceHolderArgsWithStrings(s, stringList, stringList, spaceReplacer, "");
   }

   protected String replacePlaceHolderArgsWithStrings(@NotNull String s, @NotNull List<String> knowledgeExprReplaceList, @NotNull List<String> frameExprReplaceList,
                                                      @NotNull String spaceReplacer, @NotNull String quotationForFrameNames) {
      String newString = s;
      for (int i = 0; i < knowledgeExprReplaceList.size(); i++) {
         String argString = "!arg" + i + "::";
         String nounNoSpaces = (knowledgeExprReplaceList.get(i)).replace(" ", spaceReplacer) + "::";
         if (newString.contains(argString)) {
            newString = newString.replaceAll(argString, nounNoSpaces);
         }
      }
      for (int i = 0; i < knowledgeExprReplaceList.size(); i++) {
         String argString = "arg" + i + "::";
         String nounNoSpaces = (knowledgeExprReplaceList.get(i)).replace(" ", spaceReplacer) + "::";
         if (newString.contains(argString)) {
            newString = newString.replaceAll(argString, nounNoSpaces);
         }
      }
      for (int i = 0; i < frameExprReplaceList.size(); i++) {
         String argString = "!arg" + i;
         String nounNoSpaces = quotationForFrameNames + (frameExprReplaceList.get(i)).replace(" ", spaceReplacer) + quotationForFrameNames;
         if (newString.contains(argString)) {
            newString = newString.replaceAll(argString, nounNoSpaces);
         }
      }
      for (int i = 0; i < frameExprReplaceList.size(); i++) {
         String argString = "arg" + i;
         String nounNoSpaces = quotationForFrameNames + (frameExprReplaceList.get(i)).replace(" ", spaceReplacer) + quotationForFrameNames;
         if (newString.contains(argString)) {
            newString = newString.replaceAll(argString, nounNoSpaces);
         }
      }
      return newString;
   }


   public void updateKnowledgeBase(@NotNull KnowledgeUpdate knowledgeUpdate) {
      this.updateStrategy.updateKnowledgeBase(this, knowledgeUpdate);
   }


   public void removeItem(Item i) {
      for (Room r : this.worldRooms) {
         if (r.getItems().containsValue(i)) {
            r.removeItem(i);
         }
      }
   }


   public void updateKnowledgeBaseMultiple(@NotNull KnowledgeUpdate... knowledgeUpdates) {
      for (KnowledgeUpdate knowledgeUpdate : knowledgeUpdates) {
         updateKnowledgeBase(knowledgeUpdate);
      }
   }


   public List<String> getItemIdentifiersToDelete(KnowledgeUpdate knowledgeUpdate) {
      List<String> deleteList = new ArrayList<>();
      if (knowledgeUpdate.getUpdateType() == UpdateType.SUBTRACT && knowledgeUpdate.getFrameToUpdate().equals("world") && knowledgeUpdate.getSlotToUpdate().equals("items")) {
         try {
            return List.of((String) knowledgeBase.rhsValueFromKnowledgeUpdate(knowledgeUpdate));
         }
         catch (ClassCastException | KnowledgeException | MissingKnowledgeException e) {
            FileErrorHandler.printToErrorLog("Tried to get item to delete from knowledge update but failed");
            FileErrorHandler.printExceptionToLog(e);
         }
      }
      return deleteList;
   }


   private Justification validatePreconditions(@NotNull List<Condition> conditions, @NotNull List<Item> nouns) {
      boolean valid = true;
      String reasoning = "";

      for (Condition condition : conditions) {
         // replace !arg something in the string
         // TODO: Maybe fill items with unique noun + adjective because multiple nouns will lead to ambiguity
         Condition populatedCondition = fillConditionWithArgs(condition, nouns);
         try {
            if (!this.conditionSucceeds(populatedCondition.getBooleanExpr())) {
               valid = false;
               reasoning = knowledgeBase.fillQueryString(populatedCondition.getFailureMessage());
               break;
            }
         }
         catch (ParseCancellationException | KnowledgeException e) {
            valid = false;
            reasoning = "There was an error behind the scenes. Try performing another action.";
            FileErrorHandler.printExceptionToLog(e);
            break;
         }
         catch (MissingKnowledgeException e) {
            valid = false;
            reasoning = e.getMissingString();
            FileErrorHandler.printExceptionToLog(e);
            break;
         }
      }
      return new Justification(valid, reasoning);
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) {
         return true;
      }
      if (o == null || getClass() != o.getClass()) {
         return false;
      }
      EnhancedGameEngine that = (EnhancedGameEngine) o;
      boolean actionsEqual = designerActions.equals(that.designerActions);
      boolean kbEqual = knowledgeBase.equals(that.knowledgeBase);
      boolean inventoryEqual = inventoryItems.equals(that.inventoryItems);
      return actionsEqual && kbEqual && inventoryEqual;
   }

   @Override
   public int hashCode() {
      return Objects.hash(designerActions, knowledgeBase, inventoryItems);
   }

   @Override
   public boolean getWorldBoolean(String key) {
      try {
         return getKnowledgeBase().queryBoolean("world", key);
      }
      catch (KnowledgeException | MissingKnowledgeException e) {
         FileErrorHandler.printExceptionToLog(e);
         return false;
      }
   }

   public static long numberOfItemsWithName(@NotNull Collection<Item> items, @NotNull String name) {
      return items.stream().filter(i -> i.getName().equals(name)).count();
   }

   private static List<String> itemsToStrings(List<Item> items, Function<Item, String> fn) {
      return items.stream().map(fn).collect(Collectors.toList());
   }

   private Justification conditionallyPerformUpdates(@NotNull Justification validatePreconds,
                                                     @NotNull List<KnowledgeUpdate> knowledgeUpdates,
                                                     @NotNull String successMessage, @NotNull List<Item> nouns) {
      boolean valid = validatePreconds.isAccepted();
      String reasoning = validatePreconds.getReasoning();
      List<String> itemNames = itemsToStrings(nouns, EnhancedGameEngine::itemNameInUserSpace);
      List<String> itemIdentifiers = itemsToStrings(nouns, KnowledgeBase::getItemIdentifier);
      if (valid) {
         reasoning = replacePlaceHolderArgsWithStrings(successMessage, itemIdentifiers, itemNames, " ");
         for (KnowledgeUpdate knowledgeUpdate : knowledgeUpdates) {
            KnowledgeUpdate populatedKnowledgeUpdate = fillKnowledgeUpdateWithArgs(knowledgeUpdate, itemIdentifiers);
            // If item is removed from the world, need to fill its values before deleting it
            reasoning = knowledgeBase.fillQueryString(reasoning, getItemIdentifiersToDelete(populatedKnowledgeUpdate));
            updateKnowledgeBase(populatedKnowledgeUpdate);
         }

         reasoning = knowledgeBase.fillQueryString(reasoning);

      }
      return new Justification(valid, reasoning);
   }

   private Justification conditionallyPerformAction(@NotNull List<Condition> conditions,
                                                    @NotNull List<Item> nouns,
                                                    @NotNull String successMessage,
                                                    @NotNull List<KnowledgeUpdate> knowledgeUpdates) {
      Justification validatePreconds = validatePreconditions(conditions, nouns);
      return conditionallyPerformUpdates(validatePreconds, knowledgeUpdates, successMessage, nouns);
   }


   private Justification performDesignLogic(@NotNull InstantiatedGameAction instGameAction, @NotNull EnhancedGameDesignAction designAction) {
      List<Condition> designConditions = designAction.getPreconditions();
      List<KnowledgeUpdate> designUpdates = designAction.getUpdateState();
      String placeholderMessage = designAction.getMessage();
      return conditionallyPerformAction(designConditions, instGameAction.getActualArguments(), placeholderMessage, designUpdates);
   }


   protected Justification performImplementedLogic(@NotNull InstantiatedGameAction gameAction) {
      ActionFormat actionFormat = gameAction.getAbstractActionFormat();
      // If action is implemented
      List<Item> nouns = gameAction.getActualArguments();
      Justification justification;
      if (ImplementedActionLogic.implementedConditionsMap.containsKey(actionFormat)) {
         List<Condition> conditions = ImplementedActionLogic.implementedConditionsMap.get(actionFormat);
         String successMessage = ImplementedActionLogic.implementedSuccessMessageMap.get(actionFormat);
         List<KnowledgeUpdate> knowledgeUpdates = ImplementedActionLogic.implementedKnowledgeUpdateMap.getOrDefault(actionFormat, new ArrayList<>());
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


   private EnhancedGameDesignAction getGameDesignActions(InstantiatedGameAction gameAction, Room currentRoom) {
      if (designerActions.containsKey(currentRoom)) {
         Map<InstantiatedGameAction, EnhancedGameDesignAction> gameDesignActions = designerActions.get(currentRoom);
         if (gameDesignActions.containsKey(gameAction)) {
            return gameDesignActions.get(gameAction);
         }
      }
      return null;
   }

   public void addAction(Room room, InstantiatedGameAction instantiatedAction, EnhancedGameDesignAction enhancedAction) {
      Map<InstantiatedGameAction, EnhancedGameDesignAction> actionsInRoom = designerActions.get(room);
      actionsInRoom.put(instantiatedAction, enhancedAction);
   }

   // TODO: This should probably use exceptions
   public void addRoom(@NotNull Room room) {
      if (!worldRooms.contains(room)) {
         worldRooms.add(room);
         designerActions.putIfAbsent(room, new HashMap<>());

         for (Item i : room.getItems().values()) {
            knowledgeBase.createSpecificFrame(KnowledgeBase.getItemIdentifier(i), "nonContainer", "massive");
         }
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
      return this.getKnowledgeBase().addParent(child, parent);
/*      Map<String, SpecificFrame> specificFrameMap = this.knowledgeBase.getSpecificFrames();
      Map<String, GenericFrame> genericFrameMap = this.knowledgeBase.getGenericFrames();
      if (specificFrameMap.containsKey(child)) {
         if (genericFrameMap.containsKey(parent)) {
            specificFrameMap.get(child).addParent(genericFrameMap.get(parent));
            return true;
         }
      }
      return false;*/
   }

   public void addToInventory(Item itemInRoom) {
      this.inventoryItems.put(itemInRoom.getID(), itemInRoom);
   }
}
