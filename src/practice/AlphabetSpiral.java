package practice;

import java.util.*;
import java.io.*;

public class AlphabetSpiral {
    char[][] mat;
    boolean[][] visited;
    int n;

    public void run() throws Exception {
        //Scanner f = new Scanner(new File("AlphabetSpiral.dat".toLowerCase()));
        Scanner f = new Scanner(System.in);

        String[] line = f.nextLine().split(" ");
        for (int i = 0; i < line.length-1; i++) {
            n = Integer.parseInt(line[i]);
            int dim = (int) Math.ceil(Math.sqrt(n));
            mat = new char[dim][dim];
            visited = new boolean[dim][dim];
            int sr = dim-1;
            int sc = 0;
            go(sr, sc, 0, 1, 'A');
            for (int j = 0; j < dim; j++) {
                for (int k = 0; k < dim; k++) {
                    System.out.print(mat[j][k] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }

        f.close();
    }

    public void go (int r, int c, int rv, int cv, char a) {
        if (r < 0 || r >= mat.length || c < 0 || c >= mat.length || visited[r][c]) {
            return;
        }
        mat[r][c] = (int) a < (65 + n) ? a : '*';
        visited[r][c] = true;
        if (r+rv < 0 || r+rv >= mat.length || c+cv < 0 || c+cv >= mat.length || visited[r+rv][c+cv]) {
            go(r, c+1, 0, 1, (char) (a+1)); //right
            go(r-1, c, -1, 0, (char) (a+1)); //up
            go(r, c-1, 0, -1, (char) (a+1)); //left
            go(r+1, c, 1, 0, (char) (a+1)); //down
        }
        else {
            go(r+rv, c+cv, rv, cv, (char) (a+1));
        }
    }

    public static void main(String[] args) throws Exception {
        new AlphabetSpiral().run();
    }

}