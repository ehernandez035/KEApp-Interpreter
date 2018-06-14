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

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {

    private static final String PROGRAMA = "X0:= hutsa; X0:= cons_a(X0); while nonem?(X0) loop X1:=cdr(X1); end loop;";

    public static void main(String[] args) {
        Thread newThread = new Thread(new Runnable() {
            @Override
            public void run() {
                runPrograma();
            }
        });
        newThread.start();

        System.out.println("Starting...");
        Scanner s = new Scanner(System.in);
        s.next();
        System.out.println("Interrupting...");
        newThread.interrupt();
        System.out.println("Joining...");
        try {
            newThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Exiting...");

    }

    public static void runPrograma() {
        CharStream input = CharStreams.fromString(PROGRAMA);
        WhileLexer lexer = new WhileLexer(input);

        TokenStream tokens = new CommonTokenStream(lexer);
        WhileParser parser = new WhileParser(tokens);

        WhileParser.ProgContext prog = parser.prog();

        MyWhileVisitor visitor = new MyWhileVisitor();
        Programa programa = (Programa) visitor.visitProg(prog);

        List<Character> alf = new ArrayList<>();
        alf.add('a');
        alf.add('b');
        alf.add('c');

        SinboloTaula st = new SinboloTaula(alf);
        Liburutegia.gehituFuntzioak(st);
        System.out.println(programa.execute(st));
    }
}
