package es.ehu.ikasle.ehernandez035.programa;

import java.util.List;

public class ConsExpr extends Adierazpena{
    char letra;
    int aldagaia;

    public ConsExpr(char letra, int aldagaia) {
        this.letra = letra;
        this.aldagaia = aldagaia;
    }

    @Override
    public String getValue(List<String> aldagaiak) {
        return letra+aldagaiak.get(aldagaia);
    }
}
