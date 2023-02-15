package district2012;

import java.util.*;
import java.io.*;

public class Cell {

    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/district2012/Cell.dat".toLowerCase()));
        //Scanner f = new Scanner(System.in);

        int a = 0;
        int b = 0;
        while (f.hasNext()) {
            double d = Double.parseDouble(f.next());
            a += Math.floor(d);
            b += Math.ceil(d);
        }
        System.out.println("PLAN A: " + a);
        System.out.println("PLAN B: " + b);

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Cell().run();
    }

}