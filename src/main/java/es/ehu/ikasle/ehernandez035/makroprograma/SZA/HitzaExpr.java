package es.ehu.ikasle.ehernandez035.makroprograma.SZA;

import java.util.List;

public class HitzaExpr extends Adierazpena {
    String hitza;

    public HitzaExpr(String hitza) {
        this.hitza = hitza;

    }

    @Override
    public String getValue(SinboloTaula st) {
        return this.hitza;
    }

    @Override
    public boolean verifyAlf(SinboloTaula st, List<String> erroreak) {
        for (char c : hitza.toCharArray()) {
            if (!st.getAlfabetoa().contains(c)) return false;
        }
        return true;
    }
}
