package es.ehu.ikasle.ehernandez035.makroprograma.SZA;

import es.ehu.ikasle.ehernandez035.makroprograma.Utils;

import java.math.BigInteger;
import java.util.List;

import static es.ehu.ikasle.ehernandez035.makroprograma.SZA.AlderaketakExpr.Alderaketa.Biderketa;

public class AlderaketakExpr extends Adierazpena {


    private Adierazpena ad1;
    private Adierazpena ad2;
    private Alderaketa eragiketa;

    public AlderaketakExpr(Posizioa p, Adierazpena ad1, Adierazpena ad2, Alderaketa eragiketa) {
        super(p);
        this.ad1 = ad1;
        this.ad2 = ad2;
        this.eragiketa = eragiketa;
        if (eragiketa == null) throw new IllegalArgumentException("Eragiketa cannot be null");
    }


    @Override
    public String getValue(SinboloTaula st) {
        BigInteger zb1 = Utils.hitzakZenbakira(st.getAlfabetoa(), ad1.getValue(st));
        BigInteger zb2 = Utils.hitzakZenbakira(st.getAlfabetoa(), ad2.getValue(st));

        int diffSign = zb1.subtract(zb2).signum();

        switch (eragiketa) {
            case EQ:
                return diffSign == 0 ? "a" : "";
            case LE:
                return diffSign <= 0 ? "a" : "";
            case GE:
                return diffSign >= 0 ? "a" : "";
            case GT:
                return diffSign > 0 ? "a" : "";
            case LT:
                return diffSign < 0 ? "a" : "";
            case NE:
                return diffSign != 0 ? "a" : "";
            case AND:
                return (zb1.signum() != 0 && zb2.signum() != 0) ? "a" : "";
            case OR:
                return (zb1.signum() != 0 || zb2.signum() != 0) ? "a" : "";
            case Batuketa:
                return Utils.zenbakiaHitzera(st.getAlfabetoa(),zb1.add(zb2));
            case Kenketa:
                return diffSign <= 0 ? "" : Utils.zenbakiaHitzera(st.getAlfabetoa(),zb1.subtract(zb2));
            case Biderketa:
                return Utils.zenbakiaHitzera(st.getAlfabetoa(),zb1.multiply(zb2));

        }
        return null;
    }


    public enum Alderaketa {
        EQ, LE, GE, GT, LT, NE, AND, OR, Batuketa, Kenketa, Biderketa
    }

    @Override
    public boolean verify(SinboloTaula st, List<Errorea> erroreak){
        return (ad1.verify(st, erroreak) && ad2.verify(st, erroreak));
    }

    @Override
    public boolean verifyAlf(SinboloTaula st, List<Errorea> erroreak){
        return (ad1.verifyAlf(st, erroreak) && ad2.verifyAlf(st, erroreak));
    }



}
