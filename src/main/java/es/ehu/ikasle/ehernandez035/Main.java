package es.ehu.ikasle.ehernandez035;

import es.ehu.ikasle.ehernandez035.gramatika.WhileLexer;
import es.ehu.ikasle.ehernandez035.gramatika.WhileParser;
import es.ehu.ikasle.ehernandez035.programa.Programa;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStream;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        CharStream input = CharStreams.fromFileName(args[0]);
        WhileLexer lexer = new WhileLexer(input);
        TokenStream tokens = new CommonTokenStream(lexer);
        WhileParser parser = new WhileParser(tokens);
        WhileParser.ProgContext prog = parser.prog();
        MyWhileVisitor visitor = new MyWhileVisitor();
        Programa programa = (Programa) visitor.visit(prog);
        List<String> params = new ArrayList<>();

        params.add("");
        params.add("abbabbcab");
        String result = programa.execute(params);
        System.out.println(result);
    }

}
