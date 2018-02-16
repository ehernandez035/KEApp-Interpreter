package es.ehu.ikasle.ehernandez035.makroprograma.SZA;

import es.ehu.ikasle.ehernandez035.makroprograma.Utils;

import java.util.List;

public class DeskodExpr extends Adierazpena {
    private int tamaina;
    private int indize;
    private Adierazpena adierazpena;

    public DeskodExpr(Posizioa p, int tamaina, int indize, Adierazpena adierazpena) {
        super(p);
        this.tamaina = tamaina;
        this.indize = indize;
        this.adierazpena = adierazpena;
    }

    @Override
    public String getValue(SinboloTaula st) {
        return Utils.dekod(st.getAlfabetoa(), this.adierazpena.getValue(st), this.tamaina)[indize - 1];
    }

    @Override
    public boolean verify(SinboloTaula st, List<String> erroreak) {
        boolean zuzena = true;
        if(indize > tamaina){
            erroreak.add("Deskod_" + tamaina + "_" + indize + ": " + indize + " <= " + tamaina + " izan behar du");
            zuzena=false;
        }
        if(adierazpena.verify(st, erroreak)){
            zuzena=false;
        }
        return zuzena;
    }

    @Override
    public boolean verifyAlf(SinboloTaula st, List<String> erroreak) {
        return (adierazpena.verifyAlf(st, erroreak));
    }
}
