package es.ehu.ikasle.ehernandez035.makroprograma.SZA;

import java.util.List;

public abstract class Adierazpena {
    public abstract String getValue(SinboloTaula st);

    public boolean verify(SinboloTaula st, List<String> erroreak) {
        return true;
    }

    public boolean verifyAlf(SinboloTaula st, List<String> erroreak){
        return true;
    }
}
