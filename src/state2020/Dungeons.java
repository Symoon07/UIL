package state2020;

import java.util.*;
import java.io.*;

public class Dungeons {
    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/state2020/Dungeons.dat"));
        //Scanner f = new Scanner(System.in);

        int t = f.nextInt();
        while (t --> 0) {
            int n = f.nextInt(), w = f.nextInt(), na = f.nextInt(), ac = f.nextInt();
            int[] weights = new int[n];
            int[] vals = new int[n];
            for (int i = 0; i < n; i++) {
                f.next();
                String type = f.next();
                int val = f.nextInt();
                switch (type) {
                    case "weapon" -> vals[i] = val * na * 2;
                    case "armor" -> vals[i] = val * (22 - ac);
                    default -> vals[i] = val;
                }
                weights[i] = f.nextInt();
            }
            int[][] dp = new int[n + 1][w + 1];
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= w; j++) {
                    dp[i][j] = dp[i-1][j];
                    if (weights[i-1] <= j) {
                        dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-weights[i-1]] + vals[i-1]);
                    }
                }
            }
            System.out.println(dp[n][w]);
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Dungeons().run();
    }
}