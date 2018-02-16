package es.ehu.ikasle.ehernandez035.makroprograma.SZA;

import java.util.List;

public class IfStmt extends Statement {
    private Adierazpena baldintza;
    private List<Statement> trueStmts;
    private List<Statement> falseStmts;

    public IfStmt(Posizioa p, Adierazpena baldintza, List<Statement> trueStmts, List<Statement> falseStmts) {
        super(p);
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

    @Override
    public boolean verify(SinboloTaula st, List<String> erroreak) {
        boolean zuzena = true;
        if (!baldintza.verify(st, erroreak)) zuzena = false;
        for (Statement s : trueStmts) {
            if (!s.verify(st, erroreak)) zuzena = false;
        }
        for (Statement s : falseStmts) {
            if (!s.verify(st, erroreak)) zuzena = false;
        }
        return zuzena;
    }

    @Override
    public boolean verifyAlf(SinboloTaula st, List<String> erroreak) {
        boolean zuzena = true;
        if (!baldintza.verifyAlf(st, erroreak)) zuzena = false;
        for (Statement s : trueStmts) {
            if (!s.verifyAlf(st, erroreak)) zuzena = false;
        }
        for (Statement s : falseStmts) {
            if (!s.verifyAlf(st, erroreak)) zuzena = false;
        }
        return zuzena;
    }


}
