package es.ehu.ikasle.ehernandez035.makroprograma.SZA;

import es.ehu.ikasle.ehernandez035.makroprograma.Utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Liburutegia {

    public static void gehituFuntzioak(SinboloTaula st) {

        for (final Method m : Liburutegia.class.getDeclaredMethods()) {
            if (m.getParameterTypes().length != 1 || m.getParameterTypes()[0] != SinboloTaula.class || m.getReturnType() != String.class) {
                continue;
            }
            st.gordeFuntzioa(new IFuntzioa() {
                @Override
                public String execute(SinboloTaula st) {
                    //noinspection TryWithIdenticalCatches
                    try {
                        return (String) m.invoke(null, st);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                        return "";
                    } catch (InvocationTargetException e) {
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
        BigInteger zenbakia = Utils.hitzakZenbakira(st.getAlfabetoa(), st.lortuBalioa("X1"));
        return Utils.zenbakiaHitzera(st.getAlfabetoa(), zenbakia.add(BigInteger.ONE));

    }

    public static String aurre(SinboloTaula st) {
        BigInteger zenbakia = Utils.hitzakZenbakira(st.getAlfabetoa(), st.lortuBalioa("X1"));
        if (zenbakia.signum() == 0) {
            return "";
        } else {
            return Utils.zenbakiaHitzera(st.getAlfabetoa(), zenbakia.subtract(BigInteger.ONE));
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
        return Utils.pilaratu(st.getAlfabetoa(), aldagaia, pila);
    }

    public static String despilaratu(SinboloTaula st) {
        return Utils.despilaratu(st.getAlfabetoa(), st.lortuBalioa("X1"));
    }

    public static String tontorra(SinboloTaula st) {
        String azkenelem = st.lortuBalioa("X1");
        return Utils.tontorra(st.getAlfabetoa(), azkenelem);
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
        int luzera = Utils.hitzakZenbakira(st.getAlfabetoa(), w[0]).add(BigInteger.ONE).intValue();
        int indize = Utils.hitzakZenbakira(st.getAlfabetoa(), st.lortuBalioa("X2")).intValue();
        // TODO Errorea tratatu
        if (indize >= luzera) return "";
        return Utils.dekod(st.getAlfabetoa(), w[1], luzera)[indize];
    }

    public static String aldatu(SinboloTaula st) {
        String[] w = Utils.dekod_2(st.getAlfabetoa(), st.lortuBalioa("X1"));
        int luzera = Utils.hitzakZenbakira(st.getAlfabetoa(), w[0]).add(BigInteger.ONE).intValue();
        int indize = Utils.hitzakZenbakira(st.getAlfabetoa(), st.lortuBalioa("X2")).intValue();
        String balioBerria = st.lortuBalioa("X3");
        String[] bektore = Utils.dekod(st.getAlfabetoa(), w[1], luzera);

        if (indize <= luzera) {
            bektore[indize] = balioBerria;
            return Utils.bektoretikHitzera(st.getAlfabetoa(), Arrays.asList(bektore));
        } else {
            int luzeraberria = indize > luzera ? indize : luzera;

            List<String> berria = new ArrayList<>(luzeraberria);
            berria.addAll(Arrays.asList(bektore));
            for (int i = bektore.length; i < luzeraberria; i++) berria.add("");
            berria.add(indize, balioBerria);
            return Utils.bektoretikHitzera(st.getAlfabetoa(), berria);
        }
    }


}
