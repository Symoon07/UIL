package state2020;

import java.util.*;
import java.io.*;

public class Steeds {

    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/state2020/Steeds.dat".toLowerCase()));
        //Scanner f = new Scanner(System.in);

        int t = f.nextInt();
        while (t --> 0) {
            int n = f.nextInt();
            int h = 0;
            int p = 0;
            while (n --> 0) {
                int m = f.nextInt();
                String s = f.next();
                if (s.equals("horse")) {
                    p += m;
                    h++;
                }
            }
            System.out.println(h + " " + p);
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Steeds().run();
    }

}