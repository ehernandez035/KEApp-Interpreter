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

    @Override
    public boolean verify(SinboloTaula st, List<String> erroreak) {
        if (!baldintza.verify(st, erroreak)) return false;
        for (Statement s : statements) {
            if (!s.verify(st, erroreak)) return false;
        }
        return true;
    }

    @Override
    public boolean verifyAlf(SinboloTaula st, List<String> erroreak) {
        if (!baldintza.verifyAlf(st, erroreak)) return false;
        for (Statement s : statements) {
            if (!s.verifyAlf(st, erroreak)) return false;
        }
        return true;
    }
}
