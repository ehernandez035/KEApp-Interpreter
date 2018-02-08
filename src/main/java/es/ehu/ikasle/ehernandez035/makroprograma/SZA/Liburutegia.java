package es.ehu.ikasle.ehernandez035.makroprograma.SZA;

import es.ehu.ikasle.ehernandez035.makroprograma.Utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Liburutegia {

    public static void gehituFuntzioak(SinboloTaula st) {

        for (Method m : Liburutegia.class.getDeclaredMethods()) {
            if (m.getParameterCount() != 1 || m.getParameterTypes()[0] != SinboloTaula.class || m.getReturnType() != String.class) {
                continue;
            }
            st.gordeFuntzioa(new IFuntzioa() {
                @Override
                public String execute(SinboloTaula st) {
                    try {
                        return (String) m.invoke(null, st);
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        e.printStackTrace();
                        return "";
                    }
                }

                @Override
                public String getIzena() {
                    return m.getName();
                }
            });
        }
    }

    public static String cdr(SinboloTaula st) {
        return st.lortuBalioa("X1").substring(1);
    }

    public static String nonem(SinboloTaula st) {
        return st.lortuBalioa("X1").isEmpty() ? "" : "a";
    }

    public static String kateatu(SinboloTaula st) {
        return st.lortuBalioa("X1") + st.lortuBalioa("X2");
    }

    public static String hur(SinboloTaula st) {
        int zenbakia = Utils.hitzakZenbakira(st.getAlfabetoa(), st.lortuBalioa("X1"));
        return Utils.zenbakiaHitzera(st.getAlfabetoa(), zenbakia + 1);

    }

    public static String aurre(SinboloTaula st) {
        int zenbakia = Utils.hitzakZenbakira(st.getAlfabetoa(), st.lortuBalioa("X1"));
        if (zenbakia == 0) {
            return "";
        } else {
            return Utils.zenbakiaHitzera(st.getAlfabetoa(), zenbakia - 1);
        }
    }

    public static String kod(SinboloTaula st){
        List<String> parametroak = new ArrayList<>();
        int i = 1;
        while (st.baduBalio("X"+Integer.toString(i))) {
            parametroak.add(st.lortuBalioa("X" + Integer.toString(i)));
            i++;
        }
        return Utils.kod(st.getAlfabetoa(), parametroak);
    }


}
