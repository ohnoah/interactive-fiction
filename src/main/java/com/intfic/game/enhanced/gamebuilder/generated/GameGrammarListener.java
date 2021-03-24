// Generated from /Users/noahohrner/OneDrive - University of Cambridge/Dissertation/Code/interactive-fiction/GameGrammar.g4 by ANTLR 4.9.1
package com.intfic.game.enhanced.gamebuilder.generated;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link GameGrammarParser}.
 */
public interface GameGrammarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link GameGrammarParser#new_message}.
	 * @param ctx the parse tree
	 */
	void enterNew_message(GameGrammarParser.New_messageContext ctx);
	/**
	 * Exit a parse tree produced by {@link GameGrammarParser#new_message}.
	 * @param ctx the parse tree
	 */
	void exitNew_message(GameGrammarParser.New_messageContext ctx);
	/**
	 * Enter a parse tree produced by {@link GameGrammarParser#message_id}.
	 * @param ctx the parse tree
	 */
	void enterMessage_id(GameGrammarParser.Message_idContext ctx);
	/**
	 * Exit a parse tree produced by {@link GameGrammarParser#message_id}.
	 * @param ctx the parse tree
	 */
	void exitMessage_id(GameGrammarParser.Message_idContext ctx);
	/**
	 * Enter a parse tree produced by {@link GameGrammarParser#message_text}.
	 * @param ctx the parse tree
	 */
	void enterMessage_text(GameGrammarParser.Message_textContext ctx);
	/**
	 * Exit a parse tree produced by {@link GameGrammarParser#message_text}.
	 * @param ctx the parse tree
	 */
	void exitMessage_text(GameGrammarParser.Message_textContext ctx);
	/**
	 * Enter a parse tree produced by {@link GameGrammarParser#message_ref}.
	 * @param ctx the parse tree
	 */
	void enterMessage_ref(GameGrammarParser.Message_refContext ctx);
	/**
	 * Exit a parse tree produced by {@link GameGrammarParser#message_ref}.
	 * @param ctx the parse tree
	 */
	void exitMessage_ref(GameGrammarParser.Message_refContext ctx);
	/**
	 * Enter a parse tree produced by {@link GameGrammarParser#message}.
	 * @param ctx the parse tree
	 */
	void enterMessage(GameGrammarParser.MessageContext ctx);
	/**
	 * Exit a parse tree produced by {@link GameGrammarParser#message}.
	 * @param ctx the parse tree
	 */
	void exitMessage(GameGrammarParser.MessageContext ctx);
	/**
	 * Enter a parse tree produced by {@link GameGrammarParser#trigger_selector}.
	 * @param ctx the parse tree
	 */
	void enterTrigger_selector(GameGrammarParser.Trigger_selectorContext ctx);
	/**
	 * Exit a parse tree produced by {@link GameGrammarParser#trigger_selector}.
	 * @param ctx the parse tree
	 */
	void exitTrigger_selector(GameGrammarParser.Trigger_selectorContext ctx);
	/**
	 * Enter a parse tree produced by {@link GameGrammarParser#trigger}.
	 * @param ctx the parse tree
	 */
	void enterTrigger(GameGrammarParser.TriggerContext ctx);
	/**
	 * Exit a parse tree produced by {@link GameGrammarParser#trigger}.
	 * @param ctx the parse tree
	 */
	void exitTrigger(GameGrammarParser.TriggerContext ctx);
	/**
	 * Enter a parse tree produced by {@link GameGrammarParser#precond_id}.
	 * @param ctx the parse tree
	 */
	void enterPrecond_id(GameGrammarParser.Precond_idContext ctx);
	/**
	 * Exit a parse tree produced by {@link GameGrammarParser#precond_id}.
	 * @param ctx the parse tree
	 */
	void exitPrecond_id(GameGrammarParser.Precond_idContext ctx);
	/**
	 * Enter a parse tree produced by {@link GameGrammarParser#precond_ref}.
	 * @param ctx the parse tree
	 */
	void enterPrecond_ref(GameGrammarParser.Precond_refContext ctx);
	/**
	 * Exit a parse tree produced by {@link GameGrammarParser#precond_ref}.
	 * @param ctx the parse tree
	 */
	void exitPrecond_ref(GameGrammarParser.Precond_refContext ctx);
	/**
	 * Enter a parse tree produced by {@link GameGrammarParser#new_precond}.
	 * @param ctx the parse tree
	 */
	void enterNew_precond(GameGrammarParser.New_precondContext ctx);
	/**
	 * Exit a parse tree produced by {@link GameGrammarParser#new_precond}.
	 * @param ctx the parse tree
	 */
	void exitNew_precond(GameGrammarParser.New_precondContext ctx);
	/**
	 * Enter a parse tree produced by {@link GameGrammarParser#precond_body}.
	 * @param ctx the parse tree
	 */
	void enterPrecond_body(GameGrammarParser.Precond_bodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link GameGrammarParser#precond_body}.
	 * @param ctx the parse tree
	 */
	void exitPrecond_body(GameGrammarParser.Precond_bodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link GameGrammarParser#precond}.
	 * @param ctx the parse tree
	 */
	void enterPrecond(GameGrammarParser.PrecondContext ctx);
	/**
	 * Exit a parse tree produced by {@link GameGrammarParser#precond}.
	 * @param ctx the parse tree
	 */
	void exitPrecond(GameGrammarParser.PrecondContext ctx);
	/**
	 * Enter a parse tree produced by {@link GameGrammarParser#postcond_id}.
	 * @param ctx the parse tree
	 */
	void enterPostcond_id(GameGrammarParser.Postcond_idContext ctx);
	/**
	 * Exit a parse tree produced by {@link GameGrammarParser#postcond_id}.
	 * @param ctx the parse tree
	 */
	void exitPostcond_id(GameGrammarParser.Postcond_idContext ctx);
	/**
	 * Enter a parse tree produced by {@link GameGrammarParser#postcond_ref}.
	 * @param ctx the parse tree
	 */
	void enterPostcond_ref(GameGrammarParser.Postcond_refContext ctx);
	/**
	 * Exit a parse tree produced by {@link GameGrammarParser#postcond_ref}.
	 * @param ctx the parse tree
	 */
	void exitPostcond_ref(GameGrammarParser.Postcond_refContext ctx);
	/**
	 * Enter a parse tree produced by {@link GameGrammarParser#postcond_body}.
	 * @param ctx the parse tree
	 */
	void enterPostcond_body(GameGrammarParser.Postcond_bodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link GameGrammarParser#postcond_body}.
	 * @param ctx the parse tree
	 */
	void exitPostcond_body(GameGrammarParser.Postcond_bodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link GameGrammarParser#new_postcond}.
	 * @param ctx the parse tree
	 */
	void enterNew_postcond(GameGrammarParser.New_postcondContext ctx);
	/**
	 * Exit a parse tree produced by {@link GameGrammarParser#new_postcond}.
	 * @param ctx the parse tree
	 */
	void exitNew_postcond(GameGrammarParser.New_postcondContext ctx);
	/**
	 * Enter a parse tree produced by {@link GameGrammarParser#postcond}.
	 * @param ctx the parse tree
	 */
	void enterPostcond(GameGrammarParser.PostcondContext ctx);
	/**
	 * Exit a parse tree produced by {@link GameGrammarParser#postcond}.
	 * @param ctx the parse tree
	 */
	void exitPostcond(GameGrammarParser.PostcondContext ctx);
	/**
	 * Enter a parse tree produced by {@link GameGrammarParser#preconds}.
	 * @param ctx the parse tree
	 */
	void enterPreconds(GameGrammarParser.PrecondsContext ctx);
	/**
	 * Exit a parse tree produced by {@link GameGrammarParser#preconds}.
	 * @param ctx the parse tree
	 */
	void exitPreconds(GameGrammarParser.PrecondsContext ctx);
	/**
	 * Enter a parse tree produced by {@link GameGrammarParser#triggers}.
	 * @param ctx the parse tree
	 */
	void enterTriggers(GameGrammarParser.TriggersContext ctx);
	/**
	 * Exit a parse tree produced by {@link GameGrammarParser#triggers}.
	 * @param ctx the parse tree
	 */
	void exitTriggers(GameGrammarParser.TriggersContext ctx);
	/**
	 * Enter a parse tree produced by {@link GameGrammarParser#postconds}.
	 * @param ctx the parse tree
	 */
	void enterPostconds(GameGrammarParser.PostcondsContext ctx);
	/**
	 * Exit a parse tree produced by {@link GameGrammarParser#postconds}.
	 * @param ctx the parse tree
	 */
	void exitPostconds(GameGrammarParser.PostcondsContext ctx);
	/**
	 * Enter a parse tree produced by {@link GameGrammarParser#argument}.
	 * @param ctx the parse tree
	 */
	void enterArgument(GameGrammarParser.ArgumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link GameGrammarParser#argument}.
	 * @param ctx the parse tree
	 */
	void exitArgument(GameGrammarParser.ArgumentContext ctx);
	/**
	 * Enter a parse tree produced by {@link GameGrammarParser#arguments}.
	 * @param ctx the parse tree
	 */
	void enterArguments(GameGrammarParser.ArgumentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link GameGrammarParser#arguments}.
	 * @param ctx the parse tree
	 */
	void exitArguments(GameGrammarParser.ArgumentsContext ctx);
	/**
	 * Enter a parse tree produced by {@link GameGrammarParser#new_action}.
	 * @param ctx the parse tree
	 */
	void enterNew_action(GameGrammarParser.New_actionContext ctx);
	/**
	 * Exit a parse tree produced by {@link GameGrammarParser#new_action}.
	 * @param ctx the parse tree
	 */
	void exitNew_action(GameGrammarParser.New_actionContext ctx);
	/**
	 * Enter a parse tree produced by {@link GameGrammarParser#add_trigger}.
	 * @param ctx the parse tree
	 */
	void enterAdd_trigger(GameGrammarParser.Add_triggerContext ctx);
	/**
	 * Exit a parse tree produced by {@link GameGrammarParser#add_trigger}.
	 * @param ctx the parse tree
	 */
	void exitAdd_trigger(GameGrammarParser.Add_triggerContext ctx);
	/**
	 * Enter a parse tree produced by {@link GameGrammarParser#actionformat}.
	 * @param ctx the parse tree
	 */
	void enterActionformat(GameGrammarParser.ActionformatContext ctx);
	/**
	 * Exit a parse tree produced by {@link GameGrammarParser#actionformat}.
	 * @param ctx the parse tree
	 */
	void exitActionformat(GameGrammarParser.ActionformatContext ctx);
	/**
	 * Enter a parse tree produced by {@link GameGrammarParser#action_id}.
	 * @param ctx the parse tree
	 */
	void enterAction_id(GameGrammarParser.Action_idContext ctx);
	/**
	 * Exit a parse tree produced by {@link GameGrammarParser#action_id}.
	 * @param ctx the parse tree
	 */
	void exitAction_id(GameGrammarParser.Action_idContext ctx);
	/**
	 * Enter a parse tree produced by {@link GameGrammarParser#action_ref}.
	 * @param ctx the parse tree
	 */
	void enterAction_ref(GameGrammarParser.Action_refContext ctx);
	/**
	 * Exit a parse tree produced by {@link GameGrammarParser#action_ref}.
	 * @param ctx the parse tree
	 */
	void exitAction_ref(GameGrammarParser.Action_refContext ctx);
	/**
	 * Enter a parse tree produced by {@link GameGrammarParser#action}.
	 * @param ctx the parse tree
	 */
	void enterAction(GameGrammarParser.ActionContext ctx);
	/**
	 * Exit a parse tree produced by {@link GameGrammarParser#action}.
	 * @param ctx the parse tree
	 */
	void exitAction(GameGrammarParser.ActionContext ctx);
	/**
	 * Enter a parse tree produced by {@link GameGrammarParser#actions}.
	 * @param ctx the parse tree
	 */
	void enterActions(GameGrammarParser.ActionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link GameGrammarParser#actions}.
	 * @param ctx the parse tree
	 */
	void exitActions(GameGrammarParser.ActionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link GameGrammarParser#item_id}.
	 * @param ctx the parse tree
	 */
	void enterItem_id(GameGrammarParser.Item_idContext ctx);
	/**
	 * Exit a parse tree produced by {@link GameGrammarParser#item_id}.
	 * @param ctx the parse tree
	 */
	void exitItem_id(GameGrammarParser.Item_idContext ctx);
	/**
	 * Enter a parse tree produced by {@link GameGrammarParser#item_ref}.
	 * @param ctx the parse tree
	 */
	void enterItem_ref(GameGrammarParser.Item_refContext ctx);
	/**
	 * Exit a parse tree produced by {@link GameGrammarParser#item_ref}.
	 * @param ctx the parse tree
	 */
	void exitItem_ref(GameGrammarParser.Item_refContext ctx);
	/**
	 * Enter a parse tree produced by {@link GameGrammarParser#item_name}.
	 * @param ctx the parse tree
	 */
	void enterItem_name(GameGrammarParser.Item_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link GameGrammarParser#item_name}.
	 * @param ctx the parse tree
	 */
	void exitItem_name(GameGrammarParser.Item_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link GameGrammarParser#item}.
	 * @param ctx the parse tree
	 */
	void enterItem(GameGrammarParser.ItemContext ctx);
	/**
	 * Exit a parse tree produced by {@link GameGrammarParser#item}.
	 * @param ctx the parse tree
	 */
	void exitItem(GameGrammarParser.ItemContext ctx);
	/**
	 * Enter a parse tree produced by {@link GameGrammarParser#items}.
	 * @param ctx the parse tree
	 */
	void enterItems(GameGrammarParser.ItemsContext ctx);
	/**
	 * Exit a parse tree produced by {@link GameGrammarParser#items}.
	 * @param ctx the parse tree
	 */
	void exitItems(GameGrammarParser.ItemsContext ctx);
	/**
	 * Enter a parse tree produced by {@link GameGrammarParser#item_adjective}.
	 * @param ctx the parse tree
	 */
	void enterItem_adjective(GameGrammarParser.Item_adjectiveContext ctx);
	/**
	 * Exit a parse tree produced by {@link GameGrammarParser#item_adjective}.
	 * @param ctx the parse tree
	 */
	void exitItem_adjective(GameGrammarParser.Item_adjectiveContext ctx);
	/**
	 * Enter a parse tree produced by {@link GameGrammarParser#item_adjectives}.
	 * @param ctx the parse tree
	 */
	void enterItem_adjectives(GameGrammarParser.Item_adjectivesContext ctx);
	/**
	 * Exit a parse tree produced by {@link GameGrammarParser#item_adjectives}.
	 * @param ctx the parse tree
	 */
	void exitItem_adjectives(GameGrammarParser.Item_adjectivesContext ctx);
	/**
	 * Enter a parse tree produced by {@link GameGrammarParser#item_synonym}.
	 * @param ctx the parse tree
	 */
	void enterItem_synonym(GameGrammarParser.Item_synonymContext ctx);
	/**
	 * Exit a parse tree produced by {@link GameGrammarParser#item_synonym}.
	 * @param ctx the parse tree
	 */
	void exitItem_synonym(GameGrammarParser.Item_synonymContext ctx);
	/**
	 * Enter a parse tree produced by {@link GameGrammarParser#item_synonyms}.
	 * @param ctx the parse tree
	 */
	void enterItem_synonyms(GameGrammarParser.Item_synonymsContext ctx);
	/**
	 * Exit a parse tree produced by {@link GameGrammarParser#item_synonyms}.
	 * @param ctx the parse tree
	 */
	void exitItem_synonyms(GameGrammarParser.Item_synonymsContext ctx);
	/**
	 * Enter a parse tree produced by {@link GameGrammarParser#new_item}.
	 * @param ctx the parse tree
	 */
	void enterNew_item(GameGrammarParser.New_itemContext ctx);
	/**
	 * Exit a parse tree produced by {@link GameGrammarParser#new_item}.
	 * @param ctx the parse tree
	 */
	void exitNew_item(GameGrammarParser.New_itemContext ctx);
	/**
	 * Enter a parse tree produced by {@link GameGrammarParser#room_name}.
	 * @param ctx the parse tree
	 */
	void enterRoom_name(GameGrammarParser.Room_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link GameGrammarParser#room_name}.
	 * @param ctx the parse tree
	 */
	void exitRoom_name(GameGrammarParser.Room_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link GameGrammarParser#new_room}.
	 * @param ctx the parse tree
	 */
	void enterNew_room(GameGrammarParser.New_roomContext ctx);
	/**
	 * Exit a parse tree produced by {@link GameGrammarParser#new_room}.
	 * @param ctx the parse tree
	 */
	void exitNew_room(GameGrammarParser.New_roomContext ctx);
	/**
	 * Enter a parse tree produced by {@link GameGrammarParser#genericframe_name}.
	 * @param ctx the parse tree
	 */
	void enterGenericframe_name(GameGrammarParser.Genericframe_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link GameGrammarParser#genericframe_name}.
	 * @param ctx the parse tree
	 */
	void exitGenericframe_name(GameGrammarParser.Genericframe_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link GameGrammarParser#map_entry}.
	 * @param ctx the parse tree
	 */
	void enterMap_entry(GameGrammarParser.Map_entryContext ctx);
	/**
	 * Exit a parse tree produced by {@link GameGrammarParser#map_entry}.
	 * @param ctx the parse tree
	 */
	void exitMap_entry(GameGrammarParser.Map_entryContext ctx);
	/**
	 * Enter a parse tree produced by {@link GameGrammarParser#map_entries}.
	 * @param ctx the parse tree
	 */
	void enterMap_entries(GameGrammarParser.Map_entriesContext ctx);
	/**
	 * Exit a parse tree produced by {@link GameGrammarParser#map_entries}.
	 * @param ctx the parse tree
	 */
	void exitMap_entries(GameGrammarParser.Map_entriesContext ctx);
	/**
	 * Enter a parse tree produced by {@link GameGrammarParser#new_genericframe}.
	 * @param ctx the parse tree
	 */
	void enterNew_genericframe(GameGrammarParser.New_genericframeContext ctx);
	/**
	 * Exit a parse tree produced by {@link GameGrammarParser#new_genericframe}.
	 * @param ctx the parse tree
	 */
	void exitNew_genericframe(GameGrammarParser.New_genericframeContext ctx);
	/**
	 * Enter a parse tree produced by {@link GameGrammarParser#knowledge_update}.
	 * @param ctx the parse tree
	 */
	void enterKnowledge_update(GameGrammarParser.Knowledge_updateContext ctx);
	/**
	 * Exit a parse tree produced by {@link GameGrammarParser#knowledge_update}.
	 * @param ctx the parse tree
	 */
	void exitKnowledge_update(GameGrammarParser.Knowledge_updateContext ctx);
	/**
	 * Enter a parse tree produced by {@link GameGrammarParser#knowledge_updates}.
	 * @param ctx the parse tree
	 */
	void enterKnowledge_updates(GameGrammarParser.Knowledge_updatesContext ctx);
	/**
	 * Exit a parse tree produced by {@link GameGrammarParser#knowledge_updates}.
	 * @param ctx the parse tree
	 */
	void exitKnowledge_updates(GameGrammarParser.Knowledge_updatesContext ctx);
	/**
	 * Enter a parse tree produced by {@link GameGrammarParser#global_item}.
	 * @param ctx the parse tree
	 */
	void enterGlobal_item(GameGrammarParser.Global_itemContext ctx);
	/**
	 * Exit a parse tree produced by {@link GameGrammarParser#global_item}.
	 * @param ctx the parse tree
	 */
	void exitGlobal_item(GameGrammarParser.Global_itemContext ctx);
	/**
	 * Enter a parse tree produced by {@link GameGrammarParser#global_items}.
	 * @param ctx the parse tree
	 */
	void enterGlobal_items(GameGrammarParser.Global_itemsContext ctx);
	/**
	 * Exit a parse tree produced by {@link GameGrammarParser#global_items}.
	 * @param ctx the parse tree
	 */
	void exitGlobal_items(GameGrammarParser.Global_itemsContext ctx);
	/**
	 * Enter a parse tree produced by {@link GameGrammarParser#inheritance}.
	 * @param ctx the parse tree
	 */
	void enterInheritance(GameGrammarParser.InheritanceContext ctx);
	/**
	 * Exit a parse tree produced by {@link GameGrammarParser#inheritance}.
	 * @param ctx the parse tree
	 */
	void exitInheritance(GameGrammarParser.InheritanceContext ctx);
	/**
	 * Enter a parse tree produced by {@link GameGrammarParser#knowledge}.
	 * @param ctx the parse tree
	 */
	void enterKnowledge(GameGrammarParser.KnowledgeContext ctx);
	/**
	 * Exit a parse tree produced by {@link GameGrammarParser#knowledge}.
	 * @param ctx the parse tree
	 */
	void exitKnowledge(GameGrammarParser.KnowledgeContext ctx);
	/**
	 * Enter a parse tree produced by {@link GameGrammarParser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(GameGrammarParser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link GameGrammarParser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(GameGrammarParser.StartContext ctx);
	/**
	 * Enter a parse tree produced by {@link GameGrammarParser#game}.
	 * @param ctx the parse tree
	 */
	void enterGame(GameGrammarParser.GameContext ctx);
	/**
	 * Exit a parse tree produced by {@link GameGrammarParser#game}.
	 * @param ctx the parse tree
	 */
	void exitGame(GameGrammarParser.GameContext ctx);
}