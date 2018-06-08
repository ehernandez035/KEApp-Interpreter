//package es.ehu.ikasle.ehernandez035.whileprograma;
//
//import es.ehu.ikasle.ehernandez035.makroprograma.SZA.Errorea;
//import es.ehu.ikasle.ehernandez035.makroprograma.SZA.Posizioa;
//import es.ehu.ikasle.ehernandez035.makroprograma.SZA.Statement;
//
//import java.util.List;
//
//public class Programa {
//    List<Statement> statements;
//    private Posizioa p;
//
//    public Programa(Posizioa p, List<Statement> statements) {
//        this.p = p;
//        this.statements = statements;
//    }

//    public String execute(List<String> aldagaiak) {
//        for(Statement s: statements){
//            if (Thread.currentThread().isInterrupted()) return aldagaiak.get(0);
//            s.execute(aldagaiak);
//        }
//        return aldagaiak.get(0);
//    }
//
//    public boolean verify(SinboloTaula st, List<Errorea> erroreak){
//
//    }
//
//    public boolean verifyAlf(SinboloTaula st, List<Errorea> erroreak){
//
//    }
//}
