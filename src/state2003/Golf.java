package state2003;

import java.util.*;
import java.io.*;

public class Golf {
    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/state2003/Golf.dat".toLowerCase()));
        //Scanner f = new Scanner(System.in);

        while (f.hasNext()) {
            int col = f.nextInt();
            int row = f.nextInt();
            int par = f.nextInt();
            int sr = 0;
            int sc = 0;
            char[][] mat = new char[row][col];
            for (int i = 0; i < row; i++) {
                String temp = f.next();
                for (int j = 0; j < col; j++) {
                    mat[i][j] = temp.charAt(j);
                    if (mat[i][j] == '*') {
                        sr = i;
                        sc = j;
                    }
                }
            }
            int[] vr = {0, 0, -1, 1};
            int[] vc = {-1, 1, 0, 0};
            int strokes = 0;
            Queue<Integer> q = new LinkedList<>();
            q.add(sr);
            q.add(sc);
            q.add(0);
            while (!q.isEmpty()) {
                int r = q.poll();
                int c = q.poll();
                int s = q.poll();
                if (r < 0 || r >= row || c < 0 || c >= col || mat[r][c] == 'T') {
                    continue;
                }
                if (mat[r][c] == 'O') {
                    strokes = s;
                    break;
                }
                for (int i = 0; i < 4; i++) {
                    int rr = r + vr[i];
                    int cc = c + vc[i];
                    q.add(rr);
                    q.add(cc);
                    q.add(s+1);
                    rr = r + (vr[i] * 3);
                    cc = c + (vc[i] * 3);
                    q.add(rr);
                    q.add(cc);
                    q.add(s+1);
                    rr = r + (vr[i] * 5);
                    cc = c + (vc[i] * 5);
                    q.add(rr);
                    q.add(cc);
                    q.add(s+1);
                    rr = r + (vr[i] * 10);
                    cc = c + (vc[i] * 10);
                    q.add(rr);
                    q.add(cc);
                    q.add(s+1);
                }
                mat[r][c] = 'T';
            }
            int score = par - strokes;
            switch (score) {
                case 2 -> System.out.println("Eagle");
                case 1 -> System.out.println("Birdie");
                case 0 -> System.out.println("Par");
                case -1 -> System.out.println("Bogey");
                case -2 -> System.out.println("Double Bogey");
            }
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Golf().run();
    }

}