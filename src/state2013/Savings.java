package state2013;

import java.util.*;
import java.io.*;

public class Savings {

    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/state2013/Savings.dat".toLowerCase()));
        //Scanner f = new Scanner(System.in);

        int[] sum = new int[366];
        int cur = 1, inc = 1;
        while (cur < 366) {
            for (int i = 0; i < inc && cur < 366; i++) {
                sum[cur] = sum[cur - 1] + inc;
                cur++;
            }
            inc++;
        }
        while (f.hasNext()) {
            int n = f.nextInt();
            System.out.printf("%d $%d\n", n, sum[n]);
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Savings().run();
    }

}