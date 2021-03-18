grammar GameGrammar;

ID : LPAREN ALPHABETIC RPAREN;

new_message
    : MESSAGE
    LCURLY
    message_id SEMICOLON
    STRING SEMICOLON
    RCURLY;

message_id : MESSAGE_ID;

message_text : STRING;

message_ref
    : HASH message_id;

message : message_ref | message_text;

trigger:
    ALPHABETIC ( INTEGER)?
;


precond_id : ID;
precond_ref : HASH precond_id;
new_precond : PRECOND LCURLY
     precond_id SEMICOLON
     precond_body SEMICOLON
     RCURLY;

// UPDATE TO USE EXPRESSION
precond_body : SINGLE_QUOTE STRING SINGLE_QUOTE (LPAREN STRING RPAREN);


postcond_id : ID;
postcond_ref : HASH postcond_id;
// UPDATE
postcond_body : STRING;
new_postcond : POSTCOND LCURLY postcond_id SEMICOLON postcond_body SEMICOLON RCURLY;
precond :  | precond_ref
;

preconds:
  LSQUARE (precond (COMMA precond)*)? RSQUARE
;

triggers
    :
    trigger (COMMA trigger)*;

postconds: LSQUARE;

new_action
    : ACTION
    LCURLY
    action_id SEMICOLON
    DOT TRIGGERS triggers SEMICOLON
    DOT preconds SEMICOLON
    DOT postconds SEMICOLON
    DOT SUCCESSMESSAGE message SEMICOLON
    RCURLY;

actionformat:
   LCURLY
   ALPHABETIC SEMICOLON
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
item : STRING | item_ref;
items: (item (COMMA item)*)?;

room_name : STRING;

new_room:
    LCURLY
    DOT NAME room_name SEMICOLON
    DOT ACTION actions SEMICOLON
    DOT ITEMS items SEMICOLON
    RCURLY
    ;

knowledge:
    LCURLY
    RCURLY
;

game
 : START (new_message|new_action|new_room|knowledge|actionformat|new_postcond|new_precond) EOF
 ;

// TOP-LEVEL STARTER BLOCKS
START      : 'start';
MESSAGE    : 'message';
ACTION     : 'action';
ROOM       : 'room';
KNOWLEDGE  : 'knowledge';
PRECOND    : 'precond';
POSTCOND   : 'postcond';

MESSAGE_ID : LPAREN STRING RPAREN;
MESSAGE_REF : HASH MESSAGE_ID;

LCURLY     : '{' ;
RCURLY     : '}' ;
LSQUARE    : '[' ;
RSQUARE    : ']' ;
HASH       : '#' ;
LPAREN     : '(' ;
RPAREN     : ')' ;
SEMICOLON  : ';';
DOT        : '.';
QUOTE      : '"' ;
SINGLE_QUOTE      : '\'' ;
ALPHABETIC : [a-zA-Z]+;
STRING     : QUOTE [a-zA-Z0-9'!#$%&()*+,-./:;<=>?@[\]^_`{|}~\r\t\n\u000C ]* QUOTE;
INTEGER    : [0-9]+;
DECIMAL    : '-'? [0-9]+ ( '.' [0-9]+ )? ;


ACTIONS    : 'actions';
ITEMS    : 'items';
NAME    : 'name';
SUCCESSMESSAGE    : 'success_msg';
TRIGGERS : 'triggers';

IDENTIFIER : [!]? ([a-zA-Z0-9_.]+) [:] [:] [a-zA-Z0-9]+;

COMMA  : ',';
WS   : [ \r\t\u000C\n]+ -> skip;
