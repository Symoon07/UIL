package district2013_1;

import java.util.*;
import java.io.*;

public class Local {

    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/district2013_1/Local.dat".toLowerCase()));
        //Scanner f = new Scanner(System.in);

        int n = f.nextInt();
        while (n-- > 0) {
            int y = f.nextInt();
            int b = 0;
            int w = 0;
            for (int i = 0; i < 31; i++) {
                int t = f.nextInt();
                if (t <= 31) {
                    b++;
                }
                else if (t >= 50) {
                    w++;
                }
            }
            System.out.printf("%d %d %d\n", y, b, w);
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Local().run();
    }

}