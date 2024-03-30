package waller2023;

import java.util.*;
import java.io.*;

public class Cindy {
    
    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/waller2023/Cindy.dat"));
        //Scanner f = new Scanner(System.in);

        int n = f.nextInt();
        while (n --> 0) {
            int t = f.nextInt();
            int k = f.nextInt();
            int[] prices = new int[t];
            for (int i = 0; i < t; i++) {
                prices[i] = f.nextInt();
            }
            Arrays.sort(prices);
            for (int p : prices) {
                if (p <= k) {
                    k -= p;
                }
                else {
                    t--;
                }
            }
            System.out.println(t);
        }

        f.close();
    }
    
    public static void main(String[] args) throws Exception {
        new Cindy().run();
    }

}