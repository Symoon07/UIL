package state2018;

import java.util.*;
import java.io.*;

public class Emma {

    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/state2018/Emma.dat"));
        //Scanner f = new Scanner(System.in);

        while (f.hasNext()) {
            int n = f.nextInt();
            char[][] mat = new char[n * 3][n * 3];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    mat[i][j] = '*';
                    mat[i][j + n * 2] = '*';
                    mat[i + n * 2][j] = '*';
                    mat[i + n * 2][j + n * 2] = '*';
                }
            }
            for (int i = n; i < n * 2; i++) {
                for (int j = n; j < n * 2; j++) {
                    if (i == j) {
                        mat[i][j] = '*';
                        mat[i][n * 3 - j - 1] = '*';
                    }
                }
            }
            for (int i = 0; i < mat.length; i++) {
                for (int j = 0; j < mat.length; j++) {
                    System.out.print(mat[i][j] == 0 ? " " : mat[i][j]);
                }
                System.out.println();
            }
            System.out.println("==========");
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Emma().run();
    }

}