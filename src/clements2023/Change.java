package clements2023;

import java.util.*;
import java.io.*;

public class Change {

    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/clements2023/Change.dat"));
        //Scanner f = new Scanner(System.in);

        int n = f.nextInt();
        while (n --> 0) {
            int m = f.nextInt();
            int c = f.nextInt();
            int[] coins = new int[m];
            int[] dp = new int[c+1];
            for (int i = 0; i < m; i++) {
                coins[i] = f.nextInt();
            }
            Arrays.fill(dp, Integer.MAX_VALUE);
            dp[0] = 0;
            for (int i = 0; i < coins.length; i++) {
                for (int j = dp.length-1; j >= 0; j--) {
                    if (dp[j] != Integer.MAX_VALUE && j + coins[i] <= c) {
                        dp[j + coins[i]] = Math.min(dp[j] + 1, dp[j + coins[i]]);
                    }
                }
            }
            System.out.println(dp[c] != Integer.MAX_VALUE ? "Very good chef." : "Idiot sandwich.");
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Change().run();
    }

}