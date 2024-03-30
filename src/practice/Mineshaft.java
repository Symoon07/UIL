package practice;

import java.util.*;
import java.io.*;

public class Mineshaft {
    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/practice/Mineshaft.dat".toLowerCase()));
        //Scanner f = new Scanner(System.in);

        int cases = f.nextInt();
        while (cases-- > 0) {
            int floors = f.nextInt();
            int rows = f.nextInt();
            int cols = f.nextInt();
            int dur = f.nextInt();
            int sf = 0;
            int sr = 0;
            int sc = 0;
            int time = -1;
            char[][][] mat = new char[floors][rows][cols];
            for (int i = 0; i < floors; i++) {
                for (int j = 0; j < rows; j++) {
                    String s = f.next();
                    for (int k = 0; k < cols; k++) {
                        mat[i][j][k] = s.charAt(k);
                        if (mat[i][j][k] == 'S') {
                            sf = i;
                            sr = j;
                            sc = k;
                        }
                    }
                }
            }
            int[] vf = {0, 0, 0, 0, -1, 1};
            int[] vr = {-1, 1, 0, 0, 0, 0};
            int[] vc = {0, 0, -1, 1, 0, 0};
            Queue<Integer> q = new LinkedList<>();
            q.add(sf);
            q.add(sr);
            q.add(sc);
            q.add(dur);
            q.add(0);
            while (!q.isEmpty()) {
                int fl = q.poll();
                int r = q.poll();
                int c = q.poll();
                int d = q.poll();
                int t = q.poll();
                if (fl < 0 || fl >= floors || r < 0 || r >= rows || c < 0 || c >= cols || mat[fl][r][c] == '#' || (d == 0 && mat[fl][r][c] == '%')) {
                    continue;
                }
                if (mat[fl][r][c] == 'E') {
                    time = t;
                    break;
                }
                if (mat[fl][r][c] == '%') {
                    d--;
                    t += 3;
                }
                for (int i = 0; i < 6; i++) {
                    int ff = fl + vf[i];
                    int rr = r + vr[i];
                    int cc = c + vc[i];
                    q.add(ff);
                    q.add(rr);
                    q.add(cc);
                    q.add(d);
                    if (i == 5) {
                        q.add(t+2);
                    }
                    else if (i == 4) {
                        q.add(t+3);
                    }
                    else {
                        q.add(t+1);
                    }
                }
                mat[fl][r][c] = '#';
            }
            System.out.println(time == -1 ? "DEAD" : time +" SECONDS");
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Mineshaft().run();
    }

}