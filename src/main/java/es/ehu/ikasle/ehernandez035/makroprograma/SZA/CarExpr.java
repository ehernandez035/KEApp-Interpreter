package es.ehu.ikasle.ehernandez035.makroprograma.SZA;

import java.util.List;

public class CarExpr extends Adierazpena {
    Adierazpena adierazpena;
    char letra;

    public CarExpr(char letra, Adierazpena adierazpena) {
        this.adierazpena = adierazpena;
        this.letra = letra;
    }

    @Override
    public String getValue(SinboloTaula st) {
        if (this.adierazpena.getValue(st).charAt(0) == this.letra) {
            return "a";
        } else {
            return "";
        }
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
