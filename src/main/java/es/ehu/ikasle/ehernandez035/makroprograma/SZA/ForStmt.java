package es.ehu.ikasle.ehernandez035.makroprograma.SZA;

import es.ehu.ikasle.ehernandez035.makroprograma.Utils;

import java.math.BigInteger;
import java.util.List;

public class ForStmt extends Statement {
    String aldagaia;
    private final Adierazpena has;
    private final Adierazpena buk;
    List<Statement> statements;


    public ForStmt(Posizioa p, String aldagaia, Adierazpena has, Adierazpena buk, List<Statement> statements) {
        super(p);
        this.aldagaia = aldagaia;
        this.has = has;
        this.buk = buk;
        this.statements = statements;
    }

    @Override
    public void execute(SinboloTaula st) {
        BigInteger has_value = Utils.hitzakZenbakira(st.getAlfabetoa(), has.getValue(st));
        BigInteger buk_value = Utils.hitzakZenbakira(st.getAlfabetoa(), buk.getValue(st));


        for (BigInteger x = has_value; x.subtract(buk_value).signum() < 0; x = x.add(BigInteger.ONE)) {
            st.gordeAldagaia(aldagaia, Utils.zenbakiaHitzera(st.getAlfabetoa(), x));
            for (Statement s : statements) {
                if (Thread.currentThread().isInterrupted()) return;
                s.execute(st);
            }
        }


    }

    @Override
    public boolean verify(SinboloTaula st, List<Errorea> erroreak) {
        boolean zuzena = true;


        if (!has.verify(st, erroreak)) {
            zuzena = false;
        }
        if (!buk.verify(st, erroreak)) {
            zuzena = false;
        }
        for (Statement s : statements) {
            if (!s.verify(st, erroreak)) zuzena = false;
        }
        return zuzena;
    }

    @Override
    public boolean verifyAlf(SinboloTaula st, List<Errorea> erroreak) {
        boolean zuzena = true;
        if (!has.verifyAlf(st, erroreak)) {
            zuzena = false;
        }
        if (!buk.verifyAlf(st, erroreak)) {
            zuzena = false;
        }
        for (Statement s : statements) {
            if (!s.verifyAlf(st, erroreak)) zuzena = false;
        }
        return zuzena;
    }
}
