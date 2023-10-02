package cw2016;

import java.util.*;
import java.io.*;

public class Nick {
    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/cw2016/Nick.dat".toLowerCase()));
        //Scanner f = new Scanner(System.in);

        int cases = f.nextInt();
        f.nextLine();
        while (cases-- > 0) {
            int row = f.nextInt();
            int d = f.nextInt();
            int t = f.nextInt();
            int s = f.nextInt();
            int sr = 0;
            int sc = 0;
            f.nextLine();
            char[][] mat = new char[row][];
            for (int i = 0; i < row; i++) {
                mat[i] = f.nextLine().toCharArray();
                for (int j = 0; j < mat[i].length; j++) {
                    if (mat[i][j] == 'S') {
                        sr = i;
                        sc = j;
                    }
                }
            }
            boolean alive = false;
            int[] vr = {-1, 1, 0, 0};
            int[] vc = {0, 0, -1, 1};
            Queue<Integer> q = new LinkedList<>();
            q.add(sr);
            q.add(sc);
            q.add(s);
            while (!q.isEmpty()) {
                int r = q.poll();
                int c = q.poll();
                int cur = q.poll();
                if (r < 0 || r >= row || c < 0 || c >= mat[r].length || mat[r][c] == '@' || cur < 0) {
                    continue;
                }
                if (mat[r][c] == 'H') {
                    alive = true;
                    break;
                }
                if (mat[r][c] == 'T') {
                    cur += t;
                }
                for (int i = 0; i < 4; i++) {
                    int rr = r + vr[i];
                    int cc = c + vc[i];
                    q.add(rr);
                    q.add(cc);
                    q.add(cur-d);
                }
                mat[r][c] = '@';
            }
            System.out.println(alive ? "STILL ALIVE" : "RIP IN PEPRI");
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Nick().run();
    }

}