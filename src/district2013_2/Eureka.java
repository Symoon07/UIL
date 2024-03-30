package district2013_2;

import java.util.*;
import java.io.*;

public class Eureka {

    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/district2013_2/Eureka.dat".toLowerCase()));
        //Scanner f = new Scanner(System.in);

        int n = f.nextInt();
        while (n-- > 0) {
            long seed = f.nextLong();
            String w = f.next();
            String cur = "";
            Random r = new Random(seed);
            int i = 0;
            int out = 0;
            while (!cur.equals(w)) {
                char s = (char) (r.nextInt(26) + 65);
                if (s == w.charAt(i)) {
                    cur += s;
                    i++;
                }
                out++;
            }
            System.out.println(out);
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Eureka().run();
    }

}