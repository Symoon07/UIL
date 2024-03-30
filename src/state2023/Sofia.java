package state2023;

import java.util.*;
import java.io.*;

public class Sofia {

    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/state2023/Sofia.dat".toLowerCase()));
        //Scanner f = new Scanner(System.in);

        int cases = f.nextInt();
        for (int i = 1; i <= cases; i++) {
            double t = f.nextDouble();
            double h = f.nextDouble();
            double HI = (t + .5 * (t + 61.0 + ((t - 68.0) * 1.2) + (h * .094))) / 2.0;
            if (HI >= 80) {
                HI = -42.379 + 2.04901523 * t + 10.14333127 * h - .22475541 * t * h - 6.83783 * Math.pow(10, -3) * Math.pow(t, 2) - 5.481717 * Math.pow(10, -2) * Math.pow(h, 2)
                        + 1.22874 * Math.pow(10, -3) * Math.pow(t, 2) * h + 8.5282 * Math.pow(10, -4) * t * Math.pow(h, 2) - 1.99 * Math.pow(10, -6) * Math.pow(t, 2) * Math.pow(h, 2);
                if (h < 13 && t >= 80 && t <= 112) {
                    HI -= ((13 - h) / 4.0) * Math.sqrt((17 - Math.abs(t - 95)) / 17.0);
                }
                else if (h > 85 && t >= 80 && t <= 87) {
                    HI += ((h - 85) / 10.0) * ((87 - t) / 5.0);
                }
            }
            if (HI <= 140 && HI >= 75) {
                System.out.printf("Test case #%d: %.1f\n", i, HI);
            }
            else {
                System.out.printf("Test case #%d: Heat Index %.1f NOT VALID!\n", i, HI);
            }
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Sofia().run();
    }

}