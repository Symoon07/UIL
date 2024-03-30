package district2012;

import java.util.*;
import java.io.*;

public class Binary {

    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/district2012/Binary.dat".toLowerCase()));
        //Scanner f = new Scanner(System.in);

        int cases = f.nextInt(); f.nextLine();
        while (cases-- > 0) {
            HashMap<Integer, Integer> hm = new HashMap<>();
            hm.put(3, 1);
            hm.put(2, 2);
            hm.put(1, 4);
            hm.put(0, 8);
            char[][] mat = new char[4][6];
            for (int i = 0; i < 4; i++) {
                mat[i] = f.nextLine().toCharArray();
            }
            String out = "";
            for (int i = 0; i < 6; i++) {
                int cur = 0;
                for (int j = 3; j >= 0; j--) {
                    if (mat[j][i] == '*') {
                        cur += hm.get(j);
                    }
                }
                if (i % 2 == 1) {
                    out += cur + ":";
                }
                else {
                    out += cur;
                }
            }
            System.out.println(out.substring(0, out.length()-1));
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Binary().run();
    }

}