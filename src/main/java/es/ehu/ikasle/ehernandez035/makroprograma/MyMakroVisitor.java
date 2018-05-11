package es.ehu.ikasle.ehernandez035.makroprograma;

import es.ehu.ikasle.ehernandez035.gramatika.makro.MakroprogramaBaseVisitor;
import es.ehu.ikasle.ehernandez035.gramatika.makro.MakroprogramaParser;
import es.ehu.ikasle.ehernandez035.makroprograma.SZA.*;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;

import java.util.ArrayList;
import java.util.List;

public class MyMakroVisitor extends MakroprogramaBaseVisitor<Object> {

    @Override
    public Object visitProg(MakroprogramaParser.ProgContext ctx) {
        List<Funtzioa> funtzioak = new ArrayList<>();
        for (MakroprogramaParser.FuncContext fc : ctx.funtz) {
            funtzioak.add((Funtzioa) this.visit(fc));
        }
        return new Programa(lortuContext(ctx), funtzioak);
    }

    @Override
    public Object visitFunc(MakroprogramaParser.FuncContext ctx) {
        String izena = ctx.ald.getText();
        List<Statement> statements = new ArrayList<>();
        for (MakroprogramaParser.StatementContext sc : ctx.stmts) {
            statements.add((Statement) this.visit(sc));
        }
        return new Funtzioa(lortuContext(ctx), statements, izena);
    }

    @Override
    public Object visitIf(MakroprogramaParser.IfContext ctx) {
        Adierazpena baldintza = (Adierazpena) this.visit(ctx.bald);
        List<Statement> statementsTrue = new ArrayList<>();
        List<When> statementsElsif = new ArrayList<>();
        List<Statement> statementsFalse = new ArrayList<>();
        for (MakroprogramaParser.StatementContext sc : ctx.stmts) {
            statementsTrue.add((Statement) this.visit(sc));
        }
        for (MakroprogramaParser.ElsifContext sc : ctx.elif) {
            statementsElsif.add((When) this.visit(sc));
        }
        for (MakroprogramaParser.StatementContext sc : ctx.falseStmts) {
            statementsFalse.add((Statement) this.visit(sc));
        }
        return new IfStmt(lortuContext(ctx), baldintza, statementsTrue, statementsElsif, statementsFalse);
    }

    @Override
    public Object visitWhile(MakroprogramaParser.WhileContext ctx) {
        Adierazpena baldintza = (Adierazpena) this.visit(ctx.bald);
        List<Statement> statements = new ArrayList<>();
        for (MakroprogramaParser.StatementContext sc : ctx.stmts) {
            statements.add((Statement) this.visit(sc));
        }
        return new WhileStmt(lortuContext(ctx), statements, baldintza);
    }


    @Override
    public Object visitEsleipen(MakroprogramaParser.EsleipenContext ctx) {
        String izena = ctx.ald.getText();
        Adierazpena adierazpena = (Adierazpena) this.visit(ctx.ad);
        return new EsleipenStmt(lortuContext(ctx), izena, adierazpena);
    }

    @Override
    public Object visitHitza(MakroprogramaParser.HitzaContext ctx) {
        String guztia = ctx.hitz.getText();
        return new HitzaExpr(lortuContext(ctx), guztia.substring(1, guztia.length() - 1));
    }

    @Override
    public Object visitAldagaia(MakroprogramaParser.AldagaiaContext ctx) {
        return new AldagaiaExpr(lortuContext(ctx), ctx.ald.getText());
    }

    @Override
    public Object visitHutsa(MakroprogramaParser.HutsaContext ctx) {
        return HutsaExpr.INSTANCE;
    }

    @Override
    public Object visitCar(MakroprogramaParser.CarContext ctx) {
        Adierazpena adierazpena = (Adierazpena) this.visit(ctx.ad);
        return new CarExpr(lortuContext(ctx), irakurriLetra(ctx.car.getText()), adierazpena);
    }

    @Override
    public Object visitFuntzioDeia(MakroprogramaParser.FuntzioDeiaContext ctx) {
        String izena = ctx.ald.getText();
        List<Adierazpena> parametroLista = new ArrayList<>();
        for (MakroprogramaParser.AdierazpenaContext ac : ctx.arg) {
            parametroLista.add((Adierazpena) this.visit(ac));
        }
        return new FuntzioExpr(lortuContext(ctx), izena, parametroLista);
    }

    @Override
    public Object visitAlderaketak(MakroprogramaParser.AlderaketakContext ctx) {
        Adierazpena ad1 = (Adierazpena) this.visit(ctx.ad);
        Adierazpena ad2 = (Adierazpena) this.visit(ctx.ad);
        String eragText = ctx.erag.getText();
        AlderaketakExpr.Alderaketa erag = null;
        switch (eragText) {
            case "=":
                erag = AlderaketakExpr.Alderaketa.EQ;
                break;
            case "!=":
                erag = AlderaketakExpr.Alderaketa.NE;
                break;
            case "<=":
                erag = AlderaketakExpr.Alderaketa.LE;
                break;
            case ">=":
                erag = AlderaketakExpr.Alderaketa.GE;
                break;
            case "<":
                erag = AlderaketakExpr.Alderaketa.LT;
                break;
            case ">":
                erag = AlderaketakExpr.Alderaketa.GT;
                break;
            case "and":
                erag = AlderaketakExpr.Alderaketa.AND;
                break;
            case "or":
                erag = AlderaketakExpr.Alderaketa.OR;
                break;
        }
        return new AlderaketakExpr(lortuContext(ctx), ad1, ad2, erag);
    }

    @Override
    public Object visitCons(MakroprogramaParser.ConsContext ctx) {
        Adierazpena adierazpena = (Adierazpena) this.visit(ctx.ad);
        return new ConsExpr(lortuContext(ctx), adierazpena, irakurriLetra(ctx.cons.getText()));
    }

    @Override
    public Object visitNotAdierazpena(MakroprogramaParser.NotAdierazpenaContext ctx) {
        return new NotExpr(lortuContext(ctx), (Adierazpena) this.visit(ctx.ad));
    }

    @Override
    public Object visitDeskod(MakroprogramaParser.DeskodContext ctx) {
        String deskod = ctx.deskod.getText();
        String[] split = deskod.split("_");
        return new DeskodExpr(lortuContext(ctx), Integer.parseInt(split[1]), Integer.parseInt(split[2]), (Adierazpena) this.visit(ctx.ad));
    }

    private static char irakurriLetra(String testua) {
        return testua.charAt(testua.length() - 1);
    }

    private static Posizioa lortuTokenetik(Token t){
        return  new Posizioa(t.getLine(), t.getLine(), t.getCharPositionInLine(), t.getCharPositionInLine()+t.getText().length());
    }

    private static Posizioa lortuContext(ParserRuleContext c){
        Posizioa has = lortuTokenetik(c.start);
        Posizioa buk = lortuTokenetik(c.stop);
        return new Posizioa(has.hasLerro, buk.bukLerro, has.hasZut, buk.bukZut);
    }

    @Override
    public Object visitFor(MakroprogramaParser.ForContext ctx) {
        Adierazpena has = (Adierazpena) this.visit(ctx.has);
        Adierazpena buk = (Adierazpena) this.visit(ctx.buk);
        String indize = ctx.ind.getText();
        List<Statement> stmts = new ArrayList<>();
        for (MakroprogramaParser.StatementContext stmt : ctx.stmts) {
            stmts.add((Statement) this.visit(stmt));
        }

        return new ForStmt(lortuContext(ctx), indize, has, buk, stmts);
    }

    @Override
    public Object visitForZenbaki(MakroprogramaParser.ForZenbakiContext ctx) {
        int has =  Integer.parseInt(ctx.has.getText());
        int buk =  Integer.parseInt(ctx.buk.getText());
        String indize = ctx.ind.getText();
        List<Statement> stmts = new ArrayList<>();
        for (MakroprogramaParser.StatementContext stmt : ctx.stmts) {
            stmts.add((Statement) this.visit(stmt));
        }

        return new ForZenbakiStmt(lortuContext(ctx), indize, has, buk, stmts);
    }

    @Override
    public Object visitCaseMakroa(MakroprogramaParser.CaseMakroaContext ctx) {
        Adierazpena adierazpena = (Adierazpena) this.visit(ctx.ad);
        List<When> whens = new ArrayList<>();
        for (MakroprogramaParser.WhenContext stmt : ctx.w) {
            whens.add((When) this.visit(stmt));
        }
        List<Statement> otherStmts = new ArrayList<>();
        for (MakroprogramaParser.StatementContext stmt : ctx.otherStmts) {
            otherStmts.add((Statement) this.visit(stmt));
        }
        return new CaseStmt(lortuContext(ctx), adierazpena, whens, otherStmts);
    }

    @Override
    public Object visitElsif(MakroprogramaParser.ElsifContext ctx) {
        Adierazpena adierazpena = (Adierazpena) this.visit(ctx.bald);
        List<Statement> stmts = new ArrayList<>();
        for (MakroprogramaParser.StatementContext stmt : ctx.stmts) {
            stmts.add((Statement) this.visit(stmt));
        }
        return new When(adierazpena, stmts);
    }

    @Override
    public Object visitWhen(MakroprogramaParser.WhenContext ctx) {
        Adierazpena adierazpena = (Adierazpena) this.visit(ctx.ad);
        List<Statement> stmts = new ArrayList<>();
        for (MakroprogramaParser.StatementContext stmt : ctx.stmts) {
            stmts.add((Statement) this.visit(stmt));
        }
        return new When(adierazpena, stmts);
    }
}