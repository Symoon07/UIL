package state2013;

import java.util.*;
import java.io.*;

public class Triangles {

    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/state2013/Triangles.dat".toLowerCase()));
        //Scanner f = new Scanner(System.in);

        int t = f.nextInt();
        while (t --> 0) {
            int[] len = new int[5];
            for (int i = 0; i < 5; i++) {
                len[i] = f.nextInt();
            }
            int ct = 0;
            for (int i = 0; i < 5; i++) {
                for (int j = i + 1; j < 5; j++) {
                    for (int k = j + 1; k < 5; k++) {
                        int max = Math.max(Math.max(len[i], len[j]), len[k]);
                        if (len[i] + len[j] + len[k] - max > max) {
                            ct++;
                        }
                    }
                }
            }
            System.out.println(ct);
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Triangles().run();
    }

}