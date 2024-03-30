package state2020;

import java.util.*;
import java.io.*;

public class Doors {
    char[][] mat;
    int[][][] smat;
    int[] vr = {-1, 1, 0, 0};
    int[] vc = {0, 0, -1, 1};
    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/state2020/Doors.dat"));
        //Scanner f = new Scanner(System.in);

        int t = f.nextInt();
        while (t --> 0) {
            int row = f.nextInt(), col = f.nextInt(), s = f.nextInt();
            int sr = 0, sc = 0, er = 0, ec = 0;
            int keys = 0;
            mat = new char[row][col];
            for (int i = 0; i < row; i++) {
                mat[i] = f.next().toCharArray();
                for (int j = 0; j < col; j++) {
                    if (mat[i][j] == ']') {
                        sr = i;
                        sc = j;
                    }
                    else if (mat[i][j] == '[') {
                        er = i;
                        ec = j;
                    }
                    else if (Character.isLowerCase(mat[i][j])) {
                        keys++;
                    }
                }
            }
            smat = new int[1 << keys][row][col];
            for (int i = 0; i < 1 << keys; i++) {
                for (int j = 0; j < row; j++) {
                    Arrays.fill(smat[i][j], Integer.MAX_VALUE);
                }
            }
            recur(sr, sc, 0, 0);
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < 1 << keys; i++) {
                min = Math.min(min, smat[i][er][ec]);
            }
            System.out.println(min <= s ? String.format("Amaezing Job. Escaped in %d steps.", min) : "Mother knows best.");
        }

        f.close();
    }

    public void recur(int r, int c, int s, int mask) {
        if (r < 0 || r >= mat.length || c < 0 || c >= mat[r].length || mat[r][c] == '#' || (Character.isUpperCase(mat[r][c]) && (mask & 1 << mat[r][c] - 'A') == 0) || s >= smat[mask][r][c]) {
            return;
        }
        if (Character.isLowerCase(mat[r][c])) {
            mask |= 1 << mat[r][c] - 'a';
        }
        smat[mask][r][c] = s;
        for (int i = 0; i < 4; i++) {
            recur(r + vr[i], c + vc[i], s+1, mask);
        }
    }

    public static void main(String[] args) throws Exception {
        new Doors().run();
    }
}