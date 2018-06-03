package es.ehu.ikasle.ehernandez035.makroprograma.SZA;

import java.util.List;

public class Funtzioa implements IFuntzioa {
    private String izena;
    private List<Statement> statements;
    private Posizioa p;

    public Funtzioa(Posizioa p, List<Statement> statements, String izena) {
        this.p = p;
        this.izena = izena;
        this.statements = statements;
    }

    @Override
    public String execute(SinboloTaula st) {
        for (Statement s : statements) {
            if (Thread.currentThread().isInterrupted()) return "";
            s.execute(st);
        }
        return st.lortuBalioa("X0");
    }

    @Override
    public String getIzena() {
        return izena;
    }

    public List<Statement> getStatements() {
        return statements;
    }

    public boolean verifyAlf(SinboloTaula st, List<Errorea> erroreak) {
        boolean zuzena = true;
        for (Statement s : statements) {
            if (!s.verifyAlf(st, erroreak)) zuzena = false;
        }
        return zuzena;
    }

    public boolean verify(SinboloTaula st, List<Errorea> erroreak) {
        boolean zuzena = true;
        for (Statement s : statements) {
            if (!s.verify(st, erroreak)) zuzena = false;
        }
        return zuzena;
    }
}
