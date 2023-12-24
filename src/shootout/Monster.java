package shootout;

import java.util.*;
import java.io.*;

public class Monster {
    
    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/shootout/Monster.dat".toLowerCase()));
        //Scanner f = new Scanner(System.in);

        int n = f.nextInt();
        while (n-- > 0) {
            int row = f.nextInt();
            int col = f.nextInt();
            int sr = 0;
            int sc = 0;
            char[][] mat = new char[row][col];
            for (int i = 0; i < row; i++) {
                String s = f.next();
                for (int j = 0; j < col; j++) {
                    if (s.charAt(j) == 'S') {
                        sr = i;
                        sc = j;
                    }
                    mat[i][j] = s.charAt(j);
                }
            }
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (mat[i][j] == 'M') {
                        for (int k = -1; k <= 1; k++) {
                            for (int l = -1; l <= 1; l++) {
                                if (i+k >= 0 && i+k < row && j+l >= 0 && j+l < col) {
                                    mat[i+k][j+l] = '0';
                                }
                            }
                        }
                    }
                }
            }
            boolean found = false;
            int[] vr = {-1, 1, 0, 0};
            int[] vc = {0, 0, -1, 1};
            Queue<Integer> q = new LinkedList<>();
            q.add(sr);
            q.add(sc);
            while (!q.isEmpty()) {
                int r = q.poll();
                int c = q.poll();
                if (r < 0 || r >= row || c < 0 || c >= col || mat[r][c] == '0') {
                    continue;
                }
                if (mat[r][c] == 'E') {
                    found = true;
                    break;
                }
                for (int i = 0; i < 4; i++) {
                    int rr = r + vr[i];
                    int cc = c + vc[i];
                    q.add(rr);
                    q.add(cc);
                }
                mat[r][c] = '0';
            }
            System.out.println(found ? "MADE IT HOMEY" : "NO LUCK");
        }

        f.close();
    }
    
    public static void main(String[] args) throws Exception {
        new Monster().run();
    }

}