package slhs2019;

import java.util.*;
import java.io.*;

public class Mining {
    char[][] mat;
    boolean found;

    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/Input/mining.dat"));
        //Scanner f = new Scanner(System.in);

        int cases = f.nextInt();
        while (cases-- > 0) {

            int rows = f.nextInt();
            int cols = f.nextInt();
            int torches = f.nextInt();
            int sr = 0;
            int sc = 0;
            f.nextLine();
            mat = new char[rows][cols];
            for (int i = 0; i < mat.length; i++) {
                String s = f.nextLine();
                for (int j = 0; j < mat[i].length; j++) {
                    if (s.charAt(j) == 'S') {
                        sr = i;
                        sc = j;
                    }
                    mat[i][j] = s.charAt(j);
                }
            }

            found = false;
            int[] vr = {-1, 1, 0, 0};
            int[] vc = {0, 0, -1, 1};
            Queue<Integer> q = new LinkedList<>();
            q.add(sr); q.add(sc); q.add(0);
            while (!q.isEmpty()) {
                int r = q.poll();
                int c = q.poll();
                int steps = q.poll();
                if (r < 0 || r >= rows || c < 0 || c >= cols || mat[r][c] == '#' || steps > torches * 6) continue;

                if (mat[r][c] == 'E') {
                    found = true;
                    break;
                }

                for (int i = 0; i < 4; i++) {
                    int rr = r + vr[i];
                    int cc = c + vc[i];
                    q.add(rr);
                    q.add(cc);
                    q.add(steps + 1);
                }
                mat[r][c] = '#';
            }

            System.out.println(found ? "Take Back The Night!" : "Don't Mine At Night!");

        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Mining().run();
    }

}