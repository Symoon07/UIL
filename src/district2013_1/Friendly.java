package district2013_1;

import java.util.*;
import java.io.*;

public class Friendly {

    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/district2013_1/Friendly.dat".toLowerCase()));
        //Scanner f = new Scanner(System.in);

        while (f.hasNext()) {
            String[] time = f.next().split(":");
            String m = f.nextLine().trim();
            int A = Integer.parseInt(time[0]) * 9;
            int B = 3 * Integer.parseInt(time[1]) + Integer.parseInt(time[2]);
            String[] out = new String[m.length()];
            for (int i = 0; i < m.length(); i++) {
                if (i % 2 == 0) {
                    out[i] = Integer.toString((int) m.charAt(i) ^ A, 16);
                }
                else {
                    out[i] = Integer.toString((int) m.charAt(i) ^ B, 16);
                }
            }
            System.out.print(time[0] + ":" + time[1] + ":" + time[2] + " ");
            for (int i = 0; i < out.length; i++) {
                System.out.printf("0x%s ", out[i].toUpperCase());
            }
            System.out.println();
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Friendly().run();
    }

}