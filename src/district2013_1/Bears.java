package district2013_1;

import java.util.*;
import java.io.*;

public class Bears {

    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/district2013_1/Bears.dat".toLowerCase()));
        //Scanner f = new Scanner(System.in);

        int n = f.nextInt();
        while (n-- > 0) {
            int out = 0;
            for (int i = 0; i < 10; i++) {
                String s = f.next();
                for (int j = 0; j < 10; j++) {
                    if (s.charAt(j) == 'B') {
                        out++;
                    }
                }
            }
            System.out.println(out);
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Bears().run();
    }

}