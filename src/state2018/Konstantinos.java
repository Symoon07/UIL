package state2018;

import java.util.*;
import java.io.*;

public class Konstantinos {

    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/state2018/Konstantinos.dat"));
        //Scanner f = new Scanner(System.in);

        while (f.hasNext()) {
            int x1 = f.nextInt();
            int y1 = f.nextInt();
            int r1 = f.nextInt();
            int x2 = f.nextInt();
            int y2 = f.nextInt();
            int r2 = f.nextInt();
            double d = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
            if (d == r1 + r2) {
                System.out.println("EXTERNALLY TANGENT");
            }
            else if (Math.abs(r2 -r1) == d) {
                System.out.println("INTERNALLY TANGENT");
            }
            else if (d > r1 + r2) {
                System.out.println("NON-INTERSECTING");
            }
            else if (Math.abs(r2 - r1) > d) {
                System.out.println("NESTED");
            }
            else {
                System.out.println("INTERSECTING");
            }
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Konstantinos().run();
    }

}