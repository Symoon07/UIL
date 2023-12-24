package cw2017;

import java.util.*;
import java.io.*;

public class Ugly {

    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/cw2017/Ugly.dat".toLowerCase()));
        //Scanner f = new Scanner(System.in);

        int n = f.nextInt();
        while (n-- > 0) {
            int o = f.nextInt();
            double s = f.nextDouble();
            double netWeight = 0;
            boolean fell = false;
            System.out.println("Let's get decorating!");
            while (o-- > 0) {
                f.next();
                double m = f.nextDouble();
                double p = f.nextDouble();
                netWeight += m * p * 1.1;
                if (fell) {
                    System.out.println("There's no use wasting ornaments on a fallen tree!");
                }
                else if (Math.abs(netWeight) > s) {
                    System.out.println("TIMBER!!!");
                    fell = true;
                }
                else if (Math.abs(netWeight) > (s * 2.0 / 3.0)) {
                    System.out.println(netWeight > 0 ? "Looks a little tilted to the right..." : "Looks a little tilted to the left...");
                }
                else {
                    System.out.println("It looks a little better I guess.");
                }
            }
            System.out.println("It's still really ugly.");
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Ugly().run();
    }

}