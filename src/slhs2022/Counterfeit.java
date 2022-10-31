package slhs2022;

import java.util.*;
import java.io.*;

public class Counterfeit {
    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/slhs2022/counterfeit.dat"));
        //Scanner f = new Scanner(System.in);

        int cases = f.nextInt();
        while (cases-- > 0) {

            int coins = f.nextInt();
            int length = f.nextInt();
            HashMap<String, int[]> hm = new HashMap<>();
            f.nextLine();
            for (int i = 1; i <= coins; i++) {
                String coin = "";
                for (int j = 0; j < length; j++) {
                    coin += f.nextLine();
                }

                if (hm.containsKey(coin)) {
                    hm.put(coin, new int[] {hm.get(coin)[0] + 1, i});
                }
                else {
                    hm.put(coin, new int[] {1, i});
                }
            }

            for (String key : hm.keySet()) {
                if (hm.get(key)[0] == 1) {
                    System.out.println("Sir, coin " + hm.get(key)[1] + " is a counterfeit!");
                }
            }

        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Counterfeit().run();
    }

}