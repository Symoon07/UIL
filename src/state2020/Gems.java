package state2020;

import java.util.*;
import java.io.*;

public class Gems {

    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/state2020/Gems.dat".toLowerCase()));
        //Scanner f = new Scanner(System.in);

        int t = f.nextInt();
        while (t --> 0) {
            int n = f.nextInt();
            int space = n / 2;
            int gem = 1;
            for (int i = 0; i < n; i++) {
                if (i >= n / 2) {
                    System.out.println(" ".repeat(space++) + "$".repeat(Math.max(1, gem)));
                    gem -= 2;
                }
                else {
                    System.out.println(" ".repeat(space--) + "$".repeat(Math.max(1, gem)));
                    gem += 2;
                }
            }
            System.out.println();
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Gems().run();
    }

}