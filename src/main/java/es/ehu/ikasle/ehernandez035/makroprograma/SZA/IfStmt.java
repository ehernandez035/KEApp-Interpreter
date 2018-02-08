package es.ehu.ikasle.ehernandez035.makroprograma.SZA;

import java.util.List;

public class IfStmt extends Statement {
    private Adierazpena baldintza;
    private List<Statement> trueStmts;
    private List<Statement> falseStmts;

    public IfStmt(Adierazpena baldintza, List<Statement> trueStmts, List<Statement> falseStmts) {
        this.baldintza = baldintza;
        this.trueStmts = trueStmts;
        this.falseStmts = falseStmts;
    }

    public void execute(SinboloTaula st) {
        if (!baldintza.getValue(st).isEmpty()) {
            for (Statement s : this.trueStmts) {
                s.execute(st);
            }
        } else {
            for (Statement s : this.falseStmts) {
                s.execute(st);
            }
        }
    }


}
