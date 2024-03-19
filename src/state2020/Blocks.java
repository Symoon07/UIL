package state2020;

import java.util.*;
import java.io.*;

public class Blocks {

    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/state2020/Blocks.dat".toLowerCase()));
        //Scanner f = new Scanner(System.in);

        int t = f.nextInt();
        while (t --> 0) {
            int n = (int) (f.nextLong() % 4);
            switch (n) {
                case 0 -> System.out.println("""
                        1 2 3
                        4 5 6
                        7 8 9\s""");
                case 1 -> System.out.println("""
                        7 4 1
                        8 5 2
                        9 6 3\s""");
                case 2 -> System.out.println("""
                        9 8 7
                        6 5 4
                        3 2 1\s""");
                default -> System.out.println("""
                        3 6 9
                        2 5 8
                        1 4 7\s""");
            }
            System.out.println("- - -");
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Blocks().run();
    }

}