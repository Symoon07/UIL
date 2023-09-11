package state2023;

import java.util.*;
import java.io.*;

public class Lucas {

    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/state2023/Lucas.dat".toLowerCase()));
        //Scanner f = new Scanner(System.in);

        int cases = f.nextInt();
        while (cases-- > 0) {
            String s = f.next();
            int val = 0;
            int[] occ = new int[26];
            for (int i = 0; i < s.length(); i++) {
                occ[s.charAt(i)-97]++;
            }
            for (int i = 0; i < occ.length; i++) {
                val += (i + 1) * Math.pow(occ[i], 2);
            }
            System.out.println(val);
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Lucas().run();
    }

}