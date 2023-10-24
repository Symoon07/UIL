package cw2016;

import java.util.*;
import java.io.*;

public class Nick {
    char[][] mat;
    int[][] smat;
    boolean alive;
    int d;
    int t;

    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/cw2016/Nick.dat".toLowerCase()));
        //Scanner f = new Scanner(System.in);

        int cases = f.nextInt(); f.nextLine();
        while (cases-- > 0) {
            int row = f.nextInt();
            d = f.nextInt();
            t = f.nextInt();
            int s = f.nextInt();
            int sr = 0;
            int sc = 0; f.nextLine();
            mat = new char[row][];
            smat = new int[row][];
            for (int i = 0; i < row; i++) {
                mat[i] = f.nextLine().toCharArray();
                smat[i] = new int[mat[i].length];
                Arrays.fill(smat[i], Integer.MAX_VALUE);
                for (int j = 0; j < mat[i].length; j++) {
                    if (mat[i][j] == 'S') {
                        sr = i;
                        sc = j;
                    }
                }
            }
            alive = false;
            recur(sr, sc, 0, s);
            System.out.println(alive ? "STILL ALIVE" : "RIP IN PEPRI");
        }

        f.close();
    }

    public void recur(int r, int c, int steps, int cur) {
        if (r < 0 || r >= mat.length || c < 0 || c >= mat[r].length || mat[r][c] == '@' || (cur < 1 && (mat[r][c] == '.')) || (cur < 0 && (mat[r][c] == 'H' || mat[r][c] == 'T')) || steps >= smat[r][c]) {
            return;
        }
        smat[r][c] = steps;
        int[] vr = {-1, 1, 0, 0};
        int[] vc = {0, 0, -1, 1};
        if (mat[r][c] == 'H') {
            alive = true;
            return;
        }
        char save = mat[r][c];
        if (mat[r][c] == 'T') {
            for (int i = 0; i < smat.length; i++) {
                Arrays.fill(smat[i], Integer.MAX_VALUE);
            }
            mat[r][c] = '@';
            for (int i = 0; i < 4; i++) {
                recur(r + vr[i], c + vc[i], 0, cur - d + t);
            }
            mat[r][c] = save;
        }
        mat[r][c] = '@';
        for (int i = 0; i < 4; i++) {
            recur(r + vr[i], c + vc[i], steps + 1, cur - d);
        }
        mat[r][c] = save;
    }

    public static void main(String[] args) throws Exception {
        new Nick().run();
    }

}