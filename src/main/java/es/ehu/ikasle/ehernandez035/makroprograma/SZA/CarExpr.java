package es.ehu.ikasle.ehernandez035.makroprograma.SZA;

import java.util.List;

public class CarExpr extends Adierazpena {
    Adierazpena adierazpena;
    char letra;

    public CarExpr(Posizioa p, char letra, Adierazpena adierazpena) {
        super(p);
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
        boolean zuzena = true;
        if (!st.getAlfabetoa().contains(letra)){
            erroreak.add("Alfabeto barneko karaktereak erabili (" + letra + ")");
            zuzena=false;
        }
        adierazpena.verifyAlf(st, erroreak);
        return zuzena;
    }
}
