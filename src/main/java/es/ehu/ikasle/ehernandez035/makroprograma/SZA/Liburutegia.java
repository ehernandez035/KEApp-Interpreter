package es.ehu.ikasle.ehernandez035.makroprograma.SZA;

import es.ehu.ikasle.ehernandez035.makroprograma.Utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
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

    public static String kod(SinboloTaula st) {
        List<String> parametroak = new ArrayList<>();
        int i = 1;
        while (st.baduBalio("X" + Integer.toString(i))) {
            parametroak.add(st.lortuBalioa("X" + Integer.toString(i)));
            i++;
        }
        return Utils.kod(st.getAlfabetoa(), parametroak);
    }

    public static String zero_da(SinboloTaula st) {
        return st.lortuBalioa("X1").isEmpty() ? "a" : "";
    }

    public static String phutsa(SinboloTaula st) {
        return "";
    }

    public static String pilaratu(SinboloTaula st) {
        String aldagaia = st.lortuBalioa("X1");
        String pila = st.lortuBalioa("X2");
        if (pila.equals("")) {
            return Utils.kod_2(st.getAlfabetoa(), Utils.zenbakiaHitzera(st.getAlfabetoa(), Utils.hitzakZenbakira(st.getAlfabetoa(), aldagaia) + 1), "");
        } else {
            return Utils.kod_2(st.getAlfabetoa(), aldagaia, pila);
        }
    }

    public static String despilaratu(SinboloTaula st) {
        String pila = st.lortuBalioa("X1");
        if (pila.equals("")) {
            return "";
        } else {
            return Utils.dekod_2(st.getAlfabetoa(), pila)[1];
        }
    }

    public static String tontorra(SinboloTaula st) {
        String azkenelem = st.lortuBalioa("X1");
        if (azkenelem.equals("")) {
            return "";
        } else {
            String[] deskod = Utils.dekod_2(st.getAlfabetoa(), azkenelem);
            if (deskod[1].equals("")) {
                return Utils.zenbakiaHitzera(st.getAlfabetoa(), Utils.hitzakZenbakira(st.getAlfabetoa(), deskod[0]) - 1);
            } else {
                return deskod[0];
            }
        }
    }

    public static String p_hutsa_da(SinboloTaula st) {
        return st.lortuBalioa("X1").equals("") ? "a" : "";
    }

    public static String lehen_bektore(SinboloTaula st) {
        return "";
    }

    public static String azken_indizea(SinboloTaula st) {
        return Utils.dekod_2(st.getAlfabetoa(), st.lortuBalioa("X1"))[0];
    }

    public static String atzitu(SinboloTaula st) {
        String[] w = Utils.dekod_2(st.getAlfabetoa(), st.lortuBalioa("X1"));
        int luzera = Utils.hitzakZenbakira(st.getAlfabetoa(), w[0]) + 1;
        int indize = Utils.hitzakZenbakira(st.getAlfabetoa(), st.lortuBalioa("X2"));
        // TODO Errorea tratatu
        if (indize >= luzera) return "";
        return Utils.dekod(st.getAlfabetoa(), w[1], luzera)[indize];
    }

    public static String aldatu(SinboloTaula st) {
        String[] w = Utils.dekod_2(st.getAlfabetoa(), st.lortuBalioa("X1"));
        int luzera = Utils.hitzakZenbakira(st.getAlfabetoa(), w[0]) + 1;
        int indize = Utils.hitzakZenbakira(st.getAlfabetoa(), st.lortuBalioa("X2"));
        String[] bektore = Utils.dekod(st.getAlfabetoa(), w[1], luzera);

        int luzeraberria = indize > luzera ? indize : luzera;

        List<String> berria = new ArrayList<>(luzeraberria);
        berria.addAll(Arrays.asList(bektore));
        for (int i = bektore.length; i<luzeraberria; i++) berria.add("");
        berria.add(indize, st.lortuBalioa("X2"));
        return Utils.kod_2(st.getAlfabetoa(), Utils.zenbakiaHitzera(st.getAlfabetoa(), luzeraberria-1), Utils.kod(st.getAlfabetoa(), berria));
    }

}
