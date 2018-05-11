package es.ehu.ikasle.ehernandez035.makroprograma.SZA;

import java.util.List;

public class CarExpr extends Adierazpena {
    private Adierazpena adierazpena;
    private char letra;

    public CarExpr(Posizioa p, char letra, Adierazpena adierazpena) {
        super(p);
        this.adierazpena = adierazpena;
        this.letra = letra;
    }

    @Override
    public String getValue(SinboloTaula st) {
        String value = this.adierazpena.getValue(st);
        if (!value.isEmpty() && value.charAt(0) == this.letra) {
            return "a";
        } else {
            return "";
        }
    }

    @Override
    public boolean verify(SinboloTaula st, List<Errorea> erroreak) {
        return adierazpena.verify(st, erroreak);
    }


    @Override
    public boolean verifyAlf(SinboloTaula st, List<Errorea> erroreak) {
        boolean zuzena = true;
        if (!st.getAlfabetoa().contains(letra)){
            Errorea e = new Errorea(p, "Alfabeto barneko karaktereak erabili (" + letra + ")");
            erroreak.add(e);
            zuzena=false;
        }
        adierazpena.verifyAlf(st, erroreak);
        return zuzena;
    }
}
