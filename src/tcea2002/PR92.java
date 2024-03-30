package tcea2002;

import java.util.*;
import java.io.*;

public class PR92 {
    char[][] mat;
    boolean[][] visited;
    String dir;
    String out;

    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/tcea2002/PR92.dat".toLowerCase()));
        //Scanner f = new Scanner(System.in);

        int n = f.nextInt();
        while (n-- > 0) {
            String s = f.next();
            dir = s.substring(0, 1);
            s = s.substring(1);
            int dim = (int) Math.sqrt(s.length());
            mat = new char[dim][dim];
            visited = new boolean[dim][dim];
            out = "";
            for (int i = 0; i < dim; i++) {
                for (int j = 0; j < dim; j++) {
                    mat[i][j] = i * dim + j < s.length() ? s.charAt(i * dim + j) : ' ';
                }
            }
            if (dir.equals("R")) {
                go(0, 0, 0, 1);
            }
            else {
                go(0, 0, 1, 0);
            }
            System.out.println(out);
        }

        f.close();
    }

    public void go (int r, int c, int rv, int cv) {
        if (r < 0 || r >= mat.length || c < 0 || c >= mat.length || visited[r][c]) {
            return;
        }
        visited[r][c] = true;
        out += mat[r][c];
        if (r+rv < 0 || r+rv >= mat.length || c+cv < 0 || c+cv >= mat.length || visited[r+rv][c+cv]) {
            if (dir.equals("R")) {
                go(r, c+1, 0, 1); //right
                go(r+1, c, 1, 0); //down
                go(r, c-1, 0, -1); //left
                go(r-1, c, -1, 0); //up
            }
            else {
                go(r+1, c, 1, 0); //down
                go(r, c+1, 0, 1); //right
                go(r-1, c, -1, 0); //up
                go(r, c-1, 0, -1); //left
            }
        }
        else {
            go(r+rv, c+cv, rv, cv);
        }
    }

    public static void main(String[] args) throws Exception {
        new PR92().run();
    }

}