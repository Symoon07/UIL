package amc2024;

import java.util.*;
import java.io.*;

public class City {
    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/amc2024/City.dat"));
        //Scanner f = new Scanner(System.in);

        int t = f.nextInt();
        while (t --> 0) {
            int day = f.nextInt(), mon = f.nextInt();
            if ((mon == 3 && day > 14) || (mon == 4) || (mon == 5 && day <= 14)) {
                System.out.println("outstanding work gentlemen");
            }
            else {
                System.out.println("this is the worst of all possible worlds");
            }
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new City().run();
    }
}