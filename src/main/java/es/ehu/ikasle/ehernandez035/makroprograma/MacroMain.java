package es.ehu.ikasle.ehernandez035.makroprograma;

import es.ehu.ikasle.ehernandez035.gramatika.makro.MakroprogramaLexer;
import es.ehu.ikasle.ehernandez035.gramatika.makro.MakroprogramaParser;
import es.ehu.ikasle.ehernandez035.makroprograma.SZA.Liburutegia;
import es.ehu.ikasle.ehernandez035.makroprograma.SZA.Programa;
import es.ehu.ikasle.ehernandez035.makroprograma.SZA.SinboloTaula;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStream;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MacroMain {

    public static void main(String[] args) throws IOException {
        CharStream input = CharStreams.fromFileName(args[0]);
        MakroprogramaLexer lexer = new MakroprogramaLexer(input);
        TokenStream tokens = new CommonTokenStream(lexer);
        MakroprogramaParser parser = new MakroprogramaParser(tokens);
        MakroprogramaParser.ProgContext prog = parser.prog();
        MyMakroVisitor visitor = new MyMakroVisitor();
        Programa programa = (Programa) visitor.visitProg(prog);

        List<Character> alfabetoa = new ArrayList<>();
        alfabetoa.add('a');
        alfabetoa.add('b');
//        alfabetoa.add('c');
//        alfabetoa.add('d');
        SinboloTaula st = new SinboloTaula(alfabetoa);
        Liburutegia.gehituFuntzioak(st);

        String result = programa.execute(st);
        System.out.println(result);
    }
}
