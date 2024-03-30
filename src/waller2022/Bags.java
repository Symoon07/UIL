package waller2022;

import java.util.*;
import java.io.*;

public class Bags {
    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/waller2022/Bags.dat"));
        //Scanner f = new Scanner(System.in);

        String word = f.next();
        int times = f.nextInt();
        for (int i = 0; i < times; i++) {
            for (int j = i; j < times; j++) {
                System.out.print(word);
            }
            System.out.println();
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Bags().run();
    }

}