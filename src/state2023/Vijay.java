package state2023;

import java.util.*;
import java.io.*;

public class Vijay {

    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/state2023/Vijay.dat".toLowerCase()));
        //Scanner f = new Scanner(System.in);

        int cases = f.nextInt();
        while (cases-- > 0) {
            int level = f.nextInt();
            int row = f.nextInt();
            int col = f.nextInt();
            int o = f.nextInt();
            int sec = f.nextInt();
            int sl = 0;
            int sr = 0;
            int sc = 0;
            char[][][] m = new char[level][row][col];
            int[][][] shadow = new int[level][row][col];
            for (int i = 0; i < level; i++) {
                for (int j = 0; j < row; j++) {
                    String temp = f.next();
                    for (int k = 0; k < col; k++) {
                        m[i][j][k] = temp.charAt(k);
                        if (m[i][j][k] == 'S') {
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
            q.add(sl);
            q.add(sr);
            q.add(sc);
            q.add(0);
            q.add(0);
            while (!q.isEmpty()) {
                int l = q.poll();
                int r = q.poll();
                int c = q.poll();
                int cds = q.poll();
                int s = q.poll();
                if (l >= level || l < 0 || r >= row || r < 0 || c >= col || c < 0 || m[l][r][c] == '#' || s > sec || shadow[l][r][c] == 1) {
                    continue;
                }
                if (cds == o && m[l][r][c] == 'E') {
                    System.out.println(s);
                }
                if (m[l][r][c] == 'O') {
                    cds++;
                    shadow = new int[level][row][col];
                }
                for (int i = 0; i < 6; i++) {
                    int ll = l + vl[i];
                    int rr = r + vr[i];
                    int cc = c + vc[i];
                    q.add(ll);
                    q.add(rr);
                    q.add(cc);
                    q.add(cds);
                    q.add(s+1);
                }
                shadow[l][r][c] = 1;
            }
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Vijay().run();
    }

}