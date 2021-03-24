package com.intfic.game.enhanced.gamebuilder.compiler;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.intfic.game.enhanced.EnhancedGameDesignAction;
import com.intfic.game.enhanced.EnhancedGameEngine;
import com.intfic.game.enhanced.gamebuilder.generated.GameGrammarBaseVisitor;
import com.intfic.game.enhanced.gamebuilder.generated.GameGrammarParser;
import com.intfic.game.enhanced.reasoning.error.KnowledgeException;
import com.intfic.game.enhanced.reasoning.updates.KnowledgeUpdate;
import com.intfic.game.enhanced.reasoning.wrappers.Condition;
import com.intfic.game.shared.ActionFormat;
import com.intfic.game.shared.InstantiatedGameAction;
import com.intfic.game.shared.Item;
import com.intfic.game.shared.Room;
import gherkin.lexer.En;
import gherkin.lexer.Kn;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.Action;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.jetbrains.annotations.NotNull;

public class GameFileVisitor extends GameGrammarBaseVisitor<Object> implements Serializable {

   private static String asString(TerminalNode tn) {
      return tn.getText();
   }

   private Map<String, Item> items;
   private Map<String, String> messages;
   private Map<String, Condition> preconds;
   private Map<String, KnowledgeUpdate> knowledgeUpdates;
   private Map<String, EnhancedGameDesignAction> actions;
   private EnhancedGameEngine gameEngine;

   public GameFileVisitor() {
      messages = new HashMap<>();
      preconds = new HashMap<>();
      knowledgeUpdates = new HashMap<>();
      actions = new HashMap<>();
      gameEngine = new EnhancedGameEngine();
   }

   private void addItem(@NotNull String id, @NotNull Item i) {
      if (items.containsKey(id)) {
         throw new RuntimeException(String.format("Duplicate ID %s encountered for items", id));
      }
      items.put(id, i);
   }

      private void addMessage(@NotNull String id, @NotNull String content) {
      if (messages.containsKey(id)) {
         throw new RuntimeException(String.format("Duplicate ID %s encountered for messages", id));
      }
      messages.put(id, content);
   }


   private void addPrecond(@NotNull String id, @NotNull Condition cond) {
      if (preconds.containsKey(id)) {
         throw new RuntimeException(String.format("Duplicate ID %s encountered for precond", id));
      }
      preconds.put(id, cond);
   }

   private void addPostCond(@NotNull String id, @NotNull KnowledgeUpdate cond) {
      if (knowledgeUpdates.containsKey(id)) {
         throw new RuntimeException(String.format("Duplicate ID %s encountered for postcond", id));
      }
      knowledgeUpdates.put(id, cond);
   }


   @Override
   public String visitNew_message(GameGrammarParser.New_messageContext ctx) {
      String messageId = visitMessage_id(ctx.message_id());
      String content = asString(ctx.STRING());
      addMessage(messageId, content);
      // Don't really do anything with this
      return content;
   }

   @Override
   public String visitMessage_id(GameGrammarParser.Message_idContext ctx) {
      return ctx.ID().getText();
   }

   @Override
   public String visitMessage_text(GameGrammarParser.Message_textContext ctx) {
      return asString(ctx.STRING());
   }

   @Override
   public String visitMessage_ref(GameGrammarParser.Message_refContext ctx) {
      String id = visitMessage_id(ctx.message_id());
      if (messages.containsKey(id)) {
         return messages.get(id);
      }
      throw new RuntimeException(String.format("Reference to invalid message id: %s", id));
   }

   @Override
   public String visitMessage(GameGrammarParser.MessageContext ctx) {
      if (ctx.message_ref() != null) {
         return visitMessage_ref(ctx.message_ref());
      }
      else if (ctx.message_text() != null) {
         return visitMessage_text(ctx.message_text());
      }
      else {
         throw new RuntimeException("Invalid message type for message " + ctx.getText());
      }
   }

   @Override
   public ActionFormat visitTrigger(GameGrammarParser.TriggerContext ctx) {
      String verb = asString(ctx.ALPHANUMERIC());
      List<ActionFormat> potentialActions = gameEngine.findAction(verb);
      if (potentialActions.size() == 0) {
         throw new RuntimeException("Reference to invalid trigger word : " + verb);
      }
      int index = visitTrigger_selector(ctx.trigger_selector());
      if (index >= 0 && index < potentialActions.size()) {
         return potentialActions.get(index);
      }
      else {
         throw new RuntimeException(String.format("Number is outside the range of the size of the actions with that trigger." +
             " Size of action formats with trigger %s is %d but you specified %d", verb, potentialActions.size(), index));
      }
   }

   @Override
   public Integer visitTrigger_selector(GameGrammarParser.Trigger_selectorContext ctx) {
      String stringNum = ctx.TRIGGER_SELECTOR().getText().substring(1);
      try {
         return Integer.parseInt(stringNum);
      }
      catch (NumberFormatException e) {
         throw new NumberFormatException("Invalid number selector for trigger: " + stringNum);
      }
   }

   @Override
   public String visitPrecond_id(GameGrammarParser.Precond_idContext ctx) {
      return asString(ctx.ID());
   }


   @Override
   public Condition visitPrecond_ref(GameGrammarParser.Precond_refContext ctx) {
      String id = visitPrecond_id(ctx.precond_id());
      if (preconds.containsKey(id)) {
         return preconds.get(id);
      }
      throw new RuntimeException(String.format("Reference to invalid precond id: %s", id));
   }

   @Override
   public Condition visitNew_precond(GameGrammarParser.New_precondContext ctx) {
      String id = visitPrecond_id(ctx.precond_id());
      Condition c = visitPrecond_body(ctx.precond_body());
      addPrecond(id, c);
      return c;
   }

   @Override
   public Condition visitPrecond_body(GameGrammarParser.Precond_bodyContext ctx) {
      String booleanExpr = asString(ctx.SINGLE_STRING());
      String errorMsg = asString(ctx.STRING());
      return new Condition(booleanExpr, errorMsg);
   }

   @Override
   public Condition visitPrecond(GameGrammarParser.PrecondContext ctx) {
      Condition c;
      if (ctx.precond_body() != null) {
         c = visitPrecond_body(ctx.precond_body());
      }
      else if (ctx.precond_ref() != null) {
         c = visitPrecond_ref(ctx.precond_ref());
      }
      else {
         throw new RuntimeException("Invalid precond type");
      }
      return c;
   }

   @Override
   public String visitPostcond_id(GameGrammarParser.Postcond_idContext ctx) {
      return asString(ctx.ID());
   }

   @Override
   public KnowledgeUpdate visitPostcond_ref(GameGrammarParser.Postcond_refContext ctx) {
      String id = visitPostcond_id(ctx.postcond_id());
      if (knowledgeUpdates.containsKey(id)) {
         return knowledgeUpdates.get(id);
      }
      throw new RuntimeException(String.format("Reference to invalid postcond id: %s", id));
   }

   @Override
   public KnowledgeUpdate visitPostcond_body(GameGrammarParser.Postcond_bodyContext ctx) {
      try {
         return new KnowledgeUpdate(asString(ctx.SINGLE_STRING()));
      }
      catch (KnowledgeException e) {
         throw new RuntimeException(e.getMessage() + ". Error when visiting postcond body.");
      }
   }

   @Override
   public KnowledgeUpdate visitNew_postcond(GameGrammarParser.New_postcondContext ctx) {
      String id = visitPostcond_id(ctx.postcond_id());
      KnowledgeUpdate postcond = visitPostcond_body(ctx.postcond_body());
      addPostCond(id, postcond);
      return postcond;
   }

   @Override
   public KnowledgeUpdate visitPostcond(GameGrammarParser.PostcondContext ctx) {
      if(ctx.postcond_body() != null){
         return visitPostcond_body(ctx.postcond_body());
      }
      else if(ctx.postcond_ref() != null){
         return visitPostcond_ref(ctx.postcond_ref());
      }
      else{
         throw new RuntimeException("Invalid postcond type");
      }
   }

   @Override
   public List<Condition> visitPreconds(GameGrammarParser.PrecondsContext ctx) {
      List<Condition> conditions = new ArrayList<>();
      for( GameGrammarParser.PrecondContext precondContext: ctx.precond()){
         conditions.add(visitPrecond(precondContext));
      }
      return conditions;
   }

   @Override
   public List<ActionFormat> visitTriggers(GameGrammarParser.TriggersContext ctx) {
      List<ActionFormat> triggers = new ArrayList<>();
      for( GameGrammarParser.TriggerContext triggerContext: ctx.trigger()){
         triggers.add(visitTrigger(triggerContext));
      }
      return triggers;
   }

   @Override
   public List<KnowledgeUpdate> visitPostconds(GameGrammarParser.PostcondsContext ctx) {
      List<KnowledgeUpdate> postconds = new ArrayList<>();
      for( GameGrammarParser.PostcondContext postcondContext: ctx.postcond()){
         postconds.add(visitPostcond(postcondContext));
      }
      return postconds;
   }

   @Override
   public String visitArgument(GameGrammarParser.ArgumentContext ctx) { // returns stub of item id or item ID
      if(ctx.item_ref() != null){
         return visitItem_ref(ctx.item_ref()).getID();
      }
      else if(ctx.STRING() != null){
         return asString(ctx.STRING());
      }
      else{
         throw new RuntimeException("Invalid argument type " + ctx.getText());
      }
   }

   @Override
   public List<String> visitArguments(GameGrammarParser.ArgumentsContext ctx) {
      List<String> argumentIds = new ArrayList<>();
      for( GameGrammarParser.ArgumentContext argumentContext: ctx.argument()){
         argumentIds.add(visitArgument(argumentContext));
      }
      return argumentIds;
   }

   private List<Item> getItemsByIds(List<String> argumentIds, String roomPrefix){
      List<Item> items = new ArrayList<>();
      for(String rawArgument : argumentIds) { // we are forcing each trigger to have same number of arguments here
         String formatted = !(rawArgument.contains(".")) ? roomPrefix + "." + rawArgument : rawArgument;
         if(gameEngine.globalItems().containsKey(formatted)){
            items.add(gameEngine.globalItems().get(formatted));
         }
         else{
            throw new RuntimeException(String.format("Couldn't find item specified as : %s with ID: %s ", rawArgument, formatted));
         }
      }
      return items;
   }
   private void addActionsToGameEngine(Room room, EnhancedGameDesignAction designAction, List<ActionFormat> actionFormats, List<Item> items){
      for(ActionFormat actionFormat : actionFormats){
         InstantiatedGameAction triggeringAction = new InstantiatedGameAction(actionFormat);
         triggeringAction.setActualArguments(items);
         gameEngine.addAction(room, triggeringAction, designAction);
      }
   }

   private Room findRoom(String roomName){
      List<Room> rooms = gameEngine.findRoom(roomName);
      Room room;
      if(rooms.size() != 1){
         throw new RuntimeException(String.format("Invalid room name %s when creating action \n %s", roomName, ctx.getText()));
      }
      room = rooms.get(0);
      return room;
   }

   @Override
   public EnhancedGameDesignAction visitNew_action(GameGrammarParser.New_actionContext ctx) {
      EnhancedGameDesignAction designAction = new EnhancedGameDesignAction();

      String actionId = visitAction_id(ctx.action_id());
      String roomName = visitRoom_name(ctx.room_name());
      List<ActionFormat> actionFormats = visitTriggers(ctx.triggers());
      List<String> argumentIds = visitArguments(ctx.arguments());

      List<Condition> preconds = visitPreconds(ctx.preconds());
      List<KnowledgeUpdate> postconds = visitPostconds(ctx.postconds());
      String successMessage = visitMessage(ctx.message());

      designAction.setPreconditions(preconds);
      designAction.setMessage(successMessage);
      designAction.setUpdateState(postconds);


      Room room = findRoom(roomName);
      String roomPrefix = Item.roomId(room.getName());
      List<Item> items = getItemsByIds(argumentIds, roomPrefix);
      addActionsToGameEngine(room, designAction, actionFormats, items);

      // Add action ID to map
      actions.put(actionId, designAction);
      return designAction;
   }

   @Override
   public EnhancedGameDesignAction visitAdd_trigger(GameGrammarParser.Add_triggerContext ctx) {
      EnhancedGameDesignAction designAction = visitAction_ref(ctx.action_ref());
      String roomName = visitRoom_name(ctx.room_name());
      Room room = findRoom(roomName);
      String roomPrefix = Item.roomId(room.getName());
      List<ActionFormat> triggers = visitTriggers(ctx.triggers());
      List<String> itemIds = visitArguments(ctx.arguments());
      List<Item> items = getItemsByIds(itemIds, roomPrefix);
      addActionsToGameEngine(room, designAction, triggers, items);
      return designAction;
   }

   @Override
   public ActionFormat visitActionformat(GameGrammarParser.ActionformatContext ctx) {
      String verb = asString(ctx.ALPHANUMERIC());
      if(verb.length() == 0 || verb.matches(".*\\d.*") || verb.contains(" ")){
         throw new RuntimeException("Invalid trigger word. It must be a word with no numbers, spaces and non-zero length e.g. \"put\". You said :" + verb);
      }
      if(ctx.STRING() != null) {
         String regex = asString(ctx.STRING());
         return new ActionFormat(verb, regex);
      }
      else{
         return new ActionFormat(verb);
      }
   }

   @Override
   public String visitAction_id(GameGrammarParser.Action_idContext ctx) {
      return asString(ctx.ID());
   }

   @Override
   public EnhancedGameDesignAction visitAction_ref(GameGrammarParser.Action_refContext ctx) {
      String actionId = visitAction_id(ctx.action_id());
      if (actions.containsKey(actionId)) {
         return actions.get(actionId);
      }
      throw new RuntimeException(String.format("Reference to invalid action id: %s", actionId));
   }

   @Override
   public EnhancedGameDesignAction visitAction(GameGrammarParser.ActionContext ctx) {
      return visitAction_ref(ctx.action_ref());
   }

   @Override
   public Object visitActions(GameGrammarParser.ActionsContext ctx) {
      List<EnhancedGameDesignAction> actions = new ArrayList<>();
      for( GameGrammarParser.ActionContext actionContext: ctx.action()){
         actions.add(visitAction(actionContext));
      }
      return actions;
   }

   @Override
   public String visitItem_id(GameGrammarParser.Item_idContext ctx) {
      return asString(ctx.ID());
   }

   @Override
   public Item visitItem_ref(GameGrammarParser.Item_refContext ctx) {
      String id = visitItem_id(ctx.item_id());
      if (items.containsKey(id)) {
         return items.get(id);
      }
      throw new RuntimeException(String.format("Reference to invalid item id: %s", id));
   }

   @Override
   public String visitItem_name(GameGrammarParser.Item_nameContext ctx) {
      return asString(ctx.STRING());
   }

   @Override
   public Item visitItem(GameGrammarParser.ItemContext ctx) {
      if(ctx.item_ref() != null){
         return visitItem_ref(ctx.item_ref());
      }
      else if(ctx.item_name() != null){
         // WE HAVE to ensure we add parent room here
         String itemName = visitItem_name(ctx.item_name());
         return new Item(itemName);
      }
      else {
         throw new RuntimeException("Invalid item type : " + ctx.getText());
      }
   }

   @Override
   public List<Item> visitItems(GameGrammarParser.ItemsContext ctx) {
      List<Item> items = new ArrayList<>();
      for( GameGrammarParser.ItemContext itemContext: ctx.item()){
         items.add(visitItem(itemContext));
      }
      return items;
   }

   @Override
   public Item visitNew_item(GameGrammarParser.New_itemContext ctx) {
      String itemId = visitItem_id(ctx.item_id());
      String roomName = visitRoom_name(ctx.room_name());
      String itemName = visitItem_name(ctx.item_name());
      List<String> synonyms = visitItem

      Item item = new Item();

      List<KnowledgeUpdate> knowledgeUpdates = visitKnowledge_updates(ctx.knowledge_updates());
      for(KnowledgeUpdate knowledgeUpdate : knowledgeUpdates) {
         gameEngine.updateKnowledgeBase(knowledgeUpdate);
      }
   }

   @Override
   public String visitRoom_name(GameGrammarParser.Room_nameContext ctx) {
      return asString(ctx.STRING());
   }

   @Override
   public Object visitNew_room(GameGrammarParser.New_roomContext ctx) {
      return super.visitNew_room(ctx);
   }

   @Override
   public Object visitGenericframe_name(GameGrammarParser.Genericframe_nameContext ctx) {
      return super.visitGenericframe_name(ctx);
   }

   @Override
   public Object visitMap_entry(GameGrammarParser.Map_entryContext ctx) {
      return super.visitMap_entry(ctx);
   }

   @Override
   public Object visitNew_genericframe(GameGrammarParser.New_genericframeContext ctx) {
      return super.visitNew_genericframe(ctx);
   }

   @Override
   public Object visitKnowledge_update(GameGrammarParser.Knowledge_updateContext ctx) {
      return super.visitKnowledge_update(ctx);
   }

   @Override
   public List<KnowledgeUpdate> visitKnowledge_updates(GameGrammarParser.Knowledge_updatesContext ctx) {
      return super.visitKnowledge_updates(ctx);
   }

   @Override
   public Object visitGlobal_item(GameGrammarParser.Global_itemContext ctx) {
      return super.visitGlobal_item(ctx);
   }

   @Override
   public Object visitGlobal_items(GameGrammarParser.Global_itemsContext ctx) {
      return super.visitGlobal_items(ctx);
   }

   @Override
   public Object visitInheritance(GameGrammarParser.InheritanceContext ctx) {
      return super.visitInheritance(ctx);
   }

   @Override
   public Object visitKnowledge(GameGrammarParser.KnowledgeContext ctx) {
      return super.visitKnowledge(ctx);
   }

   @Override
   public Object visitStart(GameGrammarParser.StartContext ctx) {
      return super.visitStart(ctx);
   }

   @Override
   public Object visitGame(GameGrammarParser.GameContext ctx) {
      return super.visitGame(ctx);
   }
}
