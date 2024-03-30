package waller2023;

import java.util.*;
import java.io.*;

public class Fernando {

    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/waller2023/Fernando.dat"));
        //Scanner f = new Scanner(System.in);

        int t = f.nextInt();
        while (t --> 0) {
            int n = f.nextInt();
            int i = 0;
            int ii = 0;
            int iii = 0;
            while (n --> 0) {
                iii = ii;
                ii = i;
                i = f.nextInt();
                System.out.print(i + ii + iii + " ");
            }
            System.out.println();
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Fernando().run();
    }

}