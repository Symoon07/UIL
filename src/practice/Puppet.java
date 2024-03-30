package practice;

import java.util.*;
import java.io.*;

public class Puppet {
    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/practice/Puppet.dat".toLowerCase()));
        //Scanner f = new Scanner(System.in);

        int cases = f.nextInt();
        while (cases-- > 0) {
            f.nextLine();
            int sr = 0;
            int sc = 0;
            int jt = 0;
            int ft = 0;
            char[][] mat = new char[10][10];
            for (int i = 0; i < 10; i++) {
                mat[i] = f.nextLine().toCharArray();
                for (int j = 0; j < 10; j++) {
                    if (mat[i][j] == 'S') {
                        sr = i;
                        sc = j;
                    }
                }
            }
            int[] vr = {-1, 1, 0, 0};
            int[] vc = {0, 0, -1, 1};
            Queue<Integer> q = new LinkedList<>();
            q.add(sr);
            q.add(sc);
            q.add(0);
            while (!q.isEmpty()) {
                int r = q.poll();
                int c = q.poll();
                int t = q.poll();
                if (r < 0 || r >= 10 || c < 0 || c >= 10 || mat[r][c] == 'H') {
                    continue;
                }
                if (mat[r][c] == 'J') {
                    jt = t;
                }
                if (mat[r][c] == 'F') {
                    ft = t;
                }
                for (int i = 0; i < 4; i++) {
                    int rr = r + vr[i];
                    int cc = c + vc[i];
                    q.add(rr);
                    q.add(cc);
                    q.add(t+1);
                }
                mat[r][c] = 'H';
            }
            System.out.println(ft < jt ? "Nathan saved the child." : "The spirits feast on blood.");
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Puppet().run();
    }

}