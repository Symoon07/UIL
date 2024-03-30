package amc2024;

import java.util.*;
import java.io.*;

public class DMV {
    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/amc2024/DMV.dat"));
        //Scanner f = new Scanner(System.in);

        while (f.hasNext()) {
            String a = f.nextLine();
            String b = f.nextLine();
            int[][] dp = new int[a.length() + 1][b.length() + 1];
            for (int i = 1; i <= a.length(); i++) {
                for (int j = 1; j <= b.length(); j++) {
                    if (i == 0) {
                        dp[i][j] = j;
                    }
                    else if (j == 0) {
                        dp[i][j] = i;
                    }
                    else if (a.charAt(i - 1) == b.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                    else {
                        dp[i][j] = Math.min(dp[i - 1][j - 1] + 1, Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1));
                    }
                }
            }
            System.out.println(dp[a.length()][b.length()]);
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new DMV().run();
    }
}