package practice;

import java.io.*;
import java.util.*;

public class Maze_Lab1 {
    char[][] mat;
    boolean found;

    public void recur(int r, int c) {
        if (r < mat.length && r >= 0 && c < mat[r].length && c >= 0 && mat[r][c] != '0') {

            if (mat[r][c] == 'E') {
                found = true;
                return;
            }
            mat[r][c] = '0';

            recur(r - 1, c);
            recur(r + 1, c);
            recur(r, c - 1);
            recur(r, c + 1);

        }
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/Input/maze_lab1.dat"));
        //Scanner f = new Scanner(System.in);

        int cases = f.nextInt();
        while (cases-- > 0) {

            mat = new char[10][10];
            for (int i = 0; i < 10; i++) {
                mat[i] = f.next().toCharArray();
            }

            for (int i = 0; i < mat.length; i++) {
                for (int j = 0; j < mat[i].length; j++) {
                    if (mat[i][j] == 'S') {
                        found = false;
                        recur(i, j);
                        System.out.println(found ? "FOUND" : "NOT FOUND");
                    }
                }
            }

        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Maze_Lab1().run();
    }

}