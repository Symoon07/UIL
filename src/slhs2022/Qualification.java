package slhs2022;

import java.util.*;
import java.io.*;

public class Qualification {

    public void run() throws Exception {
        Scanner f = new Scanner(new File("data/slhs2022/Qualification.dat".toLowerCase()));
        //Scanner f = new Scanner(System.in);

        int n = f.nextInt(); f.nextLine();
        while (n-- > 0) {
            int row = f.nextInt();
            int col = f.nextInt();
            int minS = f.nextInt(); f.nextLine();
            int size = 0;
            int[][] mat = new int[row][col];
            for (int i = 0; i < mat.length; i++) {
                String[] line = f.nextLine().split(" ");
                System.out.println(Arrays.toString(line));
                for (int j = 0; j < mat.length; j++) {
                    mat[i][j] = Integer.parseInt(line[j]);
                }
            }
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Qualification().run();
    }

}