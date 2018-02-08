package es.ehu.ikasle.ehernandez035.makroprograma.SZA;

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
}
