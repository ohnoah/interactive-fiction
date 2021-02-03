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
import gherkin.lexer.Kn;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import org.antlr.v4.runtime.misc.ParseCancellationException;
import org.jetbrains.annotations.NotNull;

public class EnhancedGameEngine extends GameEngine implements Serializable {

   private static final long serialVersionUID = -6641823063075230452L;
   private Map<Room, Map<InstantiatedGameAction, EnhancedGameDesignAction>> designerActions;
   private KnowledgeBase knowledgeBase;
   private UpdateStrategy updateStrategy = new DefaultUpdateStrategy();


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
      this.knowledgeBase.addSpecificFrame(worldFrame);

      for (GenericFrame g : ImplementedActionLogic.defaultGenericFrames) {
         knowledgeBase.addGenericFrame(g);
      }

   }

   private String notDesignedImplementedFollow(String message) {
      if (message.contains("You pull") || message.contains("You push")) {
         return message.substring(0, message.length() - 1) + " slightly but nothing interesting happens so you put it back.";
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
      Set<String> possibleItemNames = this.possibleItemNames();
      for (String argument : gameAction.getArguments()) {
         if (!possibleItemNames.contains(argument)) {
            return new Justification(false, String.format("There is no %s in your environment.", argument));
         }
      }

      EnhancedGameDesignAction enhancedGameDesignAction = getGameDesignActions(gameAction, currentRoom);

      if (enhancedGameDesignAction != null) {
         Justification designedJustification = validatePreconditions(enhancedGameDesignAction.getPreconditions(), gameAction.getArguments());
         if(!designedJustification.isAccepted()){
            return new Justification(false, designedJustification.getReasoning());
         }
      }

      Justification implJust = performImplementedLogic(gameAction);
      message = capitalize(implJust.getReasoning());
      if (!implJust.isAccepted()) { // Implemented but fails
         return implJust;
      }
      // Then check the GameDesignActions and prepend another message
      /*EnhancedGameDesignAction enhancedGameDesignAction = getGameDesignActions(gameAction, currentRoom);*/

      if (enhancedGameDesignAction == null) {
         if (message.equals("")) { // It's not an implemented action
            return new Justification(false, "You can't do that right now");
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

   public Map<String, Item> globalItems() {
      return worldRooms.stream().map(Room::getItems).flatMap(Collection::stream).collect(Collectors.toMap(Item::getName, i -> i));
   }

   @Override
   public Set<Item> possibleItems() {
      Set<Item> possibleItems = new HashSet<>(currentRoom.getItems());
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
      try {
         this.updateKnowledgeBase(new KnowledgeUpdate(String.format("_world::room := \"%s\"", currentRoom.getName())));
      }
      catch (KnowledgeException e) {
         FileErrorHandler.printExceptionToLog(e);
      }
   }

   public boolean conditionSucceeds(String condition) throws KnowledgeException, MissingKnowledgeException {
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


   // TODO: This is where we intercept calls and do IF-CHANGED PROCEDURES
   public void updateKnowledgeBase(@NotNull KnowledgeUpdate knowledgeUpdate) {
      this.updateStrategy.updateKnowledgeBase(this, knowledgeUpdate);
   }


   public void removeItem(Item i) {
      for (Room r : this.worldRooms) {
         if (r.getItems().contains(i)) {
            r.removeItem(i);
         }
      }
   }


   public void updateKnowledgeBaseMultiple(@NotNull KnowledgeUpdate... knowledgeUpdates) {
      for (KnowledgeUpdate knowledgeUpdate : knowledgeUpdates) {
         updateKnowledgeBase(knowledgeUpdate);
      }
   }


   public List<String> getItemToDeleteFromKnowledgeUpdate(KnowledgeUpdate knowledgeUpdate) {
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


   private Justification validatePreconditions(@NotNull List<Condition> conditions, @NotNull List<String> nouns) {
      boolean valid = true;
      String reasoning = "";

      for (Condition condition : conditions) {
         // replace _arg something in the string
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

   private Justification conditionallyPerformUpdates(@NotNull Justification validatePreconds,
                                                     @NotNull List<KnowledgeUpdate> knowledgeUpdates,
                                                     @NotNull String successMessage, @NotNull List<String> nouns) {
      boolean valid = validatePreconds.isAccepted();
      String reasoning = validatePreconds.getReasoning();
      if (valid) {
         reasoning = replaceArgsWithNouns(successMessage, nouns, " ");
         for (KnowledgeUpdate knowledgeUpdate : knowledgeUpdates) {
            KnowledgeUpdate populatedKnowledgeUpdate = fillKnowledgeUpdateWithArgs(knowledgeUpdate, nouns);
            reasoning = knowledgeBase.fillQueryString(reasoning, getItemToDeleteFromKnowledgeUpdate(populatedKnowledgeUpdate));
            updateKnowledgeBase(populatedKnowledgeUpdate);
         }

         reasoning = knowledgeBase.fillQueryString(reasoning);

      }
      return new Justification(valid, reasoning);
   }

   private Justification conditionallyPerformAction(@NotNull List<Condition> conditions,
                                                    @NotNull List<String> nouns,
                                                    @NotNull String successMessage,
                                                    @NotNull List<KnowledgeUpdate> knowledgeUpdates) {
/*      boolean valid = true;
      String reasoning = "";

      for (Condition condition : conditions) {
         // replace _arg something in the string
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
      }*/

      Justification validatePreconds = validatePreconditions(conditions, nouns);
      return conditionallyPerformUpdates(validatePreconds, knowledgeUpdates, successMessage, nouns);
/*      boolean valid = validatePreconds.isAccepted();
      String reasoning = validatePreconds.getReasoning();
      if (valid) {
         reasoning = replaceArgsWithNouns(successMessage, nouns, " ");
         for (KnowledgeUpdate knowledgeUpdate : knowledgeUpdates) {
            KnowledgeUpdate populatedKnowledgeUpdate = fillKnowledgeUpdateWithArgs(knowledgeUpdate, nouns);
            reasoning = knowledgeBase.fillQueryString(reasoning, getItemToDeleteFromKnowledgeUpdate(populatedKnowledgeUpdate));
            updateKnowledgeBase(populatedKnowledgeUpdate);
         }

         reasoning = knowledgeBase.fillQueryString(reasoning);

      }

      return new Justification(valid, reasoning);*/
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

         for (Item i : room.getItems()) {
            knowledgeBase.createSpecificFrame(i, "nonContainer", "massive");
         }
      }
   }


   @Override
   public String toString() {
      return "com.interactivefiction.EnhancedGameEngine{" +
          "designerActions=" + designerActions +
          ", knowledgeBase=" + knowledgeBase +
          ", worldRooms=" + worldRooms +
          ", currentRoom=" + currentRoom +
          '}';
   }

   public boolean addParent(String child, String parent) {
      Map<String, SpecificFrame> specificFrameMap = this.knowledgeBase.getSpecificFrames();
      Map<String, GenericFrame> genericFrameMap = this.knowledgeBase.getGenericFrames();
      if (specificFrameMap.containsKey(child)) {
         if (genericFrameMap.containsKey(parent)) {
            specificFrameMap.get(child).addParent(genericFrameMap.get(parent));
            return true;
         }
         return false;
      }
      return false;
   }
}
