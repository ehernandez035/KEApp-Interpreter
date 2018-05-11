package es.ehu.ikasle.ehernandez035.makroprograma.SZA;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SinboloTaula {

    private Map<String, String> aldagaiak = new HashMap<>();
    private Map<String, IFuntzioa> funtzioak = new HashMap<>();
    private List<Character> alfabetoa;

    public SinboloTaula(SinboloTaula bestea) {
        this.alfabetoa = bestea.alfabetoa;
        this.funtzioak = bestea.funtzioak;
    }

    public SinboloTaula(List<Character> alfabetoa) {
        this.alfabetoa = alfabetoa;
    }

    public void gordeAldagaia(String izena, String balioa) {
        aldagaiak.put(izena, balioa);
    }

    public void gordeFuntzioa(IFuntzioa funtzioa) {
        funtzioak.put(funtzioa.getIzena(), funtzioa);
    }

    public String lortuBalioa(String izena) {
        if (!aldagaiak.containsKey(izena)) return "";
        else return aldagaiak.get(izena);
    }

    public boolean baduBalio(String izena) {
        return aldagaiak.containsKey(izena);
    }

    public IFuntzioa lortuFuntzioa(String izena) {
        return funtzioak.get(izena);
    }

    public List<Character> getAlfabetoa() {
        return alfabetoa;
    }
}
