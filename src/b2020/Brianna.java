package b2020;

import java.util.*;
import java.io.*;

public class Brianna {
    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/Input/brianna.dat"));
        //Scanner f = new Scanner(System.in);

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        while (f.hasNext()) {

            int cur = f.nextInt();
            if (cur < min) {
                min = cur;
            }
            if (cur > max) {
                max = cur;
            }

        }

        System.out.printf("%d %d %d", min, max, max - min);

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Brianna().run();
    }

}