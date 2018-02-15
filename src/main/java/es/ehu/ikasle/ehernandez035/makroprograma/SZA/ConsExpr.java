package es.ehu.ikasle.ehernandez035.makroprograma.SZA;

import java.util.List;

public class ConsExpr extends Adierazpena {
    private Adierazpena adierazpena;
    private char letra;

    public ConsExpr(Adierazpena adierazpena, char letra) {
        this.adierazpena = adierazpena;
        this.letra = letra;
    }

    @Override
    public String getValue(SinboloTaula st) {
        return letra + adierazpena.getValue(st);
    }

    @Override
    public boolean verify(SinboloTaula st, List<String> erroreak) {
        return adierazpena.verify(st, erroreak);
    }

    @Override
    public boolean verifyAlf(SinboloTaula st, List<String> erroreak) {
        if (st.getAlfabetoa().contains(letra)) return false;
        return adierazpena.verifyAlf(st, erroreak);
    }
}
