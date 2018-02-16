package es.ehu.ikasle.ehernandez035.makroprograma.SZA;

public class NotExpr extends Adierazpena {
    Adierazpena adierazpena;

    public NotExpr(Posizioa p, Adierazpena adierazpena) {
        super(p);
        this.adierazpena = adierazpena;
    }

    @Override
    public String getValue(SinboloTaula st) {
        return adierazpena.getValue(st).length() != 0 ? "" : "a";
    }
}
