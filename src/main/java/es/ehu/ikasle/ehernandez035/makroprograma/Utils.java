package es.ehu.ikasle.ehernandez035.makroprograma;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import static com.ibm.icu.math.BigDecimal.ROUND_HALF_UP;
import static es.ehu.ikasle.ehernandez035.makroprograma.SZA.Alfabetoa.LetraValue;

public class Utils {

    private static final BigInteger BIGINT_TWO = BigInteger.valueOf(2);
    private static final BigDecimal BIGDECIMAL_TWO = BigDecimal.valueOf(2);

    public static BigInteger hitzakZenbakira(List<Character> alfabetoa, String hitza) {
        int berrekizuna = alfabetoa.size();
        BigInteger zenb = BigInteger.ZERO;
        for (int i = 0; i < hitza.length(); i++) {
            zenb = zenb.add(BigInteger.valueOf(berrekizuna).pow(hitza.length()-i-1).multiply(BigInteger.valueOf(LetraValue(hitza.charAt(i), alfabetoa))));
        }
        return zenb;
    }

    public static String zenbakiaHitzera(List<Character> alfabetoa, BigInteger zenbakia) {
        if (zenbakia.signum() == 0) return "";
        BigInteger zatidura = zenbakia;
        StringBuilder emaitza = new StringBuilder();
        BigInteger alfSize = BigInteger.valueOf(alfabetoa.size());
        while (zatidura.subtract(alfSize).signum() == 1) {
            BigInteger hondarra = zatidura.mod(alfSize);
            zatidura = zatidura.divide(alfSize);
            if (hondarra.signum() == 0) {
                hondarra = alfSize;
                zatidura = zatidura.subtract(BigInteger.ONE);
            }
            emaitza.append(alfabetoa.get((int) (hondarra.longValue() - 1)));
        }
        return alfabetoa.get((int) (zatidura.longValue() - 1)) + emaitza.reverse().toString();
    }

    public static BigInteger kod_2(BigInteger x1, BigInteger x2) {
        return x1.add(x2).add(BigInteger.ONE).multiply(x1.add(x2)).divide(BIGINT_TWO).add(x2);

    }

    public static String kod_2(List<Character> alfabetoa, String x1, String x2) {
        BigInteger z1 = Utils.hitzakZenbakira(alfabetoa, x1);
        BigInteger z2 = Utils.hitzakZenbakira(alfabetoa, x2);
        BigInteger emaitza = kod_2(z1, z2);
        return Utils.zenbakiaHitzera(alfabetoa, emaitza);
    }

    public static BigInteger kod(List<BigInteger> elementuak) {
        BigInteger azkenekoa = elementuak.get(elementuak.size() - 1);
        for (int i = elementuak.size() - 2; i >= 0; i--) {
            azkenekoa = kod_2(elementuak.get(i), azkenekoa);
        }
        return azkenekoa;
    }

    public static String kod(List<Character> alfabetoa, List<String> elementuak) {
        String azkenekoa = elementuak.get(elementuak.size() - 1);
        for (int i = elementuak.size() - 2; i >= 0; i--) {
            azkenekoa = kod_2(alfabetoa, elementuak.get(i), azkenekoa);
        }
        return azkenekoa;
    }

    private static BigDecimal sqrt(BigDecimal A, final int SCALE) {
        BigDecimal x0 = new BigDecimal("0");
        BigDecimal x1 = new BigDecimal(Math.sqrt(A.doubleValue()));
        while (!x0.equals(x1)) {
            x0 = x1;
            x1 = A.divide(x0, SCALE, ROUND_HALF_UP);
            x1 = x1.add(x0);
            x1 = x1.divide(BIGDECIMAL_TWO, SCALE, ROUND_HALF_UP);
        }
        return x1;
    }


    public static BigInteger[] dekod_2(BigInteger hitza){


        BigInteger w = sqrt(new BigDecimal(hitza.multiply(BigInteger.valueOf(8)).add(BigInteger.ONE)), 50).subtract(BigDecimal.ONE).toBigInteger().divide(BIGINT_TWO);
        BigInteger t = w.multiply(w).add(w).divide(BIGINT_TWO);
        BigInteger y = hitza.subtract(t);
        BigInteger x = w.subtract(y);
        return new BigInteger[]{x,y};
    }

    public static String[] dekod_2(List<Character> alfabetoa, String hitza) {
        BigInteger z = Utils.hitzakZenbakira(alfabetoa, hitza);
        BigInteger[] dekod2 = dekod_2(z);
        return new String[]{Utils.zenbakiaHitzera(alfabetoa, dekod2[0]), Utils.zenbakiaHitzera(alfabetoa, dekod2[1])};
    }

    public static BigInteger[] dekod(BigInteger hitza, int n){
        BigInteger[] emaitza = new BigInteger[n];
        for (int i = 0; i < n - 1; i++) {
            BigInteger[] unekoa = dekod_2(hitza);
            emaitza[i] = unekoa[0];
            hitza = unekoa[1];
        }
        emaitza[n - 1] = hitza;
        return emaitza;
    }
    public static String[] dekod(List<Character> alfabetoa, String hitza, int n) {
        String[] emaitza = new String[n];
        for (int i = 0; i < n - 1; i++) {
            String[] unekoa = dekod_2(alfabetoa, hitza);
            emaitza[i] = unekoa[0];
            hitza = unekoa[1];
        }
        emaitza[n - 1] = hitza;
        return emaitza;
    }

    public static String tontorra(List<Character> alfabetoa, String pila) {
        if (pila.equals("")) {
            return "";
        } else {
            String[] deskod = Utils.dekod_2(alfabetoa, pila);
            if (deskod[1].equals("")) {
                return Utils.zenbakiaHitzera(alfabetoa, Utils.hitzakZenbakira(alfabetoa, deskod[0]).subtract(BigInteger.ONE));
            } else {
                return deskod[0];
            }
        }
    }

    public static String despilaratu(List<Character> alfabetoa, String pila) {
        if (pila.equals("")) {
            return "";
        } else {
            return Utils.dekod_2(alfabetoa, pila)[1];
        }
    }

    public static String pilaratu(List<Character> alfabetoa, String aldagaia, String pila) {
        if (pila.equals("")) {
            return Utils.kod_2(alfabetoa, Utils.zenbakiaHitzera(alfabetoa, Utils.hitzakZenbakira(alfabetoa, aldagaia).add(BigInteger.ONE)), "");
        } else {
            return Utils.kod_2(alfabetoa, aldagaia, pila);
        }
    }

    public static ArrayList<String> hitzetikPilera(List<Character> alfabetoa, String hitza) {
        ArrayList<String> pila = new ArrayList<>();
        if (hitza.equals("")) {
            return pila;
        }
        while (!hitza.isEmpty()) {
            pila.add(tontorra(alfabetoa, hitza));
            hitza = despilaratu(alfabetoa, hitza);
        }
        return pila;
    }

    public static ArrayList<String> hitzetikBektorera(List<Character> alfabetoa, String hitza){
        ArrayList<String> bektorea = new ArrayList<>();
        if(hitza.equals("")){
            bektorea.add("");
            return bektorea;
        }
        int luzera = hitzakZenbakira(alfabetoa, dekod_2(alfabetoa, hitza)[0]).add(BIGINT_TWO).intValue();
        String[] dekod = dekod(alfabetoa, hitza, luzera);
        for (int i=0;i<luzera-1;i++){
            bektorea.add(dekod[i+1]);
        }
        return bektorea;
    }

    public static String bektoretikHitzera(List<Character> alfabetoa, List<String> bektorea){
        ArrayList<String> bektoreBerria = new ArrayList<>();
        bektoreBerria.add(zenbakiaHitzera(alfabetoa, BigInteger.valueOf(bektorea.size()-1)));
        bektoreBerria.addAll(bektorea);
        return kod(alfabetoa,bektoreBerria);
    }

    public static String pilatikHitzera(List<Character> alfabetoa, List<String> pila){
        String pilaBerria = "";
        for(int i=pila.size()-1; i>=0; i--){
            pilaBerria=pilaratu(alfabetoa,pila.get(i),pilaBerria);
        }
        return pilaBerria;
    }


}

