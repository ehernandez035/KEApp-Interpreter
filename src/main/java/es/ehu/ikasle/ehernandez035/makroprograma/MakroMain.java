package es.ehu.ikasle.ehernandez035.makroprograma;

import es.ehu.ikasle.ehernandez035.gramatika.makro.MakroprogramaLexer;
import es.ehu.ikasle.ehernandez035.gramatika.makro.MakroprogramaParser;
import es.ehu.ikasle.ehernandez035.makroprograma.SZA.Errorea;
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

public class MakroMain {

    public static void main(String[] args) throws IOException {
        CharStream input = CharStreams.fromFileName(args[0]);
        MakroprogramaLexer lexer = new MakroprogramaLexer(input);
        TokenStream tokens = new CommonTokenStream(lexer);
        MakroprogramaParser parser = new MakroprogramaParser(tokens);
        MakroprogramaParser.ProgContext prog = parser.prog();

        if (parser.getNumberOfSyntaxErrors() > 0) {
            return;
        }

        MyMakroVisitor visitor = new MyMakroVisitor();
        Programa programa = (Programa) visitor.visitProg(prog);

        if (parser.getNumberOfSyntaxErrors() > 0) {
            return;
        }

        List<Character> alfabetoa = new ArrayList<>();
        List<Errorea> erroreak = new ArrayList<>();
        SinboloTaula st = new SinboloTaula(alfabetoa);
        Liburutegia.gehituFuntzioak(st);
        programa.verify(st, erroreak);

        alfabetoa.add('a');
        alfabetoa.add('b');
//        alfabetoa.add('c');
//        alfabetoa.add('d');

        st.gordeAldagaia("X1", "ba");
        programa.verifyAlf(st, erroreak);

        if (!erroreak.isEmpty()) {
            for (Errorea e : erroreak) {
                System.out.println("Error: " + e.mezua);
            }
        } else {
            String result = programa.execute(st);

            ArrayList<String> bektoreElem = Utils.hitzetikBektorera(alfabetoa, result);
            String bektore = join(bektoreElem, ", ", "hutsa");

            ArrayList<String> pilaElem = Utils.hitzetikPilera(alfabetoa, result);
            String pila = join(pilaElem, ", ", "hutsa");

            System.out.println("Hitza:   " + result);
            System.out.println("Zenbaki: " + Utils.hitzakZenbakira(alfabetoa, result).toString());
            System.out.println("Bektore: (" + bektore + ")");
            System.out.println("Pila:    <" + pila + "]");
        }

    }

    private static String join(List<String> list, String separator, String toReplaceIfEmpty) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size() - 1; i++) {
            String elem = list.get(i);
            if (toReplaceIfEmpty != null && "".equals(elem)) elem = toReplaceIfEmpty;
            sb.append(elem).append(separator);
        }
        if (!list.isEmpty()) {
            String elem = list.get(list.size() - 1);
            if (toReplaceIfEmpty != null && "".equals(elem)) elem = toReplaceIfEmpty;
            sb.append(elem);
        }
        return sb.toString();
    }
}
