package es.ehu.ikasle.ehernandez035.whileprograma;

import es.ehu.ikasle.ehernandez035.gramatika.WhileBaseVisitor;
import es.ehu.ikasle.ehernandez035.gramatika.WhileParser;

import java.util.ArrayList;
import java.util.List;

public class MyWhileVisitor extends WhileBaseVisitor<Object> {
    @Override
    public Object visitProg(WhileParser.ProgContext ctx) {
        List<Statement> stmts = new ArrayList<>();
        for (WhileParser.StatementContext sctx : ctx.stmts) {
            stmts.add((Statement) this.visit(sctx));
        }
        return new Programa(stmts);
    }

    @Override
    public Object visitIf(WhileParser.IfContext ctx) {
        List<Statement> stmts = new ArrayList<>();
        for (WhileParser.StatementContext sctx : ctx.stmts) {
            stmts.add((Statement) this.visit(sctx));
        }
        return new IfStmt(irakurriLetra(ctx.bald.getText()), irakurriAldagaia(ctx.ald.getText()), stmts);
    }

    @Override
    public Object visitWhile(WhileParser.WhileContext ctx) {
        List<Statement> stmts = new ArrayList<>();
        for (WhileParser.StatementContext sctx : ctx.stmts) {
            stmts.add((Statement) this.visit(sctx));
        }
        return new WhileStmt(irakurriAldagaia(ctx.ald.getText()), stmts);
    }

    @Override
    public Object visitEsleipen(WhileParser.EsleipenContext ctx) {
        Adierazpena ad = (Adierazpena) this.visit(ctx.ad);
        return new EsleipenStmt(irakurriAldagaia(ctx.ald.getText()), ad);
    }

    @Override
    public Object visitHutsa(WhileParser.HutsaContext ctx) {
        return HutsaExpr.INSTANCE;
    }

    @Override
    public Object visitCdr(WhileParser.CdrContext ctx) {
        return new CdrExpr(irakurriAldagaia(ctx.ald.getText()));
    }

    @Override
    public Object visitCons(WhileParser.ConsContext ctx) {
        return new ConsExpr(irakurriLetra(ctx.cons.getText()), irakurriAldagaia(ctx.ald.getText()));
    }

    private static int irakurriAldagaia(String testua) {
        return Integer.parseInt(testua.substring(1));
    }

    private static char irakurriLetra(String testua) {
        return testua.charAt(testua.length()-1);
    }
}
