package es.ehu.ikasle.ehernandez035.makroprograma.SZA;

import java.util.List;

public class When {
    private Adierazpena balioa;
    private List<Statement> statements;

    public When(Adierazpena balioa, List<Statement> statements) {
        this.balioa = balioa;
        this.statements = statements;
    }

    public Adierazpena getBalioa() {
        return balioa;
    }

    public List<Statement> getStatements() {
        return statements;
    }
}
