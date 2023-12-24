package state2018;

import java.util.*;
import java.io.*;

public class Dennis {

    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/state2018/Dennis.dat"));
        //Scanner f = new Scanner(System.in);

        int n = f.nextInt();
        while (n --> 0) {
            int m = f.nextInt();
            int max = 0;
            char[][] mat = new char[m][];
            for (int i = 0; i < m; i++) {
                mat[i] = f.next().toCharArray();
                max = Math.max(max, mat[i].length);
            }
            for (int i = 0; i < max; i++) {
                for (int j = 0; j < m; j++) {
                    System.out.print(i >= mat[j].length ? " " : mat[j][i]);
                }
                System.out.println();
            }
            System.out.println("*".repeat(m));
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Dennis().run();
    }

}