package es.ehu.ikasle.ehernandez035.makroprograma.SZA;

public class HutsaExpr extends Adierazpena {

    private HutsaExpr() {
        super(new Posizioa(0,0,0,0));
    }

    public static final HutsaExpr INSTANCE = new HutsaExpr();

    @Override
    public String getValue(SinboloTaula st) {
        return "";
    }
}
