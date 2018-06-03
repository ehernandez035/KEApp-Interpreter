package es.ehu.ikasle.ehernandez035.whileprograma;

import java.util.List;

public class CdrExpr extends Adierazpena {
    int aldagaia;

    public CdrExpr(int aldagaia) {
        this.aldagaia = aldagaia;
    }

    @Override
    public String getValue(List<String> aldagaiak) {
        if (aldagaiak.size() <= aldagaia) return "";
        String balio = aldagaiak.get(aldagaia);
        if (balio.length() == 0) return "";
        return balio.substring(1);
    }
}
