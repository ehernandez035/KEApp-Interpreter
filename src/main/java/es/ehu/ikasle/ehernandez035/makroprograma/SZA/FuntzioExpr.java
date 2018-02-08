package es.ehu.ikasle.ehernandez035.makroprograma.SZA;

import java.util.List;

public class FuntzioExpr extends Adierazpena {
    String funtzioIzena;
    List<Adierazpena> parametroak;

    public FuntzioExpr(String funtzioIzena, List<Adierazpena> parametroak) {
        this.funtzioIzena = funtzioIzena;
        this.parametroak = parametroak;
    }

    @Override
    public String getValue(SinboloTaula st) {
        IFuntzioa f = st.lortuFuntzioa(funtzioIzena);
        SinboloTaula funtzioTaula = new SinboloTaula(st);
        for (int i = 0; i<parametroak.size(); i++) {
            funtzioTaula.gordeAldagaia("X" + Integer.toString(i+1), parametroak.get(i).getValue(st));
        }
        return f.execute(funtzioTaula);
    }
}
