package es.ehu.ikasle.ehernandez035.makroprograma.SZA;

import java.util.List;

public class IfStmt extends Statement {
    private Adierazpena baldintza;
    private List<Statement> trueStmts;
    private List<When> elsifStmts;
    private List<Statement> falseStmts;

    public IfStmt(Posizioa p, Adierazpena baldintza, List<Statement> trueStmts, List<When> elsifStmts, List<Statement> falseStmts) {
        super(p);
        this.baldintza = baldintza;
        this.trueStmts = trueStmts;
        this.elsifStmts = elsifStmts;
        this.falseStmts = falseStmts;
    }

    public void execute(SinboloTaula st) {
        if (!baldintza.getValue(st).isEmpty()) {
            for (Statement s : this.trueStmts) {
                if (Thread.currentThread().isInterrupted()) return;
                s.execute(st);
            }
        } else {
            for (When when : this.elsifStmts) {
                if (!when.getBalioa().getValue(st).isEmpty()) {
                    for (Statement s : when.getStatements()) {
                        if (Thread.currentThread().isInterrupted()) return;
                        s.execute(st);
                    }
                    return;
                }
            }
            for (Statement s : this.falseStmts) {
                if (Thread.currentThread().isInterrupted()) return;
                s.execute(st);
            }
        }
    }

    @Override
    public boolean verify(SinboloTaula st, List<Errorea> erroreak) {
        boolean zuzena = true;
        if (!baldintza.verify(st, erroreak)) zuzena = false;
        for (Statement s : trueStmts) {
            if (!s.verify(st, erroreak)) zuzena = false;
        }
        for (When when : elsifStmts) {
            when.getBalioa().verify(st, erroreak);
            for (Statement s : when.getStatements()) {
                if (!s.verify(st, erroreak)) zuzena = false;
            }
        }

        for (Statement s : falseStmts) {
            if (!s.verify(st, erroreak)) zuzena = false;
        }
        return zuzena;
    }

    @Override
    public boolean verifyAlf(SinboloTaula st, List<Errorea> erroreak) {
        boolean zuzena = true;
        if (!baldintza.verifyAlf(st, erroreak)) zuzena = false;
        for (Statement s : trueStmts) {
            if (!s.verifyAlf(st, erroreak)) zuzena = false;
        }
        for (When when : elsifStmts) {
            when.getBalioa().verifyAlf(st, erroreak);
            for (Statement s : when.getStatements()) {
                if (!s.verifyAlf(st, erroreak)) zuzena = false;
            }
        }

        for (Statement s : falseStmts) {
            if (!s.verifyAlf(st, erroreak)) zuzena = false;
        }
        return zuzena;
    }


}
