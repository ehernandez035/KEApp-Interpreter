package es.ehu.ikasle.ehernandez035.programa;

import java.util.List;

public class Programa {
    List<Statement> statements;

    public Programa(List<Statement> statements) {
        this.statements = statements;
    }

    public String execute(List<String> aldagaiak) {
        for(Statement s: statements){
            s.execute(aldagaiak);
        }
        return aldagaiak.get(0);
    }
}
