package slhs2019;

import java.util.*;
import java.io.*;

public class NearestIsland {
    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/Input/nearestisland.dat"));
        //Scanner f = new Scanner(System.in);

        double sx = f.nextDouble();
        double sy = f.nextDouble();
        double close = Integer.MAX_VALUE;
        double[] coord = new double[2];
        while (f.hasNextLine()) {
            double x = f.nextDouble();
            double y = f.nextDouble();
            double distance = Math.sqrt(Math.pow(x - sx, 2)) + Math.pow(y - sy, 2);
            if (distance < close) {
                close= distance;
                coord[0] = x; coord[1] = y;
            }
        }

        System.out.printf(Arrays.toString(coord));

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new NearestIsland().run();
    }

}