package es.ehu.ikasle.ehernandez035.makroprograma.SZA;

public class AldagaiaExpr extends Adierazpena {
    String aldagaia;

    public AldagaiaExpr(String aldagaia) {
        this.aldagaia = aldagaia;
    }

    @Override
    public String getValue(SinboloTaula st) {
        return st.lortuBalioa(aldagaia);
    }
}
