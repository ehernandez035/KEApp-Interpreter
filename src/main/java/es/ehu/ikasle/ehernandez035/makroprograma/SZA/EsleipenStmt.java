package es.ehu.ikasle.ehernandez035.makroprograma.SZA;

import java.util.List;

public class EsleipenStmt extends Statement {
    private String izena;
    private Adierazpena adierazpena;

    public EsleipenStmt(Posizioa p, String izena, Adierazpena adierazpena) {
        super(p);
        this.izena = izena;
        this.adierazpena = adierazpena;
    }

    @Override
    public void execute(SinboloTaula st) {
        st.gordeAldagaia(izena, adierazpena.getValue(st));
    }

    @Override
    public boolean verify(SinboloTaula st, List<Errorea> erroreak) {
        return (adierazpena.verify(st, erroreak));
    }


    @Override
    public boolean verifyAlf(SinboloTaula st, List<Errorea> erroreak) {
        return (!adierazpena.verifyAlf(st, erroreak));
    }
}
