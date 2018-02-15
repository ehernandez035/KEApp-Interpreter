package es.ehu.ikasle.ehernandez035.makroprograma.SZA;


import java.util.List;

public class Programa {
    private List<Funtzioa> functions;

    public Programa(List<Funtzioa> functions) {
        this.functions = functions;
    }

    public String execute(SinboloTaula st) {
        for (Funtzioa f : functions) {
            st.gordeFuntzioa(f);
        }
        return st.lortuFuntzioa("main").execute(st);
    }

    public boolean verifyAlf(SinboloTaula st, List<String> erroreak) {
        if (st.getAlfabetoa().stream().distinct().count() != st.getAlfabetoa().size()) {
            return false;
        }
        for (int i = 0; i < st.getAlfabetoa().size() - 1; i++) {
            // TODO: Warning, not error
            if (st.getAlfabetoa().get(i) > st.getAlfabetoa().get(i + 1)) return false;
        }

        for (Funtzioa f : functions) {
            if (!f.verifyAlf(st, erroreak)) return false;
        }
        return true;
    }

    public boolean verify(SinboloTaula st, List<String> erroreak) {
        for (Funtzioa f : functions) {
            if (st.lortuFuntzioa(f.getIzena()) != null) {
                return false;
            }
            st.gordeFuntzioa(f);
        }
        if (st.lortuFuntzioa("main") == null) {
            return false;
        }
        for (Funtzioa f : functions) {
            if (!f.verify(st, erroreak)) return false;
        }
        return true;
    }
}
