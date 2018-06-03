package es.ehu.ikasle.ehernandez035.whileprograma;

import java.util.List;

public class WhileStmt extends Statement {
    int aldagaia;
    List<Statement> stmts;

    public WhileStmt(int aldagaia, List<Statement> stmts) {
        this.aldagaia = aldagaia;
        this.stmts = stmts;
    }

    @Override
    public void execute(List<String> aldagaiak) {
        while (aldagaiak.get(aldagaia).length()!=0){
            for(Statement s: stmts){
                if (Thread.currentThread().isInterrupted()) return;
                s.execute(aldagaiak);
            }
        }
    }
}
