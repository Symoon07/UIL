package cw2017;

import java.util.*;
import java.io.*;

public class Jedi {

    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/cw2017/Jedi.dat".toLowerCase()));
        //Scanner f = new Scanner(System.in);

        int n = f.nextInt();
        while (n-- > 0) {
            int r = f.nextInt();
            int g = f.nextInt();
            int b = f.nextInt();
            int min = Math.min(Math.min(r, g), b);
            r-= min;
            g-= min;
            b-= min;
            if (r > 0 && !(b > 0)) {
                System.out.println("Protect the Federation");
            }
            else {
                System.out.println("Get them!");
            }
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Jedi().run();
    }

}