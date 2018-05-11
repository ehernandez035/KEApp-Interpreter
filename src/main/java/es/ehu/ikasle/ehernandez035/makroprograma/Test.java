package es.ehu.ikasle.ehernandez035.makroprograma;

import es.ehu.ikasle.ehernandez035.makroprograma.SZA.Liburutegia;
import es.ehu.ikasle.ehernandez035.makroprograma.SZA.SinboloTaula;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        List<Character> alf = new ArrayList<>();
        alf.add('a');
        alf.add('b');
        alf.add('c');
        int count = 0;
        for (int i = 0; i<30; i++) {
            String hitza = Utils.zenbakiaHitzera(alf, BigInteger.valueOf(i));
            ArrayList<String> bektorea = Utils.hitzetikBektorera(alf, hitza);

            for (int j = 0; j<bektorea.size(); j++) {
                SinboloTaula st = new SinboloTaula(alf);
                st.gordeAldagaia("X1", hitza);
                st.gordeAldagaia("X2", Utils.zenbakiaHitzera(alf, BigInteger.valueOf(j)));
                st.gordeAldagaia("X3", "a");
                String aldatua = Liburutegia.aldatu(st);
                ArrayList<String> berria = Utils.hitzetikBektorera(alf, aldatua);
                if (berria.size() != bektorea.size()) {
                    count++;
                } else {
                    for (int k = 0; k<berria.size(); k++) {
                        if (k == j) {
                            if (!"a".equals(berria.get(k))) {
                                count++;
                            }
                        } else if (!berria.get(k).equals(bektorea.get(k))) {
                            count++;
                        }
                    }
                }
            }
        }
        System.out.println(count);
    }
}
