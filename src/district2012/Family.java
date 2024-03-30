package district2012;

import java.util.*;
import java.io.*;

public class Family {

    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/district2012/Family.dat".toLowerCase()));
        //Scanner f = new Scanner(System.in);

        int cases = f.nextInt();
        while (cases-- > 0) {
            f.nextLine();
            char[][] mat = new char[18][12];
            for (int i = 0; i < 18; i++) {
                mat[i] = f.nextLine().toCharArray();
            }
            char[][] out = new char[12][18];
            int r = 17;
            int c = 0;
            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 18; j++) {
                    out[i][j] = mat[r][c];
                    r--;
                }
                r = 17;
                c++;
            }
            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 18; j++) {
                    System.out.print(out[i][j]);
                }
                System.out.println();
            }
            System.out.println();
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Family().run();
    }

}