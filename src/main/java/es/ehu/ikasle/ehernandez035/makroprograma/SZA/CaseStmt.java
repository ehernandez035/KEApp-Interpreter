package es.ehu.ikasle.ehernandez035.makroprograma.SZA;

import java.util.List;

public class CaseStmt extends Statement {
    Adierazpena bald;
    List<When> balioak;
    List<Statement> others;

    public CaseStmt(Posizioa posizioa, Adierazpena bald, List<When> balioak, List<Statement> others) {
        super(posizioa);
        this.bald = bald;
        this.balioak = balioak;
        this.others = others;
    }

    @Override
    public void execute(SinboloTaula st) {
        boolean exekutatuDa = false;
        for (When when : balioak) {
            if (bald.getValue(st).equals(when.getBalioa().getValue(st))) {
                exekutatuDa = true;
                for (Statement s : when.getStatements()) {
                    s.execute(st);
                }
            }
        }
        if (!exekutatuDa) {
            for (Statement s : others) {
                s.execute(st);
            }
        }
    }

    @Override
    public boolean verifyAlf(SinboloTaula st, List<Errorea> erroreak) {
        boolean zuzena = true;
        if (!bald.verifyAlf(st, erroreak)) zuzena = false;
        for (Statement s : others) {
            if (!s.verifyAlf(st, erroreak)) zuzena = false;
        }
        for (When when: balioak){
            when.getBalioa().verifyAlf(st, erroreak);
            for (Statement s : when.getStatements()) {
                if (!s.verifyAlf(st, erroreak)) zuzena = false;
            }
        }

        return zuzena;
    }

    @Override
    public boolean verify(SinboloTaula st, List<Errorea> erroreak) {
        boolean zuzena = true;
        if (!bald.verify(st, erroreak)) zuzena = false;
        for (Statement s : others) {
            if (!s.verify(st, erroreak)) zuzena = false;
        }
        for (When when: balioak){
            when.getBalioa().verify(st, erroreak);
            for (Statement s : when.getStatements()) {
                if (!s.verify(st, erroreak)) zuzena = false;
            }
        }

        return zuzena;
    }
}
