package cw2014;

import java.util.*;
import java.io.*;

public class Rescue {

    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/cw2014/Rescue.dat".toLowerCase()));
        //Scanner f = new Scanner(System.in);

        int n = f.nextInt();
        for (int m = 1; m <= n; m++) {
            int row = f.nextInt();
            int col = f.nextInt();
            int len = f.nextInt();
            int sl = -1;
            int sr = -1;
            int sc = -1;
            char[][][] mat = new char[len][row][col];
            for (int i = 0; i < len; i++) {
                for (int j = 0; j < row; j++) {
                    String s = f.next();
                    for (int k = 0; k < col; k++) {
                        mat[i][j][k] = s.charAt(k);
                        if (mat[i][j][k] == 'S') {
                            sl = i;
                            sr = j;
                            sc = k;
                        }
                    }
                }
            }
            int[] vl = {-1, 1, 0, 0, 0, 0};
            int[] vr = {0, 0, -1, 1, 0, 0};
            int[] vc = {0, 0, 0, 0, -1, 1};
            Queue<Integer> q = new LinkedList<>();
            int out = -1;
            q.add(sl);
            q.add(sr);
            q.add(sc);
            q.add(0);
            while (!q.isEmpty()) {
                int l = q.poll();
                int r = q.poll();
                int c = q.poll();
                int t = q.poll();
                if (l < 0 || l >= len || r < 0 || r >= row || c < 0 || c >= col || mat[l][r][c] == '#') {
                    continue;
                }
                if (mat[l][r][c] == 'E') {
                    out = t;
                    break;
                }
                for (int i = 0; i < 6; i++) {
                    q.add(l + vl[i]);
                    q.add(r + vr[i]);
                    q.add(c + vc[i]);
                    q.add(t+1);
                }
                mat[l][r][c] = '#';
            }
            System.out.println(out == -1 ? "Rescue #" + m + ": NO" : "Rescue #" + m + ": " + out);
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Rescue().run();
    }

}