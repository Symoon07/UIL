package cw2012;

import java.util.*;
import java.io.*;

public class Arena {
    char[][] mat;
    int[][] shadow;
    int[][] gate;
    int found;

    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/cw2012/Arena.dat".toLowerCase()));
        //Scanner f = new Scanner(System.in);

        int t = f.nextInt(); f.nextLine();
        while (t --> 0) {
            int row = f.nextInt();
            int col = f.nextInt();
            int sr = 0;
            int sc = 0;
            int time = f.nextInt(); f.nextLine();
            mat = new char[row][col];
            shadow = new int[row][col];
            gate = new int[2][2];
            for (int i = 0; i < row; i++) {
                String s = f.nextLine();
                Arrays.fill(shadow[i], Integer.MAX_VALUE);
                for (int j = 0; j < col; j++) {
                    switch (s.charAt(j)) {
                        case 'S' ->  {
                            sr = i;
                            sc = j;
                        }
                        case 'D' -> {
                            gate[0][0] = i;
                            gate[0][1] = j;
                        }
                        case 'G' -> {
                            gate[1][0] = i;
                            gate[1][1] = j;
                        }
                    }
                    mat[i][j] = s.charAt(j);
                }
            }
            found = -1;
            recur(sr, sc, 0);
            System.out.println(found <= time ? "DON'T WORRY, I'LL CARRY YOU" : "BG NOOBS");
        }

        f.close();
    }

    public void recur(int r, int c, int t) {
        if (r < 0 || r >= mat.length || c < 0 || c >= mat[r].length || mat[r][c] == 'X' || t >= shadow[r][c]) {
            return;
        }
        shadow[r][c] = t;
        if (mat[r][c] == 'E') {
            found = t + 5;
            return;
        }
        char save = mat[r][c];
        if (mat[r][c] == 'D') {
            mat[r][c] = 'X';
            recur(gate[1][0], gate[1][1], t + 3);
            mat[r][c] = save;
        }
        else if (mat[r][c] == 'G') {
            mat[r][c] = 'X';
            recur(gate[0][0], gate[0][1], t + 3);
            mat[r][c] = save;
        }
        mat[r][c] = 'X';
        recur(r + 1, c, t + 1);
        recur(r - 1, c, t + 1);
        recur(r, c + 1, t + 1);
        recur(r, c - 1, t + 1);
        mat[r][c] = save;
    }

    public static void main(String[] args) throws Exception {
        new Arena().run();
    }

}