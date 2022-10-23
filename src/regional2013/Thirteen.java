package regional2013;

import java.util.*;
import java.io.*;

public class Thirteen {

    char[][] mat;
    int[][][] shadow;
    int[][] jewels;
    int total = 0, mask = 0;

    public void recur(int r, int c, int steps, int mask) {
        if (r < mat.length && r >= 0 && c < mat[r].length && c >= 0 && mat[r][c] != '#' && steps < shadow[r][c][mask]) {
            shadow[r][c][mask] = steps;

            if (jewels[r][c] != 0)
                mask += 1 << jewels[r][c];

            if (mat[r][c] == 'E' && mask == (1 << 13) -1) {
                total = shadow[r][c][mask];
                return;
            }
            mat[r][c] = '#';

            recur(r -1, c, steps + 1, mask);
            recur(r + 1, c, steps + 1, mask);
            recur(r, c - 1, steps +1 , mask);
            recur(r, c + 1, steps + 1, mask);
            mat[r][c] = '.';

        }
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/Input/thirteen.dat"));
        //Scanner f = new Scanner(System.in);

        int cases = f.nextInt();
        while (cases-- > 0) {

            mat = new char[10][10];
            for (int i = 0; i < mat.length; i++) {
                mat[i] = f.next().toCharArray();
            }
            jewels = new int[10][10];
            int nameJewel = 1;
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    if (mat[i][j] == '*') jewels[i][j] = nameJewel++;
                }
            }
            shadow = new int[10][10][1 << 13];
            for (int[][] ints : shadow) {
                for (int[] anInt : ints) {
                    Arrays.fill(anInt, Integer.MAX_VALUE);
                }
            }

            recur(0, 0, 0, mask);

        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Thirteen().run();
    }

}