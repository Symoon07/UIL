package waller2023;

import java.util.*;
import java.io.*;

public class Gary {

    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/waller2023/Gary.dat"));
        //Scanner f = new Scanner(System.in);

        int t = f.nextInt(); f.nextLine();
        while (t --> 0) {
            int row = f.nextInt();
            int col = f.nextInt();
            int k = f.nextInt();
            int T = f.nextInt(); f.nextLine();
            int sr = 0;
            int sc = 0;
            char[][] mat = new char[row][col];
            for (int i = 0; i < row; i++) {
                mat[i] = f.nextLine().toCharArray();
                for (int j = 0; j < col; j++) {
                    if (mat[i][j] == 'G') {
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
            q.add(1);
            q.add(0);
            int found = -1;
            while (!q.isEmpty()) {
                int r = q.poll();
                int c = q.poll();
                int cd = q.poll();
                int time = q.poll();
                if (r < 0 || r >= row || c < 0 || c >= col || time > T || mat[r][c] == '#') {
                    continue;
                }
                if (mat[r][c] == 'C') {
                    found = time;
                    break;
                }
                for (int i = 0; i < 4; i++) {
                    int rr = r + vr[i];
                    int cc = c + vc[i];
                    if (cd == 1 && rr >= 0 && rr < row && cc >= 0 && cc < col && mat[rr][cc] != '#') {
                        q.add(r + vr[i] * 2);
                        q.add(c + vc[i] * 2);
                        q.add(k);
                        q.add(time + 1);
                    }
                    q.add(rr);
                    q.add(cc);
                    q.add(cd - 1);
                    q.add(time + 1);
                }
                mat[r][c] = '#';
            }

            System.out.println(found == -1 ? "Cat :(" : "Dashing!");
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Gary().run();
    }

}