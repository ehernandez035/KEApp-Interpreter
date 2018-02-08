package es.ehu.ikasle.ehernandez035.whileprograma;

import java.util.List;

public class EsleipenStmt extends Statement {
    int aldagaia;
    Adierazpena ad;

    public EsleipenStmt(int aldagaia, Adierazpena ad) {
        this.aldagaia = aldagaia;
        this.ad = ad;
    }

    @Override
    public void execute(List<String> aldagaiak) {
        String balio = this.ad.getValue(aldagaiak);
        aldagaiak.set(aldagaia, balio);
    }
}
