package es.ehu.ikasle.ehernandez035.makroprograma.SZA;

import es.ehu.ikasle.ehernandez035.makroprograma.Utils;

import java.math.BigInteger;
import java.util.List;

public class ForZenbakiStmt extends Statement {
    String aldagaia;
    private final int has;
    private final int buk;
    List<Statement> statements;


    public ForZenbakiStmt(Posizioa p, String aldagaia, int has, int buk, List<Statement> statements) {
        super(p);
        this.aldagaia = aldagaia;
        this.has = has;
        this.buk = buk;
        this.statements = statements;
    }

    @Override
    public void execute(SinboloTaula st) {
        for (int x = has; x < buk; x++) {
            st.gordeAldagaia(aldagaia, Utils.zenbakiaHitzera(st.getAlfabetoa(), BigInteger.valueOf(x)));
            for (Statement s : statements) {
                if (Thread.currentThread().isInterrupted()) return;
                s.execute(st);
            }
        }


    }

    @Override
    public boolean verify(SinboloTaula st, List<Errorea> erroreak) {
        boolean zuzena = true;

        for (Statement s : statements) {
            if (!s.verify(st, erroreak)) zuzena = false;
        }
        return zuzena;
    }

    @Override
    public boolean verifyAlf(SinboloTaula st, List<Errorea> erroreak) {
        boolean zuzena = true;
        for (Statement s : statements) {
            if (!s.verifyAlf(st, erroreak)) zuzena = false;
        }
        return zuzena;
    }
}
