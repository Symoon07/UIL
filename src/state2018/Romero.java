package state2018;

import java.util.*;
import java.io.*;

public class Romero {
    char[][] mat;
    int[][] shadow;
    int[] D;
    int[] G;
    int time;


    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/state2018/Romero.dat".toLowerCase()));
        //Scanner f = new Scanner(System.in);

        int n = f.nextInt(); f.nextLine();
        while (n-- > 0) {
            int row = f.nextInt();
            int col = f.nextInt();
            int t = f.nextInt(); f.nextLine();
            int sr = -1;
            int sc = -1;
            mat = new char[row][col];
            shadow = new int[row][col];
            D = new int[2];
            G = new int[2];
            for (int i = 0; i < row; i++) {
                String s = f.nextLine();
                for (int j = 0; j < col; j++) {
                    if (s.charAt(j) == 'S') {
                        sr = i;
                        sc = j;
                    }
                    if (s.charAt(j) == 'G') {
                        D[0] = i;
                        D[1] = j;
                    }
                    if (s.charAt(j) == 'D') {
                        G[0] = i;
                        G[1] = j;
                    }
                    mat[i][j] = s.charAt(j);
                    shadow[i][j] = Integer.MAX_VALUE;
                }
            }
            time = -1;
            recur(sr, sc, 0);
            System.out.println(time <= t ? "DON'T WORRY, I'LL CARRY YOU" : "BG NOOBS");
        }

        f.close();
    }

    public void recur(int r, int c, int t) {
        if (r < 0 || r>= mat.length || c < 0 || c >= mat[r].length || t >= shadow[r][c] || mat[r][c] == 'X') {
            return;
        }
        shadow[r][c] = t;
        char save = mat[r][c];
        if (mat[r][c] == 'E') {
            time = t + 5;
            return;
        }
        if (mat[r][c] == 'D') {
            mat[r][c] = 'X';
            recur(D[0], D[1], t + 3);
            mat[r][c] = save;
        }
        if (mat[r][c] == 'G') {
            mat[r][c] = 'X';
            recur(G[0], G[1], t + 3);
            mat[r][c] = save;
        }
        mat[r][c] = 'X';
        recur(r + 1, c, t + 1);
        recur(r - 1, c, t + 1);
        recur(r, c + 1, t + 1);
        recur(r, c -1, t + 1);
        mat[r][c] = save;
    }

    public static void main(String[] args) throws Exception {
        new Romero().run();
    }

}