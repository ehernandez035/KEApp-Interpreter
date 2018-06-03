package es.ehu.ikasle.ehernandez035.whileprograma;

import java.util.List;

public class ConsExpr extends Adierazpena {
    private char letra;
    private int aldagaia;

    public ConsExpr(char letra, int aldagaia) {
        this.letra = letra;
        this.aldagaia = aldagaia;
    }

    @Override
    public String getValue(List<String> aldagaiak) {
        if (aldagaiak.size() <= aldagaia) {
            return "" + letra;
        }
        return letra + aldagaiak.get(aldagaia);
    }
}
