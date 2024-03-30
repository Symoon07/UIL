package district2013_2;

import java.util.*;
import java.io.*;

public class Password {

    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/district2013_2/Password.dat".toLowerCase()));
        //Scanner f = new Scanner(System.in);

        int n = f.nextInt();
        while (n-- > 0) {
            String s = f.next();
            int m = f.nextInt();
            HashMap<String, Integer> hm = new HashMap<>();
            int cur = 0;
            String out = "";
            for (int i = 0; i < s.length()-m; i++) {
                String sub = s.substring(i, i + m);
                hm.putIfAbsent(sub, 0);
                hm.put(sub, hm.get(sub) + 1);
                if (hm.get(sub) > cur) {
                    out = sub;
                    cur = hm.get(sub);
                }
            }
            System.out.println(out);
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Password().run();
    }

}