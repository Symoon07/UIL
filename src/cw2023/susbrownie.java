package cw2023;

import java.util.*;
import java.io.*;

public class susbrownie {
    char[][] mat;
    int[][] shadow;
    HashSet<Character> collected;
    boolean foundS;

    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/cw2023/susbrownie.dat"));
        //Scanner f = new Scanner(System.in);

        int t = f.nextInt();
        while (t --> 0) {
            int row = f.nextInt();
            int col = f.nextInt();
            int[][] starts = new int[2][2];
            mat = new char[row][col];
            for (int i = 0; i < row; i++) {
                mat[i] = f.next().toCharArray();
                for (int j = 0; j < col; j++) {
                    switch (mat[i][j]) {
                        case 'K' -> {
                            starts[0][0] = i;
                            starts[0][1] = j;
                        }
                        case 'S' -> {
                            starts[1][0] = i;
                            starts[1][1] = j;
                        }
                    }
                }
            }
            foundS = false;
            collected = new HashSet<>();
            for (int i = 0; i < 2; i++) {
                shadow = new int[row][col];
                for (int j = 0; j < row; j++) {
                    Arrays.fill(shadow[j], Integer.MAX_VALUE);
                }
                recur(starts[i][0], starts[i][1], 0, i % 2 == 1);
            }
            System.out.println(collected.size() != 5 ? "Kenny can't bake brownies :(" : foundS ? "Kenny was able to bake brownies in complete secrecy!" : "Kenny got caught by the police...");
        }

        f.close();
    }

    public void recur(int r, int c, int d, boolean S) {
        if (r < 0 || r >= mat.length || c < 0 || c >= mat[r].length || mat[r][c] == '#' || mat[r][c] == 'A' || (!S && mat[r][c] == 'O') || (S && !safe(r, c)) || shadow[r][c] <= d) {
            return;
        }
        if (S && mat[r][c] == 'O') {
            foundS = true;
            return;
        }
        if (!S && "BCEFS".contains("" + mat[r][c])) {
            collected.add(mat[r][c]);
        }
        shadow[r][c] = d;
        int[] vr = {-1, 1, 0, 0};
        int[] vc = {0, 0, -1, 1};
        for (int i = 0; i < 4; i++) {
            recur(r + vr[i], c + vc[i], d+1, S);
        }
    }

    public boolean safe(int r, int c) {
        for (int i = r-1; i <= r+1; i++) {
            for (int j = c-1; j <= c+1; j++) {
                if (i >= 0 && i < mat.length && j >= 0 && j < mat[r].length && mat[i][j] == 'A') {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        new susbrownie().run();
    }

}