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
        if (aldagaiak.size() <= aldagaia) {
            for (int i = aldagaiak.size()-1; i<aldagaia; i++) {
                aldagaiak.add("");
            }
        }
        aldagaiak.set(aldagaia, balio);
    }
}
