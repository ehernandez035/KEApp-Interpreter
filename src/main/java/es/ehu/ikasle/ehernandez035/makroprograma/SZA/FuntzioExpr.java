package es.ehu.ikasle.ehernandez035.makroprograma.SZA;

import java.util.List;

public class FuntzioExpr extends Adierazpena {
    private String funtzioIzena;
    private List<Adierazpena> parametroak;

    public FuntzioExpr(Posizioa p, String funtzioIzena, List<Adierazpena> parametroak) {
        super(p);
        this.funtzioIzena = funtzioIzena;
        this.parametroak = parametroak;
    }

    @Override
    public String getValue(SinboloTaula st) {
        IFuntzioa f = st.lortuFuntzioa(funtzioIzena);
        SinboloTaula funtzioTaula = new SinboloTaula(st);
        for (int i = 0; i < parametroak.size(); i++) {
            funtzioTaula.gordeAldagaia("X" + Integer.toString(i + 1), parametroak.get(i).getValue(st));
        }
        return f.execute(funtzioTaula);
    }

    @Override
    public boolean verify(SinboloTaula st, List<String> erroreak) {
        boolean zuzena = true;
        if (st.lortuFuntzioa(funtzioIzena) == null) {
            erroreak.add(funtzioIzena + "funtzioa ez da existitzen");
            zuzena = false;
        }
        for (Adierazpena ad : parametroak) {
            if (!ad.verify(st, erroreak)) {
                zuzena = false;
            }
        }
        return zuzena;
    }

    @Override
    public boolean verifyAlf(SinboloTaula st, List<String> erroreak) {
        boolean zuzena = true;
        for (Adierazpena ad : parametroak) {
            if (!ad.verifyAlf(st, erroreak)) zuzena = false;
        }
        return zuzena;
    }

}
