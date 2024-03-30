package district2012;

import java.util.*;
import java.io.*;

public class Runners {
    public boolean judge(char[][] mat, int r, int c) {
        int[] vr = {-1, 1, 0, 0};
        int[] vc = {0, 0, -1, 1};
        for (int i = 0; i < 4; i++) {
            int rr = r + vr[i];
            int cc = c + vc[i];
            if (rr >= 0 && rr < mat.length && cc >= 0 && cc < mat[rr].length && mat[rr][cc] == 'P') {
                return true;
            }
        }
        return false;
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/district2012/Runners.dat".toLowerCase()));
        //Scanner f = new Scanner(System.in);

        int cases = f.nextInt();
        while (cases-- > 0) {
            int row = f.nextInt();
            int col = f.nextInt();
            char[][] mat = new char[row][col];
            HashMap<String, String> starts = new HashMap<>();
            for (int i = 0; i < row; i++) {
                String s = f.next();
                for (int j = 0; j < col; j++) {
                    mat[i][j] = s.charAt(j);
                    if (mat[i][j] == 'R') {
                        starts.put("RUSSELL", i + ""+  j);
                    }
                    if (mat[i][j] == 'S') {
                        starts.put("SETH", i + ""+  j);
                    }
                    if (mat[i][j] == 'T') {
                        starts.put("THOMAS", i + ""+  j);
                    }
                }
            }
            int[] vr = {-1, 1, 0, 0};
            int[] vc = {0, 0, -1, 1};
            for (String name : starts.keySet()) {
                int sr = Integer.parseInt(starts.get(name).substring(0,1));
                int sc = Integer.parseInt(starts.get(name).substring(1,2));
                int[][] shadow = new int[row][col];
                for (int[] ints : shadow) {
                    Arrays.fill(ints, Integer.MAX_VALUE);
                }
                Queue<Integer> q = new LinkedList<>();
                mat[sr][sc] = '.';
                q.add(sr);
                q.add(sc);
                q.add(0);
                while (!q.isEmpty()) {
                    int r = q.poll();
                    int c = q.poll();
                    int s = q.poll();
                    if (r < 0 || r >= row || c < 0 || c >= col || !(mat[r][c] == '.' || mat[r][c] == 'J') || s > shadow[r][c]) {
                        continue;
                    }
                    shadow[r][c] = s;
                    for (int i = 0; i < 4; i++) {
                        int rr = r + vr[i];
                        int cc = c + vc[i];
                        q.add(rr);
                        q.add(cc);
                        q.add(s+1);
                    }
                }
                mat[sr][sc] = 'S';
                for (int i = 0; i < row; i++) {
                    for (int j = 0; j < col; j++) {
                        if (shadow[i][j] == Integer.MAX_VALUE) {
                            System.out.print(-1 + " ");
                        }
                        else {
                            System.out.print(shadow[i][j] + " ");
                        }
                    }
                    System.out.println();
                }
                System.out.println();
            }
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Runners().run();
    }

}