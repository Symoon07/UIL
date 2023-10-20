package district2013_2;

import java.util.*;
import java.io.*;

public class EagleNests {

    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/district2013_2/EagleNests.dat".toLowerCase()));
        //Scanner f = new Scanner(System.in);

        int n = f.nextInt();
        while (n-- > 0) {
            char[][] mat = new char[10][10];
            for (int i = 0; i < 10; i++) {
                mat[i] = f.next().toCharArray();
            }
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    if (mat[i][j] == 'E') {
                        System.out.println((i + 1) + " " + (j + 1));
                    }
                }
            }
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new EagleNests().run();
    }

}