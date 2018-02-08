package es.ehu.ikasle.ehernandez035.makroprograma.SZA;

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
}
