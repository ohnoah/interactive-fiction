grammar Constants;


typeconvert
 : expression EOF;

expression
 : BEGL stringelems? ENDL #stringelemsExpression
 | BEGL numberelems? ENDL #numberelemsExpression
 | STRING #stringExpression
 | DECIMAL #decimalExpression
 ;

stringelems
 : STRING ( SEP STRING )*
 ;

numberelems
  : DECIMAL ( SEP DECIMAL )*
  ;



QUOTE      : '"' ;
STRING     : ["] [a-zA-Z0-9!#$%&()*+,-./:;<=>?@[\]^_`{|}~\r\t\n\u000C ]* ["];
DECIMAL    : '-'? [0-9]+ ( '.' [0-9]+ )? ;

BEGL : '[';
ENDL : ']';
SEP  : ',';
WS   : [ \r\t\u000C\n]+ -> skip;
