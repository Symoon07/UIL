package b2020;

import java.util.*;
import java.io.*;

public class Deepa {
    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/Input/deepa.dat"));
        //Scanner f = new Scanner(System.in);

        int cases = f.nextInt();
        for (int i = 0; i < cases; i++) {

            int brackets = f.nextInt();
            int income = f.nextInt();
            int[] val = new int[brackets];
            int[] per = new int[brackets];
            for (int j = 0; j < brackets; j++) {
                val[j] = f.nextInt();
                per[j] = f.nextInt();
            }

            double tax = 0.0;
            int remain = income;
            for (int j = 1; j < brackets; j++) {
                int temp = val[j] - val[j-1];
                int subtracted = Math.min(temp, remain);
                tax += subtracted * per[j-1];
                remain -= subtracted;
            }
            tax += remain * per[brackets- 1];

            System.out.printf("Case #%d: $%,.2f %.3f%%%n", i+1, tax / 100, tax / income);

        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Deepa().run();
    }

}