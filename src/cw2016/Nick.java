package cw2016;

import java.util.*;
import java.io.*;

public class Nick {
    int dec, inc;
    char[][] mat;
    int[][][] smat;
    int[] vr = {-1, 1, 0, 0};
    int[] vc = {0, 0, -1, 1};
    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/cw2016/Nick.dat"));
        //Scanner f = new Scanner(System.in);

        int t = f.nextInt(); f.nextLine();
        while (t --> 0) {
            int row = f.nextInt();
            dec = f.nextInt(); inc = f.nextInt();
            int s = f.nextInt(); f.nextLine();
            int sr = 0, sc = 0;
            mat = new char[row][];
            boolean[][] v = new boolean[row][];
            smat = new int[10000][row][];
            for (int i = 0; i < row; i++) {
                String temp = f.nextLine();
                mat[i] = temp.toCharArray();
                v[i] = new boolean[mat[i].length];
                for (int j = 0; j < 10000; j++) {
                    smat[j][i] = new int[mat[i].length];
                    Arrays.fill(smat[j][i], -1);
                }
                if (temp.contains("S")) {
                    sr = i;
                    sc = temp.indexOf("S");
                }
            }
            System.out.println(recur(sr, sc, 0, s, v) ? "STILL ALIVE" : "RIP IN PEPRI");
        }

        f.close();
    }

    public boolean recur(int r, int c, int t, int h, boolean[][] v) {
        if (r < 0 || r >= mat.length || c < 0 || c >= mat[r].length || mat[r][c] == '@' || h <= smat[t][r][c] || h < 0) {
            return false;
        }
        if (mat[r][c] == 'H') {
            return true;
        }
        smat[t][r][c] = h;
        if (mat[r][c] == 'T' && !v[r][c]) {
            v[r][c] = true;
            h += inc;
            t++;
        }
        for (int i = 0; i < 4; i++) {
            if (recur(r + vr[i], c + vc[i], t, h - dec, copy(v))) {
                return true;
            }
        }
        return false;
    }

    public boolean[][] copy(boolean[][] o) {
        boolean[][] out = new boolean[o.length][];
        for (int i = 0; i < o.length; i++) {
            out[i] = Arrays.copyOf(o[i], o[i].length);
        }
        return out;
    }

    public static void main(String[] args) throws Exception {
        new Nick().run();
    }
}