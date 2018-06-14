grammar While;		
prog:	stmts+=statement*  EOF ;
statement: 'if' bald=CAR_X '?' '(' ald=ALDAGAIA ')' 'then' stmts+=statement+ 'end if' ';'  # if
         | 'while' 'nonem?' '(' ald=ALDAGAIA ')' 'loop' stmts+=statement+ 'end loop' ';'   # while
         | ald=ALDAGAIA ':=' ad=adierazpena ';'                                            # esleipen
         ;

adierazpena: 'hutsa'                          # hutsa
           | 'cdr' '(' ald=ALDAGAIA ')'       # cdr
           | cons=CONS_X '(' ald=ALDAGAIA ')' # cons
           ;

ALDAGAIA: 'X' [0-9]+ ;
CAR_X: 'car_' [a-zA-Z];
CONS_X: 'cons_' [a-zA-Z];
COMMENT: '--' [^\n\r]* -> skip;

WS : [ \t\r\n]+ -> skip;