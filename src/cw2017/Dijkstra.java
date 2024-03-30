package cw2017;

import java.util.*;
import java.io.*;

public class Dijkstra {

    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/cw2017/Dijkstra.dat".toLowerCase()));
        //Scanner f = new Scanner(System.in);

        int n = f.nextInt();
        while (n-- > 0) {
            int col = f.nextInt();
            int row = f.nextInt();
            int time = f.nextInt();
            int sr = 0;
            int sc = 0;
            char[][] mat = new char[row][col];
            for (int i = 0; i < mat.length; i++) {
                String s = f.next();
                for (int j = 0; j < col; j++) {
                    if (s.charAt(j) == 'S') {
                        sr = i;
                        sc = j;
                    }
                    mat[i][j] = s.charAt(j);
                }
            }
            int[] vr = {-1, 1, 0, 0};
            int[] vc = {0, 0, -1, 1};
            int found = Integer.MAX_VALUE;
            Queue<Integer> q = new LinkedList<>();
            q.add(sr);
            q.add(sc);
            q.add(0);
            while (!q.isEmpty()) {
                int r = q.poll();
                int c = q.poll();
                int t = q.poll();
                if (r < 0 || r >= row || c < 0 || c >= col || mat[r][c] == 'W' || mat[r][c] == 'w') {
                    continue;
                }
                if (mat[r][c] == 'E') {
                    found = t * 3;
                    break;
                }
                for (int i = 0; i < 4; i++) {
                    int rr = r + vr[i];
                    int cc = c + vc[i];
                    q.add(rr);
                    q.add(cc);
                    q.add(t+1);
                }
                mat[r][c] = 'W';
            }
            System.out.println(found <= time ? "He escaped in " + found + " minutes." : "All hail Lord Dijkstra!");
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Dijkstra().run();
    }

}