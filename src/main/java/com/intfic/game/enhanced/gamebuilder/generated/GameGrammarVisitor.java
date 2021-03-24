// Generated from /Users/noahohrner/OneDrive - University of Cambridge/Dissertation/Code/interactive-fiction/GameGrammar.g4 by ANTLR 4.9.1
package com.intfic.game.enhanced.gamebuilder.generated;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link GameGrammarParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface GameGrammarVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link GameGrammarParser#new_message}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNew_message(GameGrammarParser.New_messageContext ctx);
	/**
	 * Visit a parse tree produced by {@link GameGrammarParser#message_id}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMessage_id(GameGrammarParser.Message_idContext ctx);
	/**
	 * Visit a parse tree produced by {@link GameGrammarParser#message_text}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMessage_text(GameGrammarParser.Message_textContext ctx);
	/**
	 * Visit a parse tree produced by {@link GameGrammarParser#message_ref}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMessage_ref(GameGrammarParser.Message_refContext ctx);
	/**
	 * Visit a parse tree produced by {@link GameGrammarParser#message}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMessage(GameGrammarParser.MessageContext ctx);
	/**
	 * Visit a parse tree produced by {@link GameGrammarParser#trigger_selector}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTrigger_selector(GameGrammarParser.Trigger_selectorContext ctx);
	/**
	 * Visit a parse tree produced by {@link GameGrammarParser#trigger}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTrigger(GameGrammarParser.TriggerContext ctx);
	/**
	 * Visit a parse tree produced by {@link GameGrammarParser#precond_id}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrecond_id(GameGrammarParser.Precond_idContext ctx);
	/**
	 * Visit a parse tree produced by {@link GameGrammarParser#precond_ref}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrecond_ref(GameGrammarParser.Precond_refContext ctx);
	/**
	 * Visit a parse tree produced by {@link GameGrammarParser#new_precond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNew_precond(GameGrammarParser.New_precondContext ctx);
	/**
	 * Visit a parse tree produced by {@link GameGrammarParser#precond_body}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrecond_body(GameGrammarParser.Precond_bodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link GameGrammarParser#precond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrecond(GameGrammarParser.PrecondContext ctx);
	/**
	 * Visit a parse tree produced by {@link GameGrammarParser#postcond_id}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPostcond_id(GameGrammarParser.Postcond_idContext ctx);
	/**
	 * Visit a parse tree produced by {@link GameGrammarParser#postcond_ref}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPostcond_ref(GameGrammarParser.Postcond_refContext ctx);
	/**
	 * Visit a parse tree produced by {@link GameGrammarParser#postcond_body}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPostcond_body(GameGrammarParser.Postcond_bodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link GameGrammarParser#new_postcond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNew_postcond(GameGrammarParser.New_postcondContext ctx);
	/**
	 * Visit a parse tree produced by {@link GameGrammarParser#postcond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPostcond(GameGrammarParser.PostcondContext ctx);
	/**
	 * Visit a parse tree produced by {@link GameGrammarParser#preconds}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPreconds(GameGrammarParser.PrecondsContext ctx);
	/**
	 * Visit a parse tree produced by {@link GameGrammarParser#triggers}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTriggers(GameGrammarParser.TriggersContext ctx);
	/**
	 * Visit a parse tree produced by {@link GameGrammarParser#postconds}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPostconds(GameGrammarParser.PostcondsContext ctx);
	/**
	 * Visit a parse tree produced by {@link GameGrammarParser#argument}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgument(GameGrammarParser.ArgumentContext ctx);
	/**
	 * Visit a parse tree produced by {@link GameGrammarParser#arguments}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArguments(GameGrammarParser.ArgumentsContext ctx);
	/**
	 * Visit a parse tree produced by {@link GameGrammarParser#new_action}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNew_action(GameGrammarParser.New_actionContext ctx);
	/**
	 * Visit a parse tree produced by {@link GameGrammarParser#add_trigger}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdd_trigger(GameGrammarParser.Add_triggerContext ctx);
	/**
	 * Visit a parse tree produced by {@link GameGrammarParser#actionformat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitActionformat(GameGrammarParser.ActionformatContext ctx);
	/**
	 * Visit a parse tree produced by {@link GameGrammarParser#action_id}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAction_id(GameGrammarParser.Action_idContext ctx);
	/**
	 * Visit a parse tree produced by {@link GameGrammarParser#action_ref}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAction_ref(GameGrammarParser.Action_refContext ctx);
	/**
	 * Visit a parse tree produced by {@link GameGrammarParser#action}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAction(GameGrammarParser.ActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link GameGrammarParser#actions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitActions(GameGrammarParser.ActionsContext ctx);
	/**
	 * Visit a parse tree produced by {@link GameGrammarParser#item_id}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitItem_id(GameGrammarParser.Item_idContext ctx);
	/**
	 * Visit a parse tree produced by {@link GameGrammarParser#item_ref}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitItem_ref(GameGrammarParser.Item_refContext ctx);
	/**
	 * Visit a parse tree produced by {@link GameGrammarParser#item_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitItem_name(GameGrammarParser.Item_nameContext ctx);
	/**
	 * Visit a parse tree produced by {@link GameGrammarParser#item}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitItem(GameGrammarParser.ItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link GameGrammarParser#items}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitItems(GameGrammarParser.ItemsContext ctx);
	/**
	 * Visit a parse tree produced by {@link GameGrammarParser#item_adjective}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitItem_adjective(GameGrammarParser.Item_adjectiveContext ctx);
	/**
	 * Visit a parse tree produced by {@link GameGrammarParser#item_adjectives}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitItem_adjectives(GameGrammarParser.Item_adjectivesContext ctx);
	/**
	 * Visit a parse tree produced by {@link GameGrammarParser#item_synonym}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitItem_synonym(GameGrammarParser.Item_synonymContext ctx);
	/**
	 * Visit a parse tree produced by {@link GameGrammarParser#item_synonyms}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitItem_synonyms(GameGrammarParser.Item_synonymsContext ctx);
	/**
	 * Visit a parse tree produced by {@link GameGrammarParser#new_item}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNew_item(GameGrammarParser.New_itemContext ctx);
	/**
	 * Visit a parse tree produced by {@link GameGrammarParser#room_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRoom_name(GameGrammarParser.Room_nameContext ctx);
	/**
	 * Visit a parse tree produced by {@link GameGrammarParser#new_room}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNew_room(GameGrammarParser.New_roomContext ctx);
	/**
	 * Visit a parse tree produced by {@link GameGrammarParser#genericframe_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGenericframe_name(GameGrammarParser.Genericframe_nameContext ctx);
	/**
	 * Visit a parse tree produced by {@link GameGrammarParser#map_entry}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMap_entry(GameGrammarParser.Map_entryContext ctx);
	/**
	 * Visit a parse tree produced by {@link GameGrammarParser#map_entries}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMap_entries(GameGrammarParser.Map_entriesContext ctx);
	/**
	 * Visit a parse tree produced by {@link GameGrammarParser#new_genericframe}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNew_genericframe(GameGrammarParser.New_genericframeContext ctx);
	/**
	 * Visit a parse tree produced by {@link GameGrammarParser#knowledge_update}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKnowledge_update(GameGrammarParser.Knowledge_updateContext ctx);
	/**
	 * Visit a parse tree produced by {@link GameGrammarParser#knowledge_updates}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKnowledge_updates(GameGrammarParser.Knowledge_updatesContext ctx);
	/**
	 * Visit a parse tree produced by {@link GameGrammarParser#global_item}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGlobal_item(GameGrammarParser.Global_itemContext ctx);
	/**
	 * Visit a parse tree produced by {@link GameGrammarParser#global_items}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGlobal_items(GameGrammarParser.Global_itemsContext ctx);
	/**
	 * Visit a parse tree produced by {@link GameGrammarParser#inheritance}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInheritance(GameGrammarParser.InheritanceContext ctx);
	/**
	 * Visit a parse tree produced by {@link GameGrammarParser#inheritances}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInheritances(GameGrammarParser.InheritancesContext ctx);
	/**
	 * Visit a parse tree produced by {@link GameGrammarParser#knowledge}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKnowledge(GameGrammarParser.KnowledgeContext ctx);
	/**
	 * Visit a parse tree produced by {@link GameGrammarParser#start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart(GameGrammarParser.StartContext ctx);
	/**
	 * Visit a parse tree produced by {@link GameGrammarParser#game}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGame(GameGrammarParser.GameContext ctx);
}