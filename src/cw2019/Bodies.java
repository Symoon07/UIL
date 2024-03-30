package cw2019;

import java.util.*;
import java.io.*;

public class Bodies {
    char[][] mat;
    boolean found;

    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/cw2019/bodies.dat"));
        //Scanner f = new Scanner(System.in);

        int cases = f.nextInt();
        while (cases-- > 0) {
            
            int rows = f.nextInt();
            int cols = f.nextInt();
            int sr = 0;
            int sc = 0;
            mat = new char[rows][cols];
            for (int i = 0; i < rows; i++) {
                mat[i] = f.next().toCharArray();
                for (int j = 0; j < cols; j++) {
                    if (mat[i][j] == 'T') {
                        sr = i;
                        sc = j;
                    }
                }
            }

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (mat[i][j] == 'P') {
                        for (int k = -1; k <= 1; k++) {
                            for (int l = -1; l <= 1; l++) {
                                if (i+k >= 0 && i+k < rows && j+l >= 0 && j+l < cols && mat[i+k][j+l] != 'P') {
                                    mat[i+k][j+l] = '#';
                                }
                            }
                        }
                    }
                }
            }

            found = false;
            int[] vr = {-1, 1, 0, 0};
            int[] vc = {0, 0, -1, 1};
            Queue<Integer> q = new LinkedList<>();
            q.add(sr);
            q.add(sc);
            while (!q.isEmpty()) {
                int r = q.poll();
                int c = q.poll();
                if (r < 0 || r >= rows || c < 0 || c >= cols || mat[r][c] == '#' || mat[r][c] == 'P') continue;

                if (mat[r][c] == 'S') {
                    found = true;
                    break;
                }

                for (int i = 0; i < 4; i++) {
                    int rr = r + vr[i];
                    int cc = c + vc[i];
                    q.add(rr);
                    q.add(cc);
                }
                mat[r][c] = '#';
            }

            System.out.println(found ? "Bravo Six Going Dark... at the end of the tunnel is a light." : "Bravo Six Going Dark... Mission Failed. We'll get em next time");
            
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Bodies().run();
    }

}