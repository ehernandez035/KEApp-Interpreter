package es.ehu.ikasle.ehernandez035.programa;

import java.util.List;

public class CdrExpr extends Adierazpena {
    int aldagaia;

    public CdrExpr(int aldagaia) {
        this.aldagaia = aldagaia;
    }

    @Override
    public String getValue(List<String> aldagaiak) {
        return aldagaiak.get(aldagaia).substring(1);
    }
}
