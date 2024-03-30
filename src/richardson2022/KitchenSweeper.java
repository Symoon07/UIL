package richardson2022;

import java.util.*;
import java.io.*;

public class KitchenSweeper {
    char[][] mat;
    String[][] out;

    public void run() throws Exception {
        //Scanner f = new Scanner(new File("template.dat"));
        Scanner f = new Scanner(System.in);

        int cols = f.nextInt();
        int rows = f.nextInt();
        mat = new char[rows][cols];
        out = new String[rows][cols];
        for (int i = 0; i < rows; i++) {
            mat[i] = f.next().toCharArray();
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (mat[i][j] == '*') {
                    out[i][j] = "*";
                }
                else {
                    out[i][j] = "0";
                }
            }
        }

        int[] vr = {-1, 1, 0, 0, -1, -1, 1, 1};
        int[] vc = {0, 0, -1, 1, -1, 1, -1, 1};
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (mat[i][j] == '*') {
                    for (int k = 0; k < 8; k++) {
                        int r = i + vr[k];
                        int c = j + vc[k];
                        if (r < 0 || r >= rows || c < 0 || c >= cols || mat[r][c] == '*') continue;

                        out[r][c] = String.valueOf(Integer.parseInt(out[r][c]) + 1);
                    }
                }
            }
        }

        for (String[] row : out) {
            for (String i : row) {
                System.out.print(i);
            }
            System.out.println();
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new KitchenSweeper().run();
    }

}