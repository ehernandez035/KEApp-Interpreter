package es.ehu.ikasle.ehernandez035.makroprograma.SZA;

import es.ehu.ikasle.ehernandez035.makroprograma.Utils;

public class AlderaketakExpr extends Adierazpena {


    Adierazpena ad1;
    Adierazpena ad2;
    Alderaketa eragiketa;

    public AlderaketakExpr(Adierazpena ad1, Adierazpena ad2, Alderaketa eragiketa) {
        this.ad1 = ad1;
        this.ad2 = ad2;
        this.eragiketa = eragiketa;
    }


    @Override
    public String getValue(SinboloTaula st) {
        int zb1 = Utils.hitzakZenbakira(st.getAlfabetoa(), ad1.getValue(st));
        int zb2 = Utils.hitzakZenbakira(st.getAlfabetoa(), ad2.getValue(st));

        switch (eragiketa) {
            case EQ:
                return zb1 == zb2 ? "a" : "";
            case LE:
                return zb1 <= zb2 ? "a" : "";
            case GE:
                return zb1 >= zb2 ? "a" : "";
            case GT:
                return zb1 > zb2 ? "a" : "";
            case LT:
                return zb1 < zb2 ? "a" : "";
            case NE:
                return zb1 != zb2 ? "a" : "";
            case AND:
                return (zb1 != 0 && zb2!= 0) ? "a" : "";
            case OR:
                return (zb1 != 0 || zb2!= 0) ? "a" : "";
        }
        return null;
    }


    public enum Alderaketa {
        EQ, LE, GE, GT, LT, NE, AND, OR
    }
}
