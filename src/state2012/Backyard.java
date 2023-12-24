package state2012;

import java.util.*;
import java.io.*;

public class Backyard {

    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/state2012/Backyard.dat".toLowerCase()));
        //Scanner f = new Scanner(System.in);

        int n = f.nextInt();
        while (n-- > 0) {
            int feet = f.nextInt();
            int b = (int) Math.ceil(feet / 3.0);
            int p = (int) (feet * 12.0 / 1.875);
            p += (int) Math.ceil(feet / 10.0);
            System.out.println(b + " " + p);
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Backyard().run();
    }

}