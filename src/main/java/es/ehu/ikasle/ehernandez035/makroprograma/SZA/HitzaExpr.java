package es.ehu.ikasle.ehernandez035.makroprograma.SZA;

public class HitzaExpr extends Adierazpena {
    String hitza;

    public HitzaExpr(String hitza) {
        this.hitza = hitza;

    }

    @Override
    public String getValue(SinboloTaula st) {
        return this.hitza;
    }
}
