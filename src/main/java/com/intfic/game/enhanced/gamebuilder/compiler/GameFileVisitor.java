package com.intfic.game.enhanced.gamebuilder.compiler;

import com.intfic.game.enhanced.EnhancedGameDesignAction;
import com.intfic.game.enhanced.EnhancedGameEngine;
import com.intfic.game.enhanced.gamebuilder.generated.GameGrammarBaseVisitor;
import com.intfic.game.enhanced.gamebuilder.generated.GameGrammarParser;
import com.intfic.game.enhanced.reasoning.updates.KnowledgeUpdate;
import com.intfic.game.enhanced.reasoning.wrappers.Condition;
import com.intfic.game.shared.ActionFormat;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.Action;
import org.antlr.v4.runtime.tree.TerminalNode;

public class GameFileVisitor extends GameGrammarBaseVisitor<Object> implements Serializable {

   private static String asString(TerminalNode tn){
      return tn.getText();
   }

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


   private void addMessage(String id, String content){
      if(messages.containsKey(id)){
         throw new RuntimeException(String.format("Duplicate ID %s encountered for messages", id));
      }
      messages.put(id, content);
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
      if(messages.containsKey(id)){
         return messages.get(id);
      }
      throw new RuntimeException(String.format("Reference to invalid id: %s", id));
   }

   @Override
   public String visitMessage(GameGrammarParser.MessageContext ctx) {
      if(ctx.message_ref() != null){
         return visitMessage_ref(ctx.message_ref());
      }
      else if(ctx.message_text() != null){
         return visitMessage_text(ctx.message_text());
      }
      else{
         throw new RuntimeException("Invalid message type for message " + ctx.getText());
      }
   }

   @Override
   public ActionFormat visitTrigger(GameGrammarParser.TriggerContext ctx) {
      String verb = asString(ctx.ALPHANUMERIC());
      List<ActionFormat> potentialActions = gameEngine.findAction(verb);
      if(potentialActions.size() == 0){
         throw new RuntimeException("Reference to invalid trigger word : " + verb);
      }
      int number = ctx.TRIGGER_SELECTOR();
      if()
   }

   @Override
   public Object visitPrecond_id(GameGrammarParser.Precond_idContext ctx) {
      return super.visitPrecond_id(ctx);
   }

   @Override
   public Object visitPrecond_ref(GameGrammarParser.Precond_refContext ctx) {
      return super.visitPrecond_ref(ctx);
   }

   @Override
   public Object visitNew_precond(GameGrammarParser.New_precondContext ctx) {
      return super.visitNew_precond(ctx);
   }

   @Override
   public Object visitPrecond_body(GameGrammarParser.Precond_bodyContext ctx) {
      return super.visitPrecond_body(ctx);
   }

   @Override
   public Object visitPrecond(GameGrammarParser.PrecondContext ctx) {
      return super.visitPrecond(ctx);
   }

   @Override
   public Object visitPostcond_id(GameGrammarParser.Postcond_idContext ctx) {
      return super.visitPostcond_id(ctx);
   }

   @Override
   public Object visitPostcond_ref(GameGrammarParser.Postcond_refContext ctx) {
      return super.visitPostcond_ref(ctx);
   }

   @Override
   public Object visitPostcond_body(GameGrammarParser.Postcond_bodyContext ctx) {
      return super.visitPostcond_body(ctx);
   }

   @Override
   public Object visitNew_postcond(GameGrammarParser.New_postcondContext ctx) {
      return super.visitNew_postcond(ctx);
   }

   @Override
   public Object visitPostcond(GameGrammarParser.PostcondContext ctx) {
      return super.visitPostcond(ctx);
   }

   @Override
   public Object visitPreconds(GameGrammarParser.PrecondsContext ctx) {
      return super.visitPreconds(ctx);
   }

   @Override
   public Object visitTriggers(GameGrammarParser.TriggersContext ctx) {
      return super.visitTriggers(ctx);
   }

   @Override
   public Object visitPostconds(GameGrammarParser.PostcondsContext ctx) {
      return super.visitPostconds(ctx);
   }

   @Override
   public Object visitArgument(GameGrammarParser.ArgumentContext ctx) {
      return super.visitArgument(ctx);
   }

   @Override
   public Object visitArguments(GameGrammarParser.ArgumentsContext ctx) {
      return super.visitArguments(ctx);
   }

   @Override
   public Object visitNew_action(GameGrammarParser.New_actionContext ctx) {
      return super.visitNew_action(ctx);
   }

   @Override
   public Object visitActionformat(GameGrammarParser.ActionformatContext ctx) {
      return super.visitActionformat(ctx);
   }

   @Override
   public Object visitAction_id(GameGrammarParser.Action_idContext ctx) {
      return super.visitAction_id(ctx);
   }

   @Override
   public Object visitAction_ref(GameGrammarParser.Action_refContext ctx) {
      return super.visitAction_ref(ctx);
   }

   @Override
   public Object visitAction(GameGrammarParser.ActionContext ctx) {
      return super.visitAction(ctx);
   }

   @Override
   public Object visitActions(GameGrammarParser.ActionsContext ctx) {
      return super.visitActions(ctx);
   }

   @Override
   public Object visitItem_id(GameGrammarParser.Item_idContext ctx) {
      return super.visitItem_id(ctx);
   }

   @Override
   public Object visitItem_ref(GameGrammarParser.Item_refContext ctx) {
      return super.visitItem_ref(ctx);
   }

   @Override
   public Object visitItem_name(GameGrammarParser.Item_nameContext ctx) {
      return super.visitItem_name(ctx);
   }

   @Override
   public Object visitItem(GameGrammarParser.ItemContext ctx) {
      return super.visitItem(ctx);
   }

   @Override
   public Object visitItems(GameGrammarParser.ItemsContext ctx) {
      return super.visitItems(ctx);
   }

   @Override
   public Object visitNew_item(GameGrammarParser.New_itemContext ctx) {
      return super.visitNew_item(ctx);
   }

   @Override
   public Object visitRoom_name(GameGrammarParser.Room_nameContext ctx) {
      return super.visitRoom_name(ctx);
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
   public Object visitKnowledge_updates(GameGrammarParser.Knowledge_updatesContext ctx) {
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
