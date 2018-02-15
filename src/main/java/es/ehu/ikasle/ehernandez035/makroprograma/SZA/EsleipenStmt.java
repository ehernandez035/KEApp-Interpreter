package es.ehu.ikasle.ehernandez035.makroprograma.SZA;

import java.util.List;

public class EsleipenStmt extends Statement {
    String izena;
    Adierazpena adierazpena;

    public EsleipenStmt(String izena, Adierazpena adierazpena) {
        this.izena = izena;
        this.adierazpena = adierazpena;
    }

    @Override
    public void execute(SinboloTaula st) {
        st.gordeAldagaia(izena, adierazpena.getValue(st));
    }

    @Override
    public boolean verify(SinboloTaula st, List<String> erroreak) {
        if (st.lortuBalioa(izena) != null) {
            return false;
        }
        return (!adierazpena.verify(st, erroreak));
    }


    @Override
    public boolean verifyAlf(SinboloTaula st, List<String> erroreak) {
        return (!adierazpena.verifyAlf(st, erroreak));
    }
}
