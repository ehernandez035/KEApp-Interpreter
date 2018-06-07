grammar Makroprograma;

prog: funtz+=func+ EOF;

func: 'def' ald=ALDAGAIA '?'? 'begin' stmts+=statement* 'end def' ';';

statement: 'if' bald=adierazpena 'then' stmts+=statement* elif+=elsif* ('else' falseStmts+=statement*)? 'end if' ';'           # if
         | 'while' bald=adierazpena 'loop' stmts+=statement* 'end loop' ';'                                       # while
         | 'for' ind=ALDAGAIA 'in' has=adierazpena  '..' buk=adierazpena 'loop' stmts+=statement* 'end loop' ';'  # for
         | 'for' ind=ALDAGAIA 'in' has=ZENB '..' buk=ZENB 'loop' stmts+=statement* 'end loop' ';'                 # forZenbaki
         | 'case' ad=adierazpena 'is' w+=when+ ('when' 'others' '=>' otherStmts+=statement+)? 'end case' ';'      # caseMakroa
         | ald=ALDAGAIA ':=' ad=adierazpena ';'                                                                   # esleipen
         ;
elsif: 'elsif' bald=adierazpena 'then' stmts+=statement*;
when: 'when' ad=adierazpena '=>' stmts+=statement+;

adierazpena: ('hutsa' | 'phutsa')                                                   # hutsa
           | cons=CONSX '(' ad=adierazpena ')'                                      # cons
           | car=CARX '?' '(' ad=adierazpena ')'                                    # car
           | deskod=DESKOD '(' ad=adierazpena ')'                                   # deskod
           | hitz=HITZA                                                             # hitza
           | ald=ALDAGAIA                                                           # aldagaia
           | ald=ALDAGAIA '?'? '(' (arg+=adierazpena (',' arg+=adierazpena)* )? ')' # funtzioDeia
           | ad1=adierazpena erag=ERAG ad2=adierazpena                              # alderaketak
           | 'not' ad=adierazpena                                                   # notAdierazpena
           ;

ERAG: ('=' | '>=' | '<=' | '>' | '<' | '/=' | 'and' | 'or' | '+' | '-' | '*');
HITZA: '"' [a-zA-Z]* '"';
CONSX: 'cons_' [a-z] ;
CARX: 'car_' [a-zA-Z] ;
DESKOD: 'deskod_' [0-9]+ '_' [0-9]+ ;
ALDAGAIA: [a-zA-Z][a-zA-Z0-9_]* ;
ZENB: [0-9]+ ;
COMMENT: '--'~[\n\r]* -> skip;
WS : [ \t\r\n]+ -> skip;