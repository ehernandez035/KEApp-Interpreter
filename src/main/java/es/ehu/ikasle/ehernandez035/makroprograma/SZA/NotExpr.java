package es.ehu.ikasle.ehernandez035.makroprograma.SZA;

import java.util.List;

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

    @Override
    public boolean verify(SinboloTaula st, List<Errorea> erroreak){
        return adierazpena.verify(st, erroreak);
    }

    @Override
    public boolean verifyAlf(SinboloTaula st, List<Errorea> erroreak){
        return adierazpena.verifyAlf(st, erroreak);
    }
}
