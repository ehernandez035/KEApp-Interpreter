//package es.ehu.ikasle.ehernandez035.whileprograma;
//
//import es.ehu.ikasle.ehernandez035.makroprograma.SZA.Adierazpena;
//import es.ehu.ikasle.ehernandez035.makroprograma.SZA.Errorea;
//import es.ehu.ikasle.ehernandez035.makroprograma.SZA.Posizioa;
//
//import java.util.List;
//
//public class CdrExpr extends Adierazpena {
//
//    private Adierazpena adierazpena;
//    private char letra;
//
//    public CdrExpr(Posizioa p, char letra, Adierazpena adierazpena) {
//        super(p);
//        this.adierazpena = adierazpena;
//        this.letra = letra;
//    }
//
//    @Override
//    public String getValue(SinboloTaula st) {
//        if (adierazpena.getValue(st).equals("")) return "";
//        String balio = adierazpena.getValue(st);
//        if (balio.length() == 0) return "";
//        return balio.substring(1);
//    }
//
//    @Override
//    public boolean verify(SinboloTaula st, List<Errorea> erroreak){
//        return adierazpena.verify(st, erroreak);
//    }
//
//    @Override
//    public boolean verifyAlf(SinboloTaula st, List<Errorea> erroreak){
//        return adierazpena.verifyAlf(st, erroreak);
//    }
//}
