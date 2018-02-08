package es.ehu.ikasle.ehernandez035.makroprograma.SZA;

import java.util.List;

public class WhileStmt extends Statement {
    List<Statement> statements;
    Adierazpena baldintza;

    public WhileStmt(List<Statement> statements, Adierazpena baldintza) {
        this.statements = statements;
        this.baldintza = baldintza;
    }

    @Override
    public void execute(SinboloTaula st) {
        while (!baldintza.getValue(st).isEmpty()) {
            for (Statement s : this.statements) {
                s.execute(st);
            }
        }
    }
}
