package cw2017;

import java.util.*;
import java.io.*;

public class Forges {

    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/cw2017/Forges.dat"));
        //Scanner f = new Scanner(System.in);

        int n = f.nextInt();
        while (n-- > 0) {
            int s = f.nextInt();
            long[] fib = new long[s];
            fib[0] = 1;
            fib[1] = 1;
            for (int i = 2; i < s; i++) {
                fib[i] = fib[i-2] + fib[i-1];
            }
            System.out.println(fib[s-1]-1);
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Forges().run();
    }

}