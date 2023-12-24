package clements2023;

import java.util.*;
import java.io.*;

public class Route {
    int[][] mat;
    boolean[][] shadow;
    int max;

    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/clements2023/Route.dat"));
        //Scanner f = new Scanner(System.in);

        int n = f.nextInt();
        while (n --> 0) {
            int row = f.nextInt();
            int col = f.nextInt();
            mat = new int[row][col];
            shadow = new boolean[row][col];
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    mat[i][j] = f.nextInt();
                }
            }
            max = 1;
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    recur(i, j, 1, -1);
                }
            }
            System.out.println(max);
        }

        f.close();
    }

    public void recur(int r, int c, int d, int prev) {
        if (r < 0 || r >= mat.length || c < 0 || c >= mat[r].length || shadow[r][c] || mat[r][c] <= prev) {
            return;
        }
        max = Math.max(max, d);
        shadow[r][c] = true;
        recur(r + 1, c, d + 1, mat[r][c]);
        recur(r - 1, c, d + 1, mat[r][c]);
        recur(r, c + 1, d + 1, mat[r][c]);
        recur(r, c - 1, d + 1, mat[r][c]);
        shadow[r][c] = false;
    }

    public static void main(String[] args) throws Exception {
        new Route().run();
    }

}