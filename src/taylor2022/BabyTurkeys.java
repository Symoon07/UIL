package taylor2022;

import java.util.*;
import java.io.*;

public class BabyTurkeys {
    public void run() throws Exception {
        //Scanner f = new Scanner(new File("template.dat"));
        Scanner f = new Scanner(System.in);

        int babies = f.nextInt();
        f.nextLine();
        HashMap<String, String> names = new HashMap<>();
        HashMap<String, Double> val = new HashMap<>();
        while (babies-- > 0) {
            String[] in = f.nextLine().split(",");
            names.put(in[0], in[1]);
            val.put(in[0], Double.parseDouble(in[2]));
        }

        int parents = f.nextInt();
        while (parents-- > 0) {
            String parent = f.next();
            ArrayList<String> out = new ArrayList<>();
            for (String key : names.keySet()) {
                if (names.get(key).equals(parent)) {
                    out.add(key);
                }
            }
            double max = Double.MAX_VALUE;
            for (String key : out) {
                if (val.get(key) < max) {
                    out.remove(key);
                }
                else {
                    max = val.get(key);
                }
            }
            System.out.println(out.get(0));
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new BabyTurkeys().run();
    }

}