package a2024;

import java.util.*;
import java.io.*;

public class Svetlana {

    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/a2024/Svetlana.dat".toLowerCase()));
        //Scanner f = new Scanner(System.in);

        int t = f.nextInt();
        for (int i = 1; i <= t; i++) {
            char[][] mat = new char[8][8]; f.next();
            for (int j = 0; j < 8; j++) {
                for (int k = 0; k < 8; k++) {
                    mat[j][k] = f.next().charAt(0);
                }
            }
            int red = 0;
            int black = 0;
            int[][] rv = {{1, 1}, {-1, 1}};
            int[][] bv = {{-1, -1}, {-1, 1}};
            int[][] kv = {{-1, -1, 1, 1}, {-1, 1, -1, 1}};
            for (int j = 0; j < 8; j++) {
                for (int k = 0; k < 8; k++) {
                    if (mat[j][k] != '_') {
                        switch (mat[j][k]) {
                            case 'r' -> {
                                for (int l = 0; l < 2; l++) {
                                    int r = j + rv[0][l];
                                    int c = k + rv[1][l];
                                    if (r >= 0 && r < 8 && c >= 0 && c < 8 && mat[r][c] == '_') {
                                        red++;
                                        System.out.println(r + " " + c + " " + mat[j][k]);                                    }
                                }
                            }
                            case 'b' -> {
                                for (int l = 0; l < 2; l++) {
                                    int r = j + bv[0][l];
                                    int c = k + bv[1][l];
                                    if (r >= 0 && r < 8 && c >= 0 && c < 8 && mat[r][c] == '_') {
                                        black++;
                                        System.out.println(r + " " + c + " " + mat[j][k]);                                    }
                                }
                            }
                            case 'R' -> {
                                for (int l = 0; l < 4; l++) {
                                    int r = j + kv[0][l];
                                    int c = k + kv[1][l];
                                    if (r >= 0 && r < 8 && c >= 0 && c < 8 && mat[r][c] == '_') {
                                        red++;
                                        System.out.println(r + " " + c + " " + mat[j][k]);                                    }
                                }
                            }
                            case 'B' -> {
                                for (int l = 0; l < 4; l++) {
                                    int r = j + kv[0][l];
                                    int c = k + kv[1][l];
                                    if (r >= 0 && r < 8 && c >= 0 && c < 8 && mat[r][c] == '_') {
                                        black++;
                                        System.out.println(r + " " + c + " " + mat[j][k]);
                                    }
                                }
                            }
                        }
                    }
                }
            }
            System.out.println("Test case: " + i);
            System.out.println("Red valid single moves: " + red);
            System.out.println("Black valid single moves: " + black);
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Svetlana().run();
    }

}