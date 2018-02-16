package es.ehu.ikasle.ehernandez035.makroprograma.SZA;


import java.util.List;

public class Programa {
    private List<Funtzioa> functions;
    private Posizioa p;

    public Programa(Posizioa p, List<Funtzioa> functions) {
        this.p = p;
        this.functions = functions;
    }

    public String execute(SinboloTaula st) {
        for (Funtzioa f : functions) {
            st.gordeFuntzioa(f);
        }
        return st.lortuFuntzioa("main").execute(st);
    }

    public boolean verifyAlf(SinboloTaula st, List<String> erroreak) {
        boolean zuzena = true;
        if (st.getAlfabetoa().stream().distinct().count() != st.getAlfabetoa().size()) {
            erroreak.add("Alfabetoan ezin dira karaktere errepikaturik sartu");
            zuzena = false;
        }
        for (int i = 0; i < st.getAlfabetoa().size() - 1; i++) {
            // TODO: Warning, not error
            if (st.getAlfabetoa().get(i) > st.getAlfabetoa().get(i + 1)) zuzena = false;
        }

        for (Funtzioa f : functions) {
            if (!f.verifyAlf(st, erroreak)) zuzena = false;
        }
        return zuzena;
    }

    public boolean verify(SinboloTaula st, List<String> erroreak) {
        boolean zuzena = true;
        for (Funtzioa f : functions) {
            if (st.lortuFuntzioa(f.getIzena()) != null) {
                erroreak.add(f.getIzena() + "izeneko funtziorik ez da existitzen");
                zuzena = false;
            }
            st.gordeFuntzioa(f);
        }
        if (st.lortuFuntzioa("main") == null) {
            erroreak.add("main izeneko funtzioa existitu behar da");
            zuzena = false;
        }
        for (Funtzioa f : functions) {
            if (!f.verify(st, erroreak)) zuzena = false;
        }
        return zuzena;
    }
}
