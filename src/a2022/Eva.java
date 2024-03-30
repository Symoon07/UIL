package a2022;

import java.util.*;
import java.io.*;

public class Eva {
    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/a2022/Eva.dat".toLowerCase()));
        //Scanner f = new Scanner(System.in);

        int cases = f.nextInt();
        int c = 1;
        while (cases-- > 0) {
            int h = f.nextInt();
            int ac = 1;
            int sc = h - ac;
            System.out.println("Start of Triagnle #" + c);
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < sc; j++) {
                    System.out.print(" ");
                }
                for (int j = 0; j < ac; j++) {
                    System.out.print("*");
                }
                ac+=2;
                sc--;
                System.out.println();
            }
            System.out.println("End of Triangle #" + c);
            c++;
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Eva().run();
    }

}