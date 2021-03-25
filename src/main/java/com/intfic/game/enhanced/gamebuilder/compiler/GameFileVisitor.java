package com.intfic.game.enhanced.gamebuilder.compiler;

import com.intfic.game.enhanced.EnhancedGameDesignAction;
import com.intfic.game.enhanced.EnhancedGameEngine;
import com.intfic.game.enhanced.gamebuilder.generated.GameGrammarBaseVisitor;
import com.intfic.game.enhanced.gamebuilder.generated.GameGrammarParser;
import com.intfic.game.enhanced.reasoning.KnowledgeBase;
import com.intfic.game.enhanced.reasoning.KnowledgeRegex;
import com.intfic.game.enhanced.reasoning.VisitorHelper;
import com.intfic.game.enhanced.reasoning.error.KnowledgeException;
import com.intfic.game.enhanced.reasoning.frames.GenericFrame;
import com.intfic.game.enhanced.reasoning.updates.KnowledgeUpdate;
import com.intfic.game.enhanced.reasoning.visitors.ConditionEvaluationVisitor;
import com.intfic.game.enhanced.reasoning.visitors.TypeConvertVisitor;
import com.intfic.game.enhanced.reasoning.wrappers.Condition;
import com.intfic.game.shared.ActionFormat;
import com.intfic.game.shared.GameEngine;
import com.intfic.game.shared.InstantiatedGameAction;
import com.intfic.game.shared.Item;
import com.intfic.game.shared.Room;
import edu.stanford.nlp.util.Pair;
import gherkin.lexer.Kn;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.jetbrains.annotations.NotNull;

public class GameFileVisitor extends GameGrammarBaseVisitor<Object> implements Serializable {

   private static String asString(TerminalNode tn) {
      String text = tn.getText();
      if ((text.startsWith("\"") && text.endsWith("\"")) || (text.startsWith("'") && text.endsWith("'"))) {
         return text.substring(1, text.length() - 1);
      }
      return tn.getText();
   }

   private Map<String, Item> items;
   private Map<Item, List<KnowledgeUpdate>> itemUpdates;
   private Map<String, String> messages;
   private Map<String, Condition> preconds;
   private Map<String, KnowledgeUpdate> knowledgeUpdates;
   private Map<String, EnhancedGameDesignAction> actionEffects;
   private Map<String, EnhancedGameDesignAction> roomifiedActionEffectsMap;
   private Map<String, List<ActionFormat>> actionTriggers;
   private Map<String, List<Item>> actionArguments;
   private EnhancedGameEngine gameEngine;
   private TypeConvertVisitor typeConvertVisitor = new TypeConvertVisitor();
   private ConditionEvaluationVisitor conditionEvaluationVisitor = new ConditionEvaluationVisitor(new KnowledgeBase());

   private final static String PLACEHOLDER_FRAME_NAME = "place_holder_frame_that_make_ku_valid";

   public GameFileVisitor() {
      messages = new HashMap<>();
      preconds = new HashMap<>();
      knowledgeUpdates = new HashMap<>();
      actionEffects = new HashMap<>();
      roomifiedActionEffectsMap = new HashMap<>();
      actionTriggers = new HashMap<>();
      actionArguments = new HashMap<>();
      items = new HashMap<>();
      itemUpdates = new HashMap<>();
      gameEngine = new EnhancedGameEngine();
   }

   private void addAction(@NotNull String id, @NotNull List<ActionFormat> triggers, @NotNull EnhancedGameDesignAction effect, @NotNull List<Item> arguments) {
      if (actionEffects.containsKey(id)) {
         throw new RuntimeException(String.format("Duplicate ID %s encountered for actions", id));
      }
      for (ActionFormat af : triggers) {
         if (af.getDegree() != arguments.size()) {
            throw new RuntimeException(String.format("Trigger %s expects %d arguments " +
                    "but the argument list you provided %s has %d arguments",
                af.toString(), af.getDegree(), arguments, arguments.size()));
         }
      }

      actionEffects.put(id, effect);
      actionTriggers.put(id, triggers);
      actionArguments.put(id, arguments);
   }

   private void addItem(@NotNull String id, @NotNull Item i, @NotNull List<KnowledgeUpdate> knowledgeUpdates) {
      if (items.containsKey(id)) {
         throw new RuntimeException(String.format("Duplicate ID %s encountered for items", id));
      }
      items.put(id, i);
      itemUpdates.put(i, knowledgeUpdates);
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
      if (ctx.trigger_selector() != null) {
         int index = visitTrigger_selector(ctx.trigger_selector());
         if (index >= 0 && index < potentialActions.size()) {
            return potentialActions.get(index);
         }
         else {
            throw new RuntimeException(String.format("Number is outside the range of the size of the actions with that trigger." +
                " Size of action formats with trigger %s is %d but you specified %d", verb, potentialActions.size(), index));
         }
      }
      else {
         if (potentialActions.size() == 1) {
            return potentialActions.get(0);
         }
         else {
            throw new RuntimeException("No selector was specified with a \"-\" symbol and an integer and there are multiple actions with the verb " + verb + ". " + ctx.getText());
         }
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
      if (ctx.postcond_body() != null) {
         return visitPostcond_body(ctx.postcond_body());
      }
      else if (ctx.postcond_ref() != null) {
         return visitPostcond_ref(ctx.postcond_ref());
      }
      else {
         throw new RuntimeException("Invalid postcond type");
      }
   }

   @Override
   public List<Condition> visitPreconds(GameGrammarParser.PrecondsContext ctx) {
      List<Condition> conditions = new ArrayList<>();
      for (GameGrammarParser.PrecondContext precondContext : ctx.precond()) {
         conditions.add(visitPrecond(precondContext));
      }
      return conditions;
   }

   @Override
   public List<ActionFormat> visitTriggers(GameGrammarParser.TriggersContext ctx) {
      List<ActionFormat> triggers = new ArrayList<>();
      for (GameGrammarParser.TriggerContext triggerContext : ctx.trigger()) {
         triggers.add(visitTrigger(triggerContext));
      }
      return triggers;
   }

   @Override
   public List<KnowledgeUpdate> visitPostconds(GameGrammarParser.PostcondsContext ctx) {
      List<KnowledgeUpdate> postconds = new ArrayList<>();
      for (GameGrammarParser.PostcondContext postcondContext : ctx.postcond()) {
         postconds.add(visitPostcond(postcondContext));
      }
      return postconds;
   }

   @Override
   public Item visitArgument(GameGrammarParser.ArgumentContext ctx) { // returns stub of item id or item ID
      if (ctx.item_ref() != null) {
         return visitItem_ref(ctx.item_ref());
      }
      else {
         throw new RuntimeException("Invalid argument type " + ctx.getText());
      }
   }

   @Override
   public List<Item> visitArguments(GameGrammarParser.ArgumentsContext ctx) {
      List<Item> argumentIds = new ArrayList<>();
      for (GameGrammarParser.ArgumentContext argumentContext : ctx.argument()) {
         argumentIds.add(visitArgument(argumentContext));
      }
      return argumentIds;
   }

   private String prependRoomPrefix(@NotNull String rawArgument, String roomPrefix) {
      String formatted;

      if (roomPrefix != null) {
         formatted = !(rawArgument.contains(".") || rawArgument.startsWith("world") || rawArgument.startsWith("arg")) ? roomPrefix + "." + rawArgument : rawArgument;
      }
      else {
         if (!rawArgument.contains(".")) {
            throw new RuntimeException("You must include a full item ID including a . symbol" +
                " when not specifying room prefix in new action but you gave : " + rawArgument);
         }
         formatted = rawArgument;
      }
      return formatted;
   }

   private List<Item> getItemsByIds(List<String> argumentIds, String roomPrefix) {
      List<Item> items = new ArrayList<>();
      for (String rawArgument : argumentIds) { // we are forcing each trigger to have same number of arguments here
         String formatted = prependRoomPrefix(rawArgument, roomPrefix);
         if (gameEngine.globalItems().containsKey(formatted)) {
            items.add(gameEngine.globalItems().get(formatted));
         }
         else {
            throw new RuntimeException(String.format("Couldn't find item specified as : %s with ID: %s ", rawArgument, formatted));
         }
      }
      return items;
   }

   private void addActionsToGameEngine(Room room, EnhancedGameDesignAction designAction, List<ActionFormat> actionFormats, List<Item> items) {
      for (ActionFormat actionFormat : actionFormats) {
         InstantiatedGameAction triggeringAction = new InstantiatedGameAction(actionFormat);
         triggeringAction.setActualArguments(items);
         gameEngine.addAction(room, triggeringAction, designAction);
      }
   }

   private Room findRoom(@NotNull String roomName) {
      return findRoom(roomName, null);
   }

   private Room findRoom(@NotNull String roomName, ParserRuleContext ctx) {
      List<Room> rooms = gameEngine.findRoom(roomName);
      Room room;
      if (rooms.size() != 1) {
         String errorMsg = "";
         if (ctx == null) {
            errorMsg = String.format("Invalid room name %s. Found %d rooms when searching for it.", roomName, rooms.size());
         }
         else {
            errorMsg = String.format("Invalid room name %s. Found %d rooms when searching for it. When searching : %s ", roomName, rooms.size(), ctx.getText());
         }
         throw new RuntimeException(errorMsg);
      }
      room = rooms.get(0);
      return room;
   }

   @Override
   public EnhancedGameDesignAction visitNew_action(GameGrammarParser.New_actionContext ctx) {
      EnhancedGameDesignAction designAction = new EnhancedGameDesignAction();

      String actionId = visitAction_id(ctx.action_id());
/*      String roomName = null;
      if (ctx.STRING() != null) {
         roomName = asString(ctx.STRING());
      }*/
      List<ActionFormat> actionFormats = visitTriggers(ctx.triggers());
      List<Item> items = visitArguments(ctx.arguments());

      List<Condition> preconds = visitPreconds(ctx.preconds());
      List<KnowledgeUpdate> postconds = visitPostconds(ctx.postconds());
      String successMessage = visitMessage(ctx.message());

      designAction.setPreconditions(preconds);
      designAction.setMessage(successMessage);
      designAction.setUpdateState(postconds);


/*      String roomPrefix = null;
      if (roomName != null) {
         roomPrefix = Item.roomId(roomName);
      }*/
      /*      List<Item> items = getItemsByIds(argumentIds, null);*/
      /*      addActionsToGameEngine(room, designAction, actionFormats, items);*/

      // Add action ID to map
      addAction(actionId, actionFormats, designAction, items);
      return designAction;
   }

   // BECAUSE ITEMS CAN MOVE ROOMS THIS WILL NOT ROOMIFY WITH THE NEW ROOM.
   // IT WILL INSTEAD REFER ONLY TO THE ITEMS IN THE ORIGINAL ACTION ROOM
   // ITEMS ARE NOT SUITABLE TO PUT IN DIFFERENT ROOMS
   @Override
   public EnhancedGameDesignAction visitAdd_trigger(GameGrammarParser.Add_triggerContext ctx) {
      String actionId = visitAction_ref(ctx.action_ref());
      String roomName = visitRoom_name(ctx.room_name());
      Room room = findRoom(roomName, ctx);
      String roomPrefix = Item.roomId(room.getName());
      List<ActionFormat> triggers = visitTriggers(ctx.triggers());
      List<Item> arguments = visitArguments(ctx.arguments());
      /*      List<Item> items = getItemsByIds(itemIds, roomPrefix);*/

      if (roomifiedActionEffectsMap.containsKey(actionId)) {
         EnhancedGameDesignAction designAction = roomifiedActionEffectsMap.get(actionId);
         addActionsToGameEngine(room, designAction, triggers, arguments);
         return designAction;
      }
      throw new RuntimeException("Invalid actionId mentioned in add trigger : " + actionId);

   }

   @Override
   public ActionFormat visitActionformat(GameGrammarParser.ActionformatContext ctx) {
      String verb = asString(ctx.ALPHANUMERIC());
      if (verb.length() == 0 || verb.matches(".*\\d.*") || verb.contains(" ")) {
         throw new RuntimeException("Invalid trigger word. It must be a word with no numbers, spaces and non-zero length e.g. \"put\". You said :" + verb);
      }
      ActionFormat af;
      if (ctx.STRING() != null) {
         String regex = asString(ctx.STRING());
         af = new ActionFormat(verb, regex);
      }
      else {
         af = new ActionFormat(verb);
      }
      gameEngine.addActionFormat(af);
      return af;
   }

   @Override
   public String visitAction_id(GameGrammarParser.Action_idContext ctx) {
      return asString(ctx.ID());
   }

   // This will just return an actionID that can be used to look into the three maps
   @Override
   public String visitAction_ref(GameGrammarParser.Action_refContext ctx) {
      String actionId = visitAction_id(ctx.action_id());
      return actionId;
   }

   @Override
   public String visitAction(GameGrammarParser.ActionContext ctx) {
      return visitAction_ref(ctx.action_ref());
   }

   @Override
   public List<String> visitActions(GameGrammarParser.ActionsContext ctx) {
      List<String> actions = new ArrayList<>();
      for (GameGrammarParser.ActionContext actionContext : ctx.action()) {
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
      if (ctx.item_ref() != null) {
         return visitItem_ref(ctx.item_ref());
      }
      else if (ctx.item_name() != null) {
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
      for (GameGrammarParser.ItemContext itemContext : ctx.item()) {
         items.add(visitItem(itemContext));
      }
      return items;
   }

   @Override
   public String visitItem_adjective(GameGrammarParser.Item_adjectiveContext ctx) {
      return asString(ctx.ALPHANUMERIC());
   }

   @Override
   public List<String> visitItem_adjectives(GameGrammarParser.Item_adjectivesContext ctx) {
      List<String> adjectives = new ArrayList<>();
      if (ctx != null) {
         for (GameGrammarParser.Item_adjectiveContext adjectiveContext : ctx.item_adjective()) {
            adjectives.add(visitItem_adjective(adjectiveContext));
         }
      }
      return adjectives;
   }

   @Override
   public String visitItem_synonym(GameGrammarParser.Item_synonymContext ctx) {
      if (asString(ctx.STRING()).matches(".*[\\d\\p{Punct}]+.*")) {
         throw new RuntimeException("Synonyms should only have letters and spaces in them");
      }
      return asString(ctx.STRING());
   }

   @Override
   public List<String> visitItem_synonyms(GameGrammarParser.Item_synonymsContext ctx) {
      List<String> synonyms = new ArrayList<>();
      if (ctx != null) {
         for (GameGrammarParser.Item_synonymContext synonymContext : ctx.item_synonym()) {
            synonyms.add(visitItem_synonym(synonymContext));
         }
      }
      return synonyms;
   }

   @Override
   public Item visitNew_item(GameGrammarParser.New_itemContext ctx) {
      String itemId = visitItem_id(ctx.item_id());
      //String roomName = visitRoom_name(ctx.room_name());
      String itemName = visitItem_name(ctx.item_name());
      List<String> synonyms = visitItem_synonyms(ctx.item_synonyms());
      List<String> adjectives = visitItem_adjectives(ctx.item_adjectives());

      Item item = new Item(itemName, new HashSet<>(adjectives), new HashSet<>(synonyms));
      List<KnowledgeUpdate> knowledgeUpdates = visitKnowledge_updates(ctx.knowledge_updates());
      addItem(itemId, item, knowledgeUpdates);
      //Room parentRoom = findRoom(roomName);
      // We must remember to set items as well to get this in the room item map
      //item.setParentRoom(parentRoom, new ArrayList<>(parentRoom.getItems().values()));

/*      for (KnowledgeUpdate knowledgeUpdate : knowledgeUpdates) {
         gameEngine.updateKnowledgeBase(knowledgeUpdate);
      }*/
      return item;
   }

   @Override
   public String visitRoom_name(GameGrammarParser.Room_nameContext ctx) {
      return asString(ctx.STRING());
   }

   private KnowledgeUpdate addRoomToKnowledgeUpdate(KnowledgeUpdate ku, String roomPrefix) {
      KnowledgeUpdate newKu = new KnowledgeUpdate(ku);
      String currentFrame = newKu.getFrameToUpdate();

      if (currentFrame.startsWith(PLACEHOLDER_FRAME_NAME)) {
         String idWithoutRoom = currentFrame.split("\\.")[1];
         String newId = prependRoomPrefix(idWithoutRoom, roomPrefix);
         newKu.setFrameToUpdate(newId);
         System.out.println(currentFrame);
         System.out.println(idWithoutRoom);
         System.out.println(newId);
      }
      else {
         System.out.println("ALREADY VALID KU " + ku);
      }


      return newKu;
   }

   private String prependRoomToAllKnowledge(String s, String roomPrefix) {
      Pattern p = Pattern.compile(KnowledgeRegex.KNOWLEDGE_EXPR);
      Matcher m = p.matcher(s);
      String newS = m.replaceAll(match ->
          prependRoomPrefix(match.group(), roomPrefix));
      return newS;
   }


   private Condition newConditionWithRoom(Condition c, String roomPrefix) {
      System.out.println(c.getBooleanExpr());
      //throw new RuntimeException("Encountered a condition with a boolean expression that doesn't contain any knowledge strings. This is an error. " + c.getBooleanExpr());
      //AtomicInteger filler = new AtomicInteger();
      String newBooleanExpr = prependRoomToAllKnowledge(c.getBooleanExpr(), roomPrefix);
      String newFailureMessage = prependRoomToAllKnowledge(c.getFailureMessage(), roomPrefix);
      System.out.println(newBooleanExpr);
      return new Condition(newBooleanExpr, c.getFailureMessage());
   }

   @Override
   public Room visitNew_room(GameGrammarParser.New_roomContext ctx) {
      String roomName = visitRoom_name(ctx.room_name());
      List<Item> items = visitItems(ctx.items());
      for (Item i : items) {
         if (!i.getParentRoom().equals(GameEngine.unassignedItemRoom)) {
            throw new RuntimeException("Item " + i + " is already assigned to another room. Error. " + ctx.getText());
         }
      }
      Room room = new Room(roomName);
      room.setItems(items);

      // Perform knowledgeupdates here that were mentioned in item block
      String roomPrefix = Item.roomId(room.getName());
      for (Item i : items) {
         List<KnowledgeUpdate> kus = itemUpdates.getOrDefault(i, new ArrayList<>());
         for (KnowledgeUpdate ku : kus) {
            KnowledgeUpdate roomKu = addRoomToKnowledgeUpdate(ku, roomPrefix);
            gameEngine.updateKnowledgeBase(roomKu);
         }
      }


      // need to add the room here so that it exists in gameengine map
      gameEngine.addRoom(room);

      List<String> actionIdsInRoom = visitActions(ctx.actions());

      for (String actionId : actionIdsInRoom) {
         if (!actionEffects.containsKey(actionId)) {
            throw new RuntimeException("Invalid actionId referenced when making new room: " + actionId);
         }
         EnhancedGameDesignAction designAction = actionEffects.get(actionId);
         if (roomifiedActionEffectsMap.containsKey(actionId)) {
            throw new RuntimeException("An error occured when adding an action to a room. " +
                "One action should only be referenced in a single room. If you want to add an " +
                "action with the same effect to another room, use add_trigger. Error actionID: " + actionId + ". Error room: " + roomName);
         }
         EnhancedGameDesignAction newDesignAction = roomifyDesignAction(designAction, roomPrefix);
         roomifiedActionEffectsMap.put(actionId, newDesignAction);

         List<ActionFormat> triggers = actionTriggers.get(actionId);
         List<Item> arguments = actionArguments.get(actionId);
         addActionsToGameEngine(room, newDesignAction, triggers, arguments);
      }

      return room;
   }

   private EnhancedGameDesignAction roomifyDesignAction(@NotNull EnhancedGameDesignAction designAction, @NotNull String roomPrefix) {
      List<Condition> newConditions = designAction.getPreconditions()
          .stream().map(c -> newConditionWithRoom(c, roomPrefix)).collect(Collectors.toList());
      designAction.setPreconditions(newConditions);
      List<KnowledgeUpdate> newKus = designAction.getUpdateState().stream().
          map(ku -> addRoomToKnowledgeUpdate(ku, roomPrefix)).collect(Collectors.toList());

      return new EnhancedGameDesignAction(newConditions, prependRoomToAllKnowledge(designAction.getMessage(), roomPrefix), newKus);
   }


   @Override
   public String visitGenericframe_name(GameGrammarParser.Genericframe_nameContext ctx) {
      return asString(ctx.STRING());
   }

   @Override
   public Pair<String, Object> visitMap_entry(GameGrammarParser.Map_entryContext ctx) {
      String key = asString(ctx.ALPHANUMERIC());
      String rawVal = asString(ctx.SINGLE_STRING());
      Object val = VisitorHelper.typeConvert(typeConvertVisitor, rawVal);
      return new Pair<>(key, val);
   }

   @Override
   public List<Pair<String, Object>> visitMap_entries(GameGrammarParser.Map_entriesContext ctx) {
      List<Pair<String, Object>> mapEntries = new ArrayList<>();
      for (GameGrammarParser.Map_entryContext mapEntry : ctx.map_entry()) {
         mapEntries.add(visitMap_entry(mapEntry));
      }
      return mapEntries;
   }

   @Override
   public GenericFrame visitNew_genericframe(GameGrammarParser.New_genericframeContext ctx) {
      String id = visitGenericframe_name(ctx.genericframe_name());
      List<Pair<String, Object>> slotsFillers = visitMap_entries(ctx.map_entries());
      GenericFrame gf = new GenericFrame(id);
      for (Pair<String, Object> pair : slotsFillers) {
         gf.addSlot(pair.first, pair.second);
      }
      KnowledgeBase kb = gameEngine.getKnowledgeBase();
      kb.addGenericFrame(gf);
      return gf;
   }

   @Override
   public KnowledgeUpdate visitKnowledge_update(GameGrammarParser.Knowledge_updateContext ctx) {
      try {
         String kuString = asString(ctx.SINGLE_STRING());
         // This is done so that item knowledge updates pass as valid KUs. They are later updated.
         String kuStringWorld = prependRoomPrefix(kuString, PLACEHOLDER_FRAME_NAME);
         return new KnowledgeUpdate(kuStringWorld);
      }
      catch (KnowledgeException e) {
         throw new RuntimeException("Error when visiting knowledge update: " + ctx.SINGLE_STRING() + "." + e.getMessage());
      }
   }

   @Override
   public List<KnowledgeUpdate> visitKnowledge_updates(GameGrammarParser.Knowledge_updatesContext ctx) {
      List<KnowledgeUpdate> kus = new ArrayList<>();
      for (GameGrammarParser.Knowledge_updateContext kuContext : ctx.knowledge_update()) {
         kus.add(visitKnowledge_update(kuContext));
      }
      return kus;
   }

   @Override
   public Item visitGlobal_item(GameGrammarParser.Global_itemContext ctx) {
      if (ctx.STRING() != null) {
         String id = asString(ctx.STRING());
         Map<String, Item> globalItems = gameEngine.globalItems();
         System.out.println(globalItems);
         if (!globalItems.containsKey(id)) {
            throw new RuntimeException("Invalid global item ID: " + id);
         }
         return globalItems.get(id);
      }
      else if (ctx.item_ref() != null) {
         return visitItem_ref(ctx.item_ref());
      }
      else {
         throw new RuntimeException("Invalid type of global item " + ctx.getText());
      }
   }

   @Override
   public List<Item> visitGlobal_items(GameGrammarParser.Global_itemsContext ctx) {
      List<Item> items = new ArrayList<>();
      for (GameGrammarParser.Global_itemContext globalItemContext : ctx.global_item()) {
         items.add(visitGlobal_item(globalItemContext));
      }
      return items;
   }

   @Override
   public Object visitInheritance(GameGrammarParser.InheritanceContext ctx) {
      List<Item> inheritingItems = visitGlobal_items(ctx.global_items());
      String parentId = asString(ctx.STRING());
      for (Item i : inheritingItems) {
         gameEngine.addParent(i.getID(), parentId);
      }
      return null;
   }

   @Override
   public Object visitInheritances(GameGrammarParser.InheritancesContext ctx) {
      for (GameGrammarParser.InheritanceContext inheritanceContext : ctx.inheritance()) {
         visitInheritance(inheritanceContext);
      }
      return null;
   }

   @Override
   public Object visitKnowledge(GameGrammarParser.KnowledgeContext ctx) {
      visitInheritances(ctx.inheritances());
      List<KnowledgeUpdate> knowledgeUpdates = visitKnowledge_updates(ctx.knowledge_updates());
      for (KnowledgeUpdate ku : knowledgeUpdates) {
         gameEngine.updateKnowledgeBase(ku);
      }
      return null;
   }

   @Override
   public Object visitStart(GameGrammarParser.StartContext ctx) {
      String startRoomName = visitRoom_name(ctx.room_name());
      Room room = findRoom(startRoomName, ctx);
      gameEngine.setCurrentRoom(room);

      String startMessage = asString(ctx.STRING());
      gameEngine.setStartMessage(startMessage);
      return null;
   }

   @Override
   public Object visitBlock(GameGrammarParser.BlockContext ctx) {
      if (ctx.actionformat() != null) {
         visitActionformat(ctx.actionformat());
      }
      else if (ctx.new_item() != null) {
         visitNew_item(ctx.new_item());
      }
      else if (ctx.new_message() != null) {
         visitNew_message(ctx.new_message());
      }
      else if (ctx.new_precond() != null) {
         visitNew_precond(ctx.new_precond());
      }
      else if (ctx.new_postcond() != null) {
         visitNew_postcond(ctx.new_postcond());
      }
      else if (ctx.add_trigger() != null) {
         visitAdd_trigger(ctx.add_trigger());
      }
      else if (ctx.new_room() != null) {
         visitNew_room(ctx.new_room());
      }
      else if (ctx.new_action() != null) {
         visitNew_action(ctx.new_action());
      }
      else {
         throw new RuntimeException("invalid block type " + ctx.getText());
      }
      return null;
   }

   // Parsing should go something like ACTIONFORMAT -> ITEMS -> MESSAGES -> PRECONDS -> POSTCONDS -> ACTIONS -> add_trigger -> ROOMS -> START -> NEW_GENERICFRAME -> KNOWLEDGE
   @Override
   public EnhancedGameEngine visitGame(GameGrammarParser.GameContext ctx) {
      for (GameGrammarParser.BlockContext blockContext : ctx.block()) {
         visitBlock(blockContext);
      }
/*      for(GameGrammarParser.ActionformatContext afCtx : ctx.actionformat()) {
         visitActionformat(afCtx);
      }

      for(GameGrammarParser.New_itemContext itemCtx : ctx.new_item()) {
         visitNew_item(itemCtx);
      }

      for(GameGrammarParser.New_messageContext newMessageContext : ctx.new_message()) {
         visitNew_message(newMessageContext);
      }

      for(GameGrammarParser.New_precondContext precondContext : ctx.new_precond()) {
         visitNew_precond(precondContext);
      }

      for(GameGrammarParser.New_postcondContext postcondContext : ctx.new_postcond()) {
         visitNew_postcond(postcondContext);
      }

      for(GameGrammarParser.New_actionContext newActionContext : ctx.new_action()) {
         visitNew_action(newActionContext);
      }

      for(GameGrammarParser.Add_triggerContext addTriggerContext : ctx.add_trigger()) {
         visitAdd_trigger(addTriggerContext);
      }

      for(GameGrammarParser.New_roomContext roomCtx : ctx.new_room()) {
         visitNew_room(roomCtx);
      }*/

      visitStart(ctx.start());

      for (GameGrammarParser.New_genericframeContext newGfContext : ctx.new_genericframe()) {
         visitNew_genericframe(newGfContext);
      }

      for (GameGrammarParser.KnowledgeContext knowledgeContext : ctx.knowledge()) {
         visitKnowledge(knowledgeContext);
      }
      return this.gameEngine;
   }
}
