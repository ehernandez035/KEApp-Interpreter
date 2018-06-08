package es.ehu.ikasle.ehernandez035.whileprograma;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SinboloTaula {
    private Map<String, String> aldagaiak = new HashMap<>();
    private List<Character> alfabetoa;

    public SinboloTaula(SinboloTaula bestea) {
        this.alfabetoa = bestea.alfabetoa;
    }

    public SinboloTaula(List<Character> alfabetoa) {
        this.alfabetoa = alfabetoa;
    }

    public void gordeAldagaia(String izena, String balioa) {
        aldagaiak.put(izena, balioa);
    }

    public String lortuBalioa(String izena) {
        if (!aldagaiak.containsKey(izena)) return "";
        else return aldagaiak.get(izena);
    }

    public boolean baduBalio(String izena) {
        return aldagaiak.containsKey(izena);
    }

    public List<Character> getAlfabetoa() {
        return alfabetoa;
    }
}

