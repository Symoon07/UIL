package waller2023;

import java.util.*;
import java.io.*;

public class Hellen {

    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/waller2023/Hellen.dat"));
        //Scanner f = new Scanner(System.in);

        int t = f.nextInt();
        while (t --> 0) {
            int n = f.nextInt();
            int m = f.nextInt();
            boolean[] wm = new boolean[n + 1];
            while (m --> 0) {
                int k = f.nextInt();
                for (int i = k; i <= n; i+=k) {
                    wm[i] ^= true;
                }
            }
            int out = 0;
            for (int i = 1; i <= n; i++) {
                if (!wm[i]) {
                    out++;
                }
            }
            System.out.println(out);
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Hellen().run();
    }

}