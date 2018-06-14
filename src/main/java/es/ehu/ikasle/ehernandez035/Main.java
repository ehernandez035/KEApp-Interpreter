package es.ehu.ikasle.ehernandez035;

import es.ehu.ikasle.ehernandez035.gramatika.WhileLexer;
import es.ehu.ikasle.ehernandez035.gramatika.WhileParser;
import es.ehu.ikasle.ehernandez035.makroprograma.SZA.Liburutegia;
import es.ehu.ikasle.ehernandez035.makroprograma.SZA.Programa;
import es.ehu.ikasle.ehernandez035.makroprograma.SZA.SinboloTaula;
import es.ehu.ikasle.ehernandez035.whileprograma.MyWhileVisitor;
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

        if (parser.getNumberOfSyntaxErrors() > 0) return;

        WhileParser.ProgContext prog = parser.prog();
        MyWhileVisitor visitor = new MyWhileVisitor();
        Programa programa = (Programa) visitor.visit(prog);

        if (parser.getNumberOfSyntaxErrors() > 0) return;


        List<Character> alf = new ArrayList<>();
        alf.add('a');
        alf.add('b');
        alf.add('c');

        SinboloTaula st = new SinboloTaula(alf);

        Liburutegia.gehituFuntzioak(st);

        st.gordeAldagaia("X1", "bab");
        st.gordeAldagaia("X2", "aba");
        String result = programa.execute(st);
        System.out.println(result);

    }

}
