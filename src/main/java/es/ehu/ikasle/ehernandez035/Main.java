package es.ehu.ikasle.ehernandez035;

import es.ehu.ikasle.ehernandez035.gramatika.WhileLexer;
import es.ehu.ikasle.ehernandez035.gramatika.WhileParser;
import es.ehu.ikasle.ehernandez035.makroprograma.Utils;
import es.ehu.ikasle.ehernandez035.whileprograma.MyWhileVisitor;
import es.ehu.ikasle.ehernandez035.whileprograma.Programa;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStream;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static es.ehu.ikasle.ehernandez035.makroprograma.Utils.*;

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

        params.add("bab");
        params.add("abba");
        String result = programa.execute(params);
        System.out.println(result);

/*        List<Character> alf = new ArrayList<>();
        alf.add('a');
        alf.add('b');
        alf.add('c');
        ArrayList<String> elem = new ArrayList<>();
        elem.add(zenbakiaHitzera(alf, 2));
        elem.add("aa");
        elem.add("ba");
        elem.add("b");
        String bektore = kod(alf, elem);
        for(String s: hitzetikBektorera(alf,bektore)){
            System.out.println(s);
        }*/
//
//
//        String nirepila = pilaratu(alf, "a", pilaratu(alf, "b", pilaratu(alf, "c", pilaratu(alf, "", ""))));
//
//        List<String> pila = Utils.hitzetikPilera(alf, nirepila);
//        for (String s : pila) {
//            System.out.println("'" + s + "'");
//        }

    }

}
