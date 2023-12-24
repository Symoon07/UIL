package state2013;

import java.util.*;
import java.io.*;

public class Eagles {
    char[][] mat;
    int moves;

    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/state2013/eagles.dat"));
        //Scanner f = new Scanner(System.in);

        int cases = f.nextInt();
        while (cases-- > 0) {

            int rows = 10;
            int cols = 10;
            int sr = f.nextInt()-1;
            int sc = f.nextInt()-1;
            mat = new char[rows][cols];
            for (int i = 0; i < rows; i++) {
                mat[i] = f.next().toCharArray();
            }

            moves = 0;
            int[] vr = {-1, 1, 0, 0, -1, -1, 1, 1};
            int[] vc = {0, 0, -1, 1, -1, 1, -1, 1};
            Queue<Integer> q = new LinkedList<>();
            q.add(sr);
            q.add(sc);
            q.add(0);
            while (!q.isEmpty()) {
                int r = q.poll();
                int c = q.poll();
                int steps = q.poll();
                if (r < 0 || r >= rows || c < 0 || c >= cols || mat[r][c] == 'B' || mat[r][c] == 'M') continue;

                if (mat[r][c] == 'E') {
                    moves = steps;
                    break;
                }

                for (int i = 0; i < 8; i++) {
                    int rr = r + vr[i];
                    int cc = c + vc[i];
                    q.add(rr);
                    q.add(cc);
                    q.add(steps + 1);
                }
                mat[r][c] = 'B';
            }

            System.out.println(moves);

        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Eagles().run();
    }

}