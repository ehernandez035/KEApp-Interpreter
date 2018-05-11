package es.ehu.ikasle.ehernandez035.makroprograma.SZA;

import java.util.List;

public class AldagaiaExpr extends Adierazpena {
    private String aldagaia;

    public AldagaiaExpr(Posizioa p, String aldagaia) {
        super(p);
        this.aldagaia = aldagaia;
    }

    @Override
    public String getValue(SinboloTaula st) {
        return st.lortuBalioa(aldagaia);
    }
}
