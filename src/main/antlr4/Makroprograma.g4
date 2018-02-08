grammar Makroprograma;

prog: funtz+=func+ EOF;

func: 'def' ald=ALDAGAIA '?'? 'begin' stmts+=statement* 'end def' ';';

statement: 'if' bald=adierazpena 'then' stmts+=statement* ('else' falseStmts+=statement*)? 'end if' ';'  # if
         | 'while' bald=adierazpena 'loop' stmts+=statement* 'end loop' ';'  # while
//       | 'for'
         | ald=ALDAGAIA ':=' ad=adierazpena ';'                                           # esleipen
         ;

adierazpena: 'hutsa'                                                                # hutsa
           | cons=CONSX '(' ad=adierazpena ')'                                      # cons
           | car=CARX '?' '(' ad=adierazpena ')'                                    # car
           | deskod=DESKOD '(' ad=adierazpena ')'                                   # deskod
           | hitz=HITZA                                                             # hitza
           | ald=ALDAGAIA                                                           # aldagaia
           | ald=ALDAGAIA '?'? '(' (arg+=adierazpena (',' arg+=adierazpena)* )? ')' # funtzioDeia
           | ad=adierazpena erag=ERAG ad=adierazpena                                # alderaketak
           | 'not' ad=adierazpena                                                   # notAdierazpena
           ;

ERAG: ('=' | '>=' | '<=' | '>' | '<' | '/=' | 'and' | 'or');
HITZA: '"' [a-zA-Z]* '"';
CONSX: 'cons_' [a-z] ;
CARX: 'car_' [a-zA-Z] ;
DESKOD: 'deskod_' [0-9]+ '_' [0-9]+ ;
ALDAGAIA: [a-zA-Z][a-zA-Z0-9_]* ;
COMMENT: '--' [^\n\r]* -> skip;

WS : [ \t\r\n]+ -> skip;