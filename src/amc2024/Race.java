package amc2024;

import java.util.*;
import java.io.*;

public class Race {
    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/amc2024/Race.dat"));
        //Scanner f = new Scanner(System.in);

        int t = f.nextInt();
        while (t --> 0) {
            int col = f.nextInt(), row = f.nextInt();
            char[][] mat = new char[row][col];
            for (int i = 0; i < row; i++) {
                mat[i] = f.next().toCharArray();
            }
            boolean found = false;
            for (int i = 0; i < row; i++) {
                if (mat[i][0] == '#' || mat[i][col - 1] == '#') {
                    found = true;
                    break;
                }
            }
            for (int i = 0; i < col; i++) {
                if (mat[0][i] == '#' || mat[row - 1][i] == '#') {
                    found = true;
                    break;
                }
            }
            System.out.println(found ? "OUTSTANDING. I can escape from my predicament" : "OH NO. I am very stuck and must call for help");
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Race().run();
    }
}