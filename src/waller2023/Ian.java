package waller2023;

import java.util.*;
import java.io.*;

public class Ian {

    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/waller2023/Ian.dat"));
        //Scanner f = new Scanner(System.in);

        int t = f.nextInt();
        while (t --> 0) {
            double p = f.nextDouble();
            double c = f.nextDouble();
            System.out.printf("%.2f\n", p * (1 - c / 100) + p * (1 - c / 100) * .1);
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Ian().run();
    }

}