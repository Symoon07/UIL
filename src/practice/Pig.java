package practice;

import java.io.*;
import java.util.*;

public class Pig {
    char[][] mat;
    int[][] shadow;
    int time;

    public void recur(int r, int c, int steps) {
        if (r < mat.length && r >= 0 && c < mat[r].length && c >= 0 && mat[r][c] != 'R' && steps < shadow[r][c]) {
            shadow[r][c] = steps;
            if (mat[r][c] == 'H') {
                time = shadow[r][c];
                return;
            }
            mat[r][c] = 'R';

            recur(r - 1, c, steps + 1);
            recur(r + 1, c, steps + 1);
            recur(r, c - 1, steps + 1);
            recur(r, c + 1, steps + 1);
            mat[r][c] = '.';
        }
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/Input/pig.dat"));
        //Scanner f = new Scanner(System.in);

        int cases = f.nextInt();
        while (cases-- > 0) {

            time = -1;
            int r = f.nextInt();
            int c = f.nextInt();
            mat = new char[r][c];
            shadow = new int[r][c];
            for (int i = 0; i < mat.length; i++) {
                mat[i] = f.next().toCharArray();
                Arrays.fill(shadow[i], Integer.MAX_VALUE);
            }

            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if (mat[i][j] == 'D') {
                        recur(i, j, 0);
                        System.out.println(time != -1 && time <= 7 ? "BACON" : "PIG ON THE RUN");
                    }
                }
            }

        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Pig().run();
    }

}