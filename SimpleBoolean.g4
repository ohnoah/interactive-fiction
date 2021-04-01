grammar SimpleBoolean;


parse
 : expression EOF
 ;


list
  : IDENTIFIER
  | stringlist
  | numberlist
  ;

stringlist
 :  BEGL stringelems? ENDL
 ;

numberlist
 :  BEGL numberelems? ENDL
 ;

stringelems
 : stringtype ( SEP stringtype )*
 ;

numberelems
  : numbertype ( SEP numbertype )*
  ;


numbertype
 : DECIMAL
 | IDENTIFIER
 ;

stringtype
 : STRING
 | IDENTIFIER
 ;

booleantype
 : LPAREN booleantype RPAREN #parenBooleanType
 | NOT booleantype #notBooleanType
 | left=IDENTIFIER op=nonboolcomparator right=IDENTIFIER #identifierComparatorBooleantype
 | left=booleantype op=binary right=booleantype #binaryBooleantype
 | left=stringtype op=nonboolcomparator right=stringtype #stringComparatorBooleantype
 | left=numbertype op=nonboolcomparator right=numbertype #numberComparatorBooleantype
 | left=list IS right=list #listComparatorBooleantype
 | stringtype IN list #stringInBooleantype
 | numbertype IN list #numberInBooleantype
 | stringtype SLASH stringtype #inheritBooleantype
 | bool #boolBooleantype
 | IDENTIFIER #identifierBooleantype
 ;

expression
 : booleantype                                  #booleantypeExpression
 ;



nonboolcomparator
 : GT | GE | LT | LE | EQ
 ;

binary
 : AND | OR
 ;

bool
 : TRUE | FALSE
 ;


IS         : 'IS'  ;
IN         : 'IN'  ;
AND        : 'AND' ;
OR         : 'OR' ;
NOT        : 'NOT';
TRUE       : 'TRUE' ;
FALSE      : 'FALSE' ;
GT         : '>' ;
GE         : '>=' ;
LT         : '<' ;
LE         : '<=' ;
EQ         : '=' ;
LPAREN     : '(' ;
RPAREN     : ')' ;
QUOTE      : '"' ;
SLASH      : '/' ;
STRING     : ["] [a-zA-Z0-9'!#$%&()*+,-./:;<=>?@[\]^_`{|}~\r\t\n\u000C ]* ["];
DECIMAL    : '-'? [0-9]+ ( '.' [0-9]+ )? ;
IDENTIFIER : [!]? ([a-zA-Z0-9_.]+) [:] [:] [a-zA-Z0-9]+;

BEGL : '[';
ENDL : ']';
SEP  : ',';
WS   : [ \r\t\u000C\n]+ -> skip;
