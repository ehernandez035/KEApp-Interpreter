package es.ehu.ikasle.ehernandez035.makroprograma.SZA;

import java.util.List;

public abstract class Statement {
    public final Posizioa p;

    public Statement(Posizioa p){
        this.p=p;
    }

    public abstract void execute(SinboloTaula st);

    public abstract boolean verifyAlf(SinboloTaula st, List<String> erroreak);

    public abstract boolean verify(SinboloTaula st, List<String> erroreak);

}
