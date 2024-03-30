package b2024;

import java.util.*;
import java.io.*;

public class Jana {
    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/b2024/Jana.dat"));
        //Scanner f = new Scanner(System.in);

        int t = f.nextInt();
        while (t --> 0) {
            int n = f.nextInt();
            char[][] mat = new char[n][n];
            int c = 0;
            while (c <= n / 2) {
                for (int i = c; i < n - c; i++) {
                    mat[c][i] = '#';
                    mat[i][c] = '#';
                    mat[n - c - 1][i] = '#';
                    mat[i][n - c - 1] = '#';
                }
                c += 2;
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(mat[i][j] == '#' ? mat[i][j] : " ");
                }
                System.out.println();
            }
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Jana().run();
    }
}