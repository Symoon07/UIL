package b2024;

import java.util.*;
import java.io.*;

public class Vika {
    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/b2024/Vika.dat"));
        //Scanner f = new Scanner(System.in);

        int t = f.nextInt();
        while (t --> 0) {
            String a = f.next();
            String b = f.next();
            int[][] dp = new int[a.length() + 1][b.length() + 1];
            for (int i = 1; i <= a.length(); i++) {
                for (int j = 1; j <= b.length(); j++) {
                    if (a.charAt(i - 1) == b.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    }
                    else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    }
                }
            }
            System.out.println(dp[a.length()][b.length()]);
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Vika().run();
    }
}