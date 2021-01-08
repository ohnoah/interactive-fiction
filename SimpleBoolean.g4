grammar SimpleBoolean;

parse
 : expression EOF
 ;


list
  : stringlist
  | numberlist
  ;

stringlist
 :  BEGL stringelems? ENDL
 | IDENTIFIER
 ;

numberlist
 :  BEGL numberelems? ENDL
 | IDENTIFIER
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
 | left=booleantype op=boolcomparator right=booleantype #boolcomparatorBooleantype
 | left=booleantype op=binary right=booleantype #binaryBooleantype
 | left=stringtype op=nonboolcomparator right=stringtype #stringComparatorBooleantype
 | left=numbertype op=nonboolcomparator right=numbertype #numberComparatorBooleantype
 | left=list op=listcomparator right=list #listComparatorBooleantype
 | stringtype IN stringlist #stringInBooleantype
 | numbertype IN numberlist #numberInBooleantype
 | bool #boolBooleantype
 | IDENTIFIER #identifierBooleantype
 ;

expression
 : booleantype                                  #booleantypeExpression
 ;

boolcomparator
 : EQ
 ;

listcomparator
  : EQ
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
STRING     : ["] [a-zA-Z0-9'!#$%&()*+,-./:;<=>?@[\]^_`{|}~\r\t\n\u000C ]* ["];
DECIMAL    : '-'? [0-9]+ ( '.' [0-9]+ )? ;
IDENTIFIER : [_]? [a-zA-Z0-9]* [:] [:] [a-zA-Z0-9]* ;

BEGL : '[';
ENDL : ']';
SEP  : ',';
WS   : [ \r\t\u000C\n]+ -> skip;
