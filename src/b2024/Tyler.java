package b2024;

import java.util.*;
import java.io.*;

public class Tyler {
    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/b2024/Tyler.dat"));
        //Scanner f = new Scanner(System.in);

        int n = f.nextInt(), m = f.nextInt();
        int[] mult = new int[n];
        for (int i = 0; i < n; i++) {
            mult[i] = f.nextInt();
        }
        while (m --> 0) {
            int t = f.nextInt();
            boolean[] dp = new boolean[t + 1];
            dp[1] = true;
            for (int i = 1; i <= t; i++) {
                if (!dp[i]) {
                    continue;
                }
                for (int j = 0; j < n; j++) {
                    if (1 < i * mult[j] && i * mult[j] <= t) {
                        dp[i * mult[j]] = true;
                    }
                }
            }
            System.out.println(dp[t] ? "Target " + t + ": YES" : "Target " + t + ": NO");
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Tyler().run();
    }
}