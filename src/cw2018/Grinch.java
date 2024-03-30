package cw2018;

import java.io.*;
import java.util.*;

public class Grinch {
    char[][] mat;
    int[][] shadow;
    int time;
    int found;

    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/cw2018/grinch.dat"));
        //Scanner f = new Scanner(System.in);

        int cases = f.nextInt();
        while (cases-- > 0) {

            int rows = f.nextInt();
            int cols = f.nextInt();
            int t = f.nextInt();
            int sr = 0;
            int sc = 0;
            mat = new char[rows][cols];
            for (int i = 0; i < rows; i++) {
                String s = f.next();
                for (int j = 0; j < cols; j++) {
                    if (s.charAt(j) == 'R') {
                        sr = i;
                        sc = j;
                    }
                    mat[i][j] = s.charAt(j);
                }
            }

            time = 0;
            found = 0;
            int[] vr = {-1, 1, 0, 0};
            int[] vc = {0, 0, -1, 1};
            for (int i = 0; i < t; i++) {

                Queue<Integer> q = new LinkedList<>();
                shadow = new int[rows][cols];
                q.add(sr);
                q.add(sc);
                q.add(0);
                while (!q.isEmpty()) {
                    int r = q.poll();
                    int c = q.poll();
                    int steps = q.poll();
                    if (r < 0 || r >= rows || c < 0 || c >= cols || mat[r][c] == '#' || shadow[r][c] == 1) continue;

                    if (mat[r][c] == 'T') {
                        if (i < t-1) {
                            time += steps * 2;
                        }
                        else {
                            time += steps;
                        }
                        found++;
                        mat[r][c] = '.';
                        break;
                    }

                    for (int j = 0; j < 4; j++) {
                        int nr = r + vr[j];
                        int nc = c + vc[j];
                        q.add(nr);
                        q.add(nc);
                        q.add(steps + 1);
                    }
                    shadow[r][c] = 1;
                }
            }

            System.out.println(found == t ? time : "Get Grinched!");

        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Grinch().run();
    }

}