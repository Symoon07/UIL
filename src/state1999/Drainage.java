package state1999;

import java.util.*;
import java.io.*;

public class Drainage {
    public boolean check(int[][] mat, int r, int c) {
        int[] vr = {0, 1, 1, 1, 0, -1, -1, -1};
        int[] vc = {-1, -1, 0, 1, 1, 1, 0, -1};
        for (int i = 0; i < 8; i++) {
            int rr = r + vr[i];
            int cc = c + vc[i];
            if (mat[rr][cc] < mat[r][c] || rr < 0 || rr >= 10 || cc < 0 || cc >= 20) {
                return true;
            }
        }
        return false;
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/state1999/drainage.dat"));
        //Scanner f = new Scanner(System.in);

        while (f.hasNext()) {
            String name = f.nextLine();
            int[][] mat = new int[10][20];
            for (int i = 0; i < 10; i++) {
                String s = f.nextLine();
                for (int j = 0; j < 20; j++) {
                    mat[i][j] = Integer.parseInt(s.substring(j,j+1));
                }
            }
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 20; j++) {
                    int[][] shadow = new int[10][20];
                    Queue<Integer> q = new LinkedList<>();
                    q.add(i);
                    q.add(j);
                    while (!q.isEmpty()) {
                        int r = q.poll();
                        int c = q.poll();
                        if (r < 0 || r >= 10 || c < 0 || c >= 20 || mat[r][c] != mat[i][j]) {
                            continue;
                        }
                        shadow[r][c] = 1;

                    }
                }
            }
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Drainage().run();
    }

}