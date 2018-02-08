package es.ehu.ikasle.ehernandez035.makroprograma.SZA;

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
}
