package es.ehu.ikasle.ehernandez035.makroprograma;

import es.ehu.ikasle.ehernandez035.gramatika.makro.MakroprogramaBaseVisitor;
import es.ehu.ikasle.ehernandez035.gramatika.makro.MakroprogramaParser;
import es.ehu.ikasle.ehernandez035.makroprograma.SZA.*;

import java.util.ArrayList;
import java.util.List;

public class MyMakroVisitor extends MakroprogramaBaseVisitor<Object> {

    @Override
    public Object visitProg(MakroprogramaParser.ProgContext ctx) {
        List<Funtzioa> funtzioak = new ArrayList<>();
        for (MakroprogramaParser.FuncContext fc : ctx.funtz) {
            funtzioak.add((Funtzioa) this.visit(fc));
        }
        return new Programa(funtzioak);
    }

    @Override
    public Object visitFunc(MakroprogramaParser.FuncContext ctx) {
        String izena = ctx.ald.getText();
        List<Statement> statements = new ArrayList<>();
        for (MakroprogramaParser.StatementContext sc : ctx.stmts) {
            statements.add((Statement) this.visit(sc));
        }
        return new Funtzioa(statements, izena);
    }

    @Override
    public Object visitIf(MakroprogramaParser.IfContext ctx) {
        Adierazpena baldintza = (Adierazpena) this.visit(ctx.bald);
        List<Statement> statementsTrue = new ArrayList<>();
        List<Statement> statementsFalse = new ArrayList<>();
        for (MakroprogramaParser.StatementContext sc : ctx.stmts) {
            statementsTrue.add((Statement) this.visit(sc));
        }
        for (MakroprogramaParser.StatementContext sc : ctx.falseStmts) {
            statementsFalse.add((Statement) this.visit(sc));
        }
        return new IfStmt(baldintza, statementsTrue, statementsFalse);
    }

    @Override
    public Object visitWhile(MakroprogramaParser.WhileContext ctx) {
        Adierazpena baldintza = (Adierazpena) this.visit(ctx.bald);
        List<Statement> statements = new ArrayList<>();
        for (MakroprogramaParser.StatementContext sc : ctx.stmts) {
            statements.add((Statement) this.visit(sc));
        }
        return new WhileStmt(statements, baldintza);
    }


    @Override
    public Object visitEsleipen(MakroprogramaParser.EsleipenContext ctx) {
        String izena = ctx.ald.getText();
        Adierazpena adierazpena = (Adierazpena) this.visit(ctx.ad);
        return new EsleipenStmt(izena, adierazpena);
    }

    @Override
    public Object visitHitza(MakroprogramaParser.HitzaContext ctx) {
        String guztia = ctx.hitz.getText();
        return new HitzaExpr(guztia.substring(1, guztia.length() - 1));
    }

    @Override
    public Object visitAldagaia(MakroprogramaParser.AldagaiaContext ctx) {
        return new AldagaiaExpr(ctx.ald.getText());
    }

    @Override
    public Object visitHutsa(MakroprogramaParser.HutsaContext ctx) {
        return HutsaExpr.INSTANCE;
    }

    @Override
    public Object visitCar(MakroprogramaParser.CarContext ctx) {
        Adierazpena adierazpena = (Adierazpena) this.visit(ctx.ad);
        return new CarExpr(irakurriLetra(ctx.car.getText()), adierazpena);
    }

    @Override
    public Object visitFuntzioDeia(MakroprogramaParser.FuntzioDeiaContext ctx) {
        String izena = ctx.ald.getText();
        List<Adierazpena> parametroLista = new ArrayList<>();
        for (MakroprogramaParser.AdierazpenaContext ac : ctx.arg) {
            parametroLista.add((Adierazpena) this.visit(ac));
        }
        return new FuntzioExpr(izena, parametroLista);
    }

    @Override
    public Object visitAlderaketak(MakroprogramaParser.AlderaketakContext ctx) {
        Adierazpena ad1 = (Adierazpena) this.visit(ctx.ad);
        Adierazpena ad2 = (Adierazpena) this.visit(ctx.ad);
        String eragText = ctx.erag.getText();
        AlderaketakExpr.Alderaketa erag = null;
        switch (eragText) {
            case "==":
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
        return new AlderaketakExpr(ad1, ad2, erag);
    }

    @Override
    public Object visitCons(MakroprogramaParser.ConsContext ctx) {
        Adierazpena adierazpena = (Adierazpena) this.visit(ctx.ad);
        // TODO Gorde posizioak
        // Posizioa p = lortuTokenetik(ctx.cons)
        return new ConsExpr(/*p, */adierazpena, irakurriLetra(ctx.cons.getText()));
    }

    @Override
    public Object visitNotAdierazpena(MakroprogramaParser.NotAdierazpenaContext ctx) {
        return new NotExpr((Adierazpena) this.visit(ctx.ad));
    }

    @Override
    public Object visitDeskod(MakroprogramaParser.DeskodContext ctx) {
        String deskod = ctx.deskod.getText();
        String[] split = deskod.split("_");
        return new DeskodExpr(Integer.parseInt(split[1]), Integer.parseInt(split[2]), (Adierazpena) this.visit(ctx.ad));
    }

    private static char irakurriLetra(String testua) {
        return testua.charAt(testua.length() - 1);
    }
}