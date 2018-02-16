package es.ehu.ikasle.ehernandez035.makroprograma.SZA;

import java.util.List;

public class HitzaExpr extends Adierazpena {
    private String hitza;

    public HitzaExpr(Posizioa p, String hitza) {
        super(p);
        this.hitza = hitza;

    }

    @Override
    public String getValue(SinboloTaula st) {
        return this.hitza;
    }

    @Override
    public boolean verifyAlf(SinboloTaula st, List<String> erroreak) {
        boolean zuzena = true;
        for (char c : hitza.toCharArray()) {
            if (!st.getAlfabetoa().contains(c)){
                erroreak.add("Alfabeto barneko karaktereak erabili (" + c + ")");
                zuzena=false;
                break;
            }
        }
        return zuzena;
    }
}
