package slhs2022;

import java.util.*;
import java.io.*;

public class Wall {
    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/slhs2022/wall.dat"));
        //Scanner f = new Scanner(System.in);

        int cases = f.nextInt();
        while (cases-- > 0) {

            f.nextInt();
            int a = f.nextInt();
            int b = f.nextInt();
            char[] in = f.next().toCharArray();
            int total = 0;
            int gap = 0;
            boolean wasX = false;
            boolean begun = false;
            for (char c : in) {
                if (c == 'X') {
                    begun = true;
                    if (wasX) {
                        total += a;
                    } else {
                        if (gap > 0) {
                            total += Math.min(a + b, a * gap + a);
                            gap = 0;
                        } else {
                            total += a + b;
                        }
                    }
                    wasX = true;
                } else {
                    wasX = false;
                    if (begun) {
                        gap++;
                    }
                }
            }

            System.out.println(total);

        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Wall().run();
    }

}