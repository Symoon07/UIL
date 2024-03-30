package shootout;

import java.util.*;
import java.io.*;

public class AngryBirds {

    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/shootout/AngryBirds.dat".toLowerCase()));
        //Scanner f = new Scanner(System.in);

        int n = f.nextInt();
        while (n --> 0) {
            int row = f.nextInt();
            int col = f.nextInt();
            int all = 0;
            int left = 0;
            char[][] mat = new char[row][col];
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    mat[i][j] = f.next().charAt(0);
                    if (mat[i][j] == 'x') {
                        all++;
                    }
                }
            }
            for (int i = 0; i < row; i++) {
                col : for (int j = 0; j < col; j++) {
                    if (mat[i][j] == 'o') {
                        for (int k = j+1; k < col; k++) {
                            if (mat[i][k] == 'x') {
                                mat[i][j] = '-';
                                mat[i][k] = 'o';
                                break col;
                            }
                            else if (mat[i][k] == 'o') {
                                boolean hit = false;
                                for (int l = k; l < col; l++) {
                                    if (mat[i][l] == 'x') {
                                        hit = true;
                                    }
                                    mat[i][l] = '-';
                                }
                                if (hit) {
                                    mat[i][col-1] = 'o';
                                }
                                mat[i][j] = '-';
                                break col;
                            }
                            else if (k == col -1) {
                                mat[i][j] = '-';
                                mat[i][k] = 'o';
                                break col;
                            }
                        }
                    }
                }
            }
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (mat[i][j] == 'x') {
                        left++;
                    }
                }
            }
            System.out.println("Number of Pigs = " + all);
            System.out.println("Number of Pigs Killed = " + (all - left));
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    System.out.print(mat[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new AngryBirds().run();
    }

}