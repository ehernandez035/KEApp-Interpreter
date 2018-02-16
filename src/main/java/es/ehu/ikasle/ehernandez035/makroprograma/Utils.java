package es.ehu.ikasle.ehernandez035.makroprograma;

import java.util.List;

import static es.ehu.ikasle.ehernandez035.makroprograma.SZA.Alfabetoa.LetraValue;
import static java.lang.Math.pow;

public class Utils {

    public static int hitzakZenbakira(List<Character> alfabetoa, String hitza) {
        int berrekizuna = alfabetoa.size();
        int zenb = 0;
        for (int i = 0; i < hitza.length(); i++) {
            zenb += LetraValue(hitza.charAt(i), alfabetoa) * pow(berrekizuna, hitza.length() - i - 1);
        }
        return zenb;
    }

    public static String zenbakiaHitzera(List<Character> alfabetoa, int zenbakia) {
        if (zenbakia == 0) return "";
        int zatidura = zenbakia;
        StringBuilder emaitza = new StringBuilder();
        while (zatidura > alfabetoa.size()) {
            int hondarra = zatidura % alfabetoa.size();
            zatidura = zatidura / alfabetoa.size();
            if (hondarra == 0) {
                hondarra = alfabetoa.size();
                zatidura--;
            }
            emaitza.append(alfabetoa.get(hondarra - 1));
        }
        return alfabetoa.get(zatidura - 1) + emaitza.reverse().toString();
    }

    public static String kod_2(List<Character> alfabetoa, String x1, String x2) {
        int z1 = Utils.hitzakZenbakira(alfabetoa, x1);
        int z2 = Utils.hitzakZenbakira(alfabetoa, x2);
        int emaitza = ((z1 + z2 + 1) * (z1 + z2)) / 2 + z2;
        return Utils.zenbakiaHitzera(alfabetoa, emaitza);
    }

    public static String kod(List<Character> alfabetoa, List<String> elementuak) {
        String azkenekoa = elementuak.get(elementuak.size() - 1);
        for (int i = elementuak.size() - 2; i >= 0; i--) {
            azkenekoa = kod_2(alfabetoa, elementuak.get(i), azkenekoa);
        }
        return azkenekoa;
    }

    public static String[] dekod_2(List<Character> alfabetoa, String hitza) {
        int z = Utils.hitzakZenbakira(alfabetoa, hitza);
        int w = (int) Math.floor((Math.sqrt(8 * z + 1) - 1) / 2);
        int t = (w * w + w) / 2;
        int y = z - t;
        int x = w - y;
        return new String[]{Utils.zenbakiaHitzera(alfabetoa, x), Utils.zenbakiaHitzera(alfabetoa, y)};
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


}

