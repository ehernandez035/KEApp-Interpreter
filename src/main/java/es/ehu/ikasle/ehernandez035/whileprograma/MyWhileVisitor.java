package es.ehu.ikasle.ehernandez035.whileprograma;//package es.ehu.ikasle.ehernandez035.whileprograma;

import es.ehu.ikasle.ehernandez035.gramatika.WhileBaseVisitor;
import es.ehu.ikasle.ehernandez035.gramatika.WhileParser;
import es.ehu.ikasle.ehernandez035.makroprograma.SZA.*;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;

import java.util.ArrayList;
import java.util.List;

public class MyWhileVisitor extends WhileBaseVisitor<Object> {
    @Override
    public Object visitProg(WhileParser.ProgContext ctx) {
        List<Statement> statements = new ArrayList<>();
        for (WhileParser.StatementContext sc : ctx.stmts) {
            statements.add((Statement) this.visit(sc));
        }
        List<Funtzioa> funtzioak = new ArrayList<>();
        funtzioak.add(new Funtzioa(lortuContext(ctx), statements, "main"));
        return new es.ehu.ikasle.ehernandez035.makroprograma.SZA.Programa(lortuContext(ctx), funtzioak);
    }

    @Override
    public Object visitIf(WhileParser.IfContext ctx) {
        List<Statement> stmts = new ArrayList<>();
        for (WhileParser.StatementContext sctx : ctx.stmts) {
            stmts.add((Statement) this.visit(sctx));
        }
        return new IfStmt(lortuContext(ctx),
                new CarExpr(lortuContext(ctx), irakurriLetra(ctx.bald.getText()), new AldagaiaExpr(lortuContext(ctx), ctx.ald.getText())),
                stmts,
                new ArrayList<When>(),
                new ArrayList<Statement>());
    }

    @Override
    public Object visitWhile(WhileParser.WhileContext ctx) {
        List<Adierazpena> params = new ArrayList<>();
        params.add(new AldagaiaExpr(lortuTokenetik(ctx.ald), ctx.ald.getText()));
        List<Statement> stmts = new ArrayList<>();
        for (WhileParser.StatementContext sctx : ctx.stmts) {
            stmts.add((Statement) this.visit(sctx));
        }
        return new WhileStmt(lortuContext(ctx), stmts, new FuntzioExpr(lortuContext(ctx), "nonem", params));
    }


    @Override
    public Object visitEsleipen(WhileParser.EsleipenContext ctx) {
        Adierazpena ad = (Adierazpena) this.visit(ctx.ad);
        return new EsleipenStmt(lortuContext(ctx), ctx.ald.getText(), ad);
    }

    @Override
    public Object visitHutsa(WhileParser.HutsaContext ctx) {
        return HutsaExpr.INSTANCE;
    }

    @Override
    public Object visitCdr(WhileParser.CdrContext ctx) {
        List<Adierazpena> params = new ArrayList<>();
        params.add(new AldagaiaExpr(lortuTokenetik(ctx.ald), ctx.ald.getText()));
        return new FuntzioExpr(lortuContext(ctx), "cdr", params);
    }

    @Override
    public Object visitCons(WhileParser.ConsContext ctx) {
        Adierazpena adierazpena = new AldagaiaExpr(lortuTokenetik(ctx.ald), ctx.ald.getText());
        return new ConsExpr(lortuContext(ctx), adierazpena, irakurriLetra(ctx.cons.getText()));
    }

    private static char irakurriLetra(String testua) {
        return testua.charAt(testua.length() - 1);
    }

    private static Posizioa lortuTokenetik(Token t) {
        return new Posizioa(t.getLine(), t.getLine(), t.getCharPositionInLine(), t.getCharPositionInLine() + t.getText().length());
    }

    private static Posizioa lortuContext(ParserRuleContext c) {
        Posizioa has = lortuTokenetik(c.start);
        Posizioa buk = lortuTokenetik(c.stop);
        return new Posizioa(has.hasLerro, buk.bukLerro, has.hasZut, buk.bukZut);
    }
}
