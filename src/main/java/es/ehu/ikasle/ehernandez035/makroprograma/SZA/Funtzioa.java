package es.ehu.ikasle.ehernandez035.makroprograma.SZA;

import java.util.List;

public class Funtzioa implements IFuntzioa {
    private String izena;
    private List<Statement> statements;

    public Funtzioa(List<Statement> statements, String izena) {
        this.izena = izena;
        this.statements = statements;
    }

    @Override
    public String execute(SinboloTaula st) {
        for (Statement s : statements) {
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

    public boolean verifyAlf(SinboloTaula st, List<String> erroreak) {
        for (Statement s : statements) {
            if (!s.verifyAlf(st, erroreak)) return false;
        }
        return true;
    }

    public boolean verify(SinboloTaula st, List<String> erroreak) {
        for (Statement s : statements) {
            if (!s.verify(st, erroreak)) return false;
        }
        return true;
    }
}
