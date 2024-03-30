package district2013_1;

import java.util.*;
import java.io.*;

public class Squares {
    char[][] mat;
    boolean[][] visited;

    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/district2013_1/Squares.dat".toLowerCase()));
        //Scanner f = new Scanner(System.in);

        while (f.hasNext()) {
            int n = f.nextInt();
            mat = new char[n][n];
            visited = new boolean[n][n];
            for (int i = 0; i <= n / 2; i++) {
                go(i, i, 0 , 1, i % 2 == 0);
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(mat[i][j] == '*' ? mat[i][j] : " ");
                }
                System.out.println();
            }
            System.out.println();
        }

        f.close();
    }

    public void go (int r, int c, int rv, int cv, boolean mark) {
        if (r < 0 || r >= mat.length || c < 0 || c >= mat.length || visited[r][c]) {
            return;
        }
        visited[r][c] = true;
        if (mark) {
            mat[r][c] = '*';
        }
        if (r+rv < 0 || r+rv >= mat.length || c+cv < 0 || c+cv >= mat.length || visited[r+rv][c+cv]) {
            go(r+1, c, 1, 0, mark); //down
            go(r, c-1, 0, -1, mark); //left
            go(r-1, c, -1, 0, mark); //up
        }
        else {
            go(r+rv, c+cv, rv, cv, mark);
        }
    }

    public static void main(String[] args) throws Exception {
        new Squares().run();
    }

}