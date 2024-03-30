package state1999;

import java.util.*;
import java.io.*;

public class Stone {
    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/state1999/stone.dat"));
        //Scanner f = new Scanner(System.in);

        while (f.hasNext()) {
            double r = f.nextDouble();
            double d = f.nextDouble();
            System.out.printf("Radius: %.1f, Distance: %.1f, Rotations: %.1f\n", r, d, d / (2 * r * 3.14));
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Stone().run();
    }

}