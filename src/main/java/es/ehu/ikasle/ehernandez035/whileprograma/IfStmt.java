package es.ehu.ikasle.ehernandez035.whileprograma;

import java.util.List;

public class IfStmt extends Statement {
    char kar;
    int aldagaia;
    List<Statement> stmts;

    public IfStmt(char kar, int aldagaia, List<Statement> stmts) {
        this.kar = kar;
        this.aldagaia = aldagaia;
        this.stmts = stmts;
    }

    @Override
    public void execute(List<String> aldagaiak) {
        if (aldagaiak.get(aldagaia).charAt(0)==kar){
            for(Statement s: stmts){
                if (Thread.currentThread().isInterrupted()) return;
                s.execute(aldagaiak);
            }
        }
    }
}
