package district2013_2;

import java.util.*;
import java.io.*;

public class Cheese {

    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/district2013_2/Cheese.dat".toLowerCase()));
        //Scanner f = new Scanner(System.in);

        int n = f.nextInt();
        while (n-- > 0) {
            long seed = f.nextLong();
            int m = f.nextInt();
            Random r = new Random(seed);
            int[] g = new int[6];
            String out = "ABCDEF";
            while (m-- > 0) {
                int r1 = r.nextInt(6);
                int r2 = r.nextInt(6) + 1;
                int r3 = r.nextInt(6) + 1;
                g[r1] += r2 + r3;
            }
            for (int i = 0; i < g.length; i++) {
                System.out.println(out.charAt(i) + " " + g[i]);
            }
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Cheese().run();
    }

}