package amc2024;

import java.util.*;
import java.io.*;

public class Eggs {
    char[][] mat;
    boolean[][] v;
    int[] vr = {-1, 1, 0, 0};
    int[] vc = {0, 0, -1, 1};
    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/amc2024/Eggs.dat"));
        //Scanner f = new Scanner(System.in);

        int t = f.nextInt();
        while (t -- > 0) {
            int row = f.nextInt(), col = f.nextInt();
            mat = new char[row][col];
            v = new boolean[row][col];
            for (int i = 0; i < row; i++) {
                mat[i] = f.next().toCharArray();
            }
            int max = 0;
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (mat[i][j] == '0' && !v[i][j]) {
                        max = Math.max(max, recur(i, j));
                    }
                }
            }
            System.out.println(max);
        }

        f.close();
    }

    public int recur(int r, int c) {
        if (r < 0 || r >= mat.length || c < 0 | c >= mat[r].length || mat[r][c] == '_' || v[r][c]) {
            return 0;
        }
        v[r][c] = true;
        int sum = 1;
        for (int i = 0; i < 4; i++) {
            sum += recur(r + vr[i], c + vc[i]);
        }
        return sum;
    }

    public static void main(String[] args) throws Exception {
        new Eggs().run();
    }
}