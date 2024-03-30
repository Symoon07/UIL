package waller2023;

import java.util.*;
import java.io.*;

public class Ella {

    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/waller2023/Ella.dat"));
        //Scanner f = new Scanner(System.in);

        int t = f.nextInt();
        while (t --> 0) {
            int n = f.nextInt();
            int m = f.nextInt();
            int[] l = new int[n];
            int[] p = new int[m];
            for (int i = 0; i < l.length; i++) {
                l[i] = f.nextInt();
            }
            for (int i = 0; i < p.length; i++) {
                p[i] = f.nextInt();
            }
            boolean[] c = new boolean[m];
            for (int i = 0; i < l.length; i++) {
                int total = 0;
                for (int j = 0; j < p.length; j++) {
                    if (p[j] <= l[i] && !c[j]) {
                        total++;
                        c[j] = true;
                    }
                }
                System.out.print(total + " ");
            }
            System.out.println();
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Ella().run();
    }

}