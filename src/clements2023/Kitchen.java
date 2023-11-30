package clements2023;

import java.util.*;
import java.io.*;

public class Kitchen {

    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/clements2023/Kitchen.dat"));
        //Scanner f = new Scanner(System.in);

        int n = f.nextInt();
        while (n --> 0) {
            int row = f.nextInt();
            int col = f.nextInt();
            int sr = -1;
            int sc = -1;
            char[][] mat = new char[row][col];
            for (int i = 0; i < row; i++) {
                String s = f.next();
                mat[i] = s.toCharArray();
                if (s.contains("S")) {
                    sr = i;
                    sc = s.indexOf("S");
                }
            }
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (mat[i][j] == 'G') {
                        for (int k = i-2; k <= i+2; k++) {
                            for (int l = j-2; l <= j+2; l++) {
                                if (k >= 0 && k < row && l >= 0 && l < col && mat[k][l] != 'G') {
                                    mat[k][l] = '#';
                                }
                            }
                        }
                    }
                }
            }

            boolean found = false;
            if (sr != -1) {
                int[] vr = {-1, 1, 0, 0};
                int[] vc = {0, 0, -1, 1};
                Queue<Integer> q = new LinkedList<>();
                q.add(sr);
                q.add(sc);
                while (!q.isEmpty()) {
                    int r = q.poll();
                    int c = q.poll();
                    if (r < 0 || r >= row || c < 0 || c >= col || mat[r][c] == '#' || mat[r][c] == 'G') {
                        continue;
                    }
                    if (mat[r][c] == 'O') {
                        found = true;
                        break;
                    }
                    for (int i = 0; i < 4; i++) {
                        q.add(r + vr[i]);
                        q.add(c + vc[i]);
                    }
                    mat[r][c] = '#';
                }
            }
            System.out.println(found ? "Very good chef." : "Don't bother showing up.");
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Kitchen().run();
    }

}