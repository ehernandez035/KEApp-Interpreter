package es.ehu.ikasle.ehernandez035.makroprograma.SZA;


import java.util.List;

public class Programa {
    private List<Funtzioa> functions;

    public Programa(List<Funtzioa> functions) {
        this.functions = functions;
    }

    public String execute(SinboloTaula st) {
        for(Funtzioa f: functions) {
            st.gordeFuntzioa(f);
        }
        return st.lortuFuntzioa("main").execute(st);
    }
}
