package b2024;

import java.util.*;
import java.io.*;

public class Hiromi {
    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/b2024/Hiromi.dat"));
        //Scanner f = new Scanner(System.in);

        int t = f.nextInt();
        for (int i = 1; i <= t; i++) {
            f.next();
            int[][] mat = new int[9][9];
            for (int j = 0; j < 9; j++) {
                for (int k = 0; k < 9; k++) {
                    mat[j][k] = f.nextInt();
                }
            }
            boolean valid = true;
            for (int j = 0; j < 9; j++) {
                int row = 0;
                int col = 0;
                for (int k = 0; k < 9; k++) {
                    row += mat[j][k];
                    col += mat[k][j];
                }
                if (row != 45 || col != 45) {
                    valid = false;
                    break;
                }
            }
            for (int j = 0; j < 9; j+=3) {
                for (int k = 0; k < 9; k+=3) {
                    int box = 0;
                    for (int l = 0; l < 3; l++) {
                        for (int m = 0; m < 3; m++) {
                            box += mat[j + l][k + m];
                        }
                    }
                    if (box != 45) {
                        valid = false;
                        break;
                    }
                }
            }
            System.out.println("Puzzle #" + i + ": " + valid);
        }
        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Hiromi().run();
    }
}