grammar GameGrammar;

ID : LPAREN ALPHANUMERIC RPAREN;

new_message
    : MESSAGE
    LCURLY
    message_id SEMICOLON
    STRING SEMICOLON
    RCURLY;

message_id : ID;

message_text : STRING;

message_ref
    : HASH message_id;

message : message_ref | message_text;


trigger_selector : TRIGGER_SELECTOR;

trigger:
    ALPHANUMERIC trigger_selector?
;



precond_id : ID;
precond_ref : HASH precond_id;
new_precond : PRECOND LCURLY
     precond_id SEMICOLON
     precond_body SEMICOLON
     RCURLY;

// UPDATE TO USE EXPRESSION
precond_body : SINGLE_STRING LPAREN STRING RPAREN;
precond :  precond_body | precond_ref
;


postcond_id : ID;
postcond_ref : HASH postcond_id;
// UPDATE
postcond_body : SINGLE_STRING;
new_postcond : POSTCOND LCURLY postcond_id SEMICOLON postcond_body SEMICOLON RCURLY;

postcond : postcond_body | postcond_ref;

preconds:
  LSQUARE (precond (COMMA precond)*)? RSQUARE
;

triggers
    : LSQUARE trigger (COMMA trigger)* RSQUARE;

postconds: LSQUARE (postcond (COMMA postcond)*)? RSQUARE;

argument : item_ref | STRING;
arguments : LSQUARE (argument (COMMA argument)*)? RSQUARE;

new_action
    : ACTION
    LCURLY
    action_id SEMICOLON
    DOT ROOM room_name SEMICOLON
    DOT TRIGGERS_SYNTAX triggers SEMICOLON
    DOT ARGUMENTS arguments SEMICOLON
    DOT PRECONDS preconds SEMICOLON
    DOT POSTCONDS postconds SEMICOLON
    DOT SUCCESSMESSAGE message SEMICOLON
    RCURLY;

actionformat:
   CUSTOM_TRIGGER
   LCURLY
   ALPHANUMERIC SEMICOLON
   (STRING SEMICOLON)?
   RCURLY
   ;

// Items can be either strings for empty shells or reference to complex block with knowledgeupdates

action_id : ID;
action_ref : HASH action_id;
action : action_ref;
actions: (action (COMMA action)*)? ;

item_id : ID;
item_ref : HASH item_id;
item_name : STRING;
item : item_name | item_ref;
items: (item (COMMA item)*)?;


new_item :
    ITEM
    LCURLY
    item_id SEMICOLON
    DOT ROOM room_name SEMICOLON
    DOT ITEM_NAME item_name SEMICOLON
    DOT ITEM_KNOWLEDGE knowledge_updates SEMICOLON
    RCURLY;

room_name : STRING;


new_room:
    ROOM
    LCURLY
    DOT ROOM_NAME room_name SEMICOLON
    DOT ACTIONS_SYNTAX actions SEMICOLON
    DOT ITEMS items SEMICOLON
    RCURLY
    ;


genericframe_name : STRING;
map_entry : ALPHANUMERIC EQUALS (DECIMAL|STRING|STRINGLIST|NUMBERLIST|BOOLEAN);
new_genericframe :
    GENERICFRAME
    LCURLY
    genericframe_name SEMICOLON
    LSQUARE (map_entry (COMMA map_entry)*)? RSQUARE SEMICOLON
    RCURLY;


// CHANGE TO EXPRESSION
knowledge_update : SINGLE_STRING;
knowledge_updates : LSQUARE (knowledge_update (COMMA knowledge_update)*)? RSQUARE;

global_item : item_id | STRING;
global_items : global_item (COMMA global_item)*?;
inheritance : LSQUARE global_items RSQUARE INHERITS STRING;
knowledge:
    KNOWLEDGE
    LCURLY
    DOT GENERIC_INHERITANCE inheritance (COMMA inheritance) SEMICOLON
    DOT INITIAL knowledge_updates? SEMICOLON
    RCURLY
;

start : START
 LCURLY
 room_name SEMICOLON
 STRING SEMICOLON
 RCURLY;

game
 : start (new_message|new_action|new_item|new_room|actionformat|new_postcond|new_precond)* new_genericframe* knowledge? EOF
 ;

// Parsing should go something like ITEMS -> ROOMS -> MESSAGES -> PRECONDS -> POSTCONDS -> ACTIONS ->
// NEED ERROR if same item is given to multiple rooms

LCURLY     : '{' ;
RCURLY     : '}' ;
LSQUARE    : '[' ;
RSQUARE    : ']' ;
HASH       : '#' ;


// TOP-LEVEL STARTER BLOCKS
START      : 'start';
MESSAGE    : 'message';
ACTION     : 'action';
ROOM       : 'room';
ITEM       : 'item';
KNOWLEDGE  : 'knowledge';
PRECOND    : 'precond';
POSTCOND   : 'postcond';
GENERICFRAME   : 'generic_frame';
CUSTOM_TRIGGER    : 'custom_trigger';
INITIAL : 'initial';
POSTCONDS : 'postconds';
PRECONDS  : 'preconds';


COMMA  : ',';
ACTIONS_SYNTAX    : 'actions';
ITEMS    : 'items';
NAME    : 'name';
SUCCESSMESSAGE    : 'success_msg';
TRIGGERS_SYNTAX : 'action_triggers';
ARGUMENTS : 'args';
PARENTS   : 'parents';
INHERITS  : 'inherits';
ROOM_NAME : 'room_name';
ITEM_NAME : 'item_name';
ITEM_KNOWLEDGE : 'item_knowledge';
GENERIC_INHERITANCE : 'generic_inheritance';
TRIGGER_SELECTOR : DASH INTEGER;


SINGLE_STRING     : SINGLE_QUOTE ["a-zA-Z0-9!#$%&()*+,./:;<=>?@[\]^_`{|}~\r\t\n\u000C ]* SINGLE_QUOTE;
STRING     : QUOTE ['a-zA-Z0-9!#$%&()*+,./:;<=>?@[\]^_`{|}~\r\t\n\u000C ]* QUOTE;
ALPHANUMERIC : [a-zA-Z0-9]+;
INTEGER    : [0-9]+;
DECIMAL    : '-'? [0-9]+ ( '.' [0-9]+ )? ;

LPAREN     : '(' ;
RPAREN     : ')' ;
SEMICOLON  : ';';
DOT        : '.';
EQUALS     : '<-';
fragment DASH     : '-';
fragment QUOTE      : '"' ;
fragment SINGLE_QUOTE      : '\'' ;



//IDENTIFIER : [!]? ([a-zA-Z0-9_.]+) [:] [:] [a-zA-Z0-9]+;

WS   : [ \r\t\u000C\n]+ -> skip;
