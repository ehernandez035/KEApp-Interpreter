package es.ehu.ikasle.ehernandez035.makroprograma.SZA;

import es.ehu.ikasle.ehernandez035.makroprograma.Utils;

import java.util.List;

public class DeskodExpr extends Adierazpena {
    int tamaina;
    int indize;
    Adierazpena adierazpena;

    public DeskodExpr(int tamaina, int indize, Adierazpena adierazpena) {
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
        return indize <= tamaina && adierazpena.verify(st, erroreak);
    }

    @Override
    public boolean verifyAlf(SinboloTaula st, List<String> erroreak) {
        return adierazpena.verifyAlf(st, erroreak);
    }
}
