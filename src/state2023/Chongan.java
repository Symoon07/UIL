package state2023;

import java.util.*;
import java.io.*;

public class Chongan {

    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/state2023/Chongan.dat".toLowerCase()));
        //Scanner f = new Scanner(System.in);

        int cases = f.nextInt();
        while (cases-- > 0) {
            String out = "";
            int max = 0;
            for (int i = 0; i < 6; i++) {
                String c = f.next();
                int n = f.nextInt();
                if (n > max) {
                    max = n;
                    out = c;
                }
            }
            System.out.println(out);
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Chongan().run();
    }

}