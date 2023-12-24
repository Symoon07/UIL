package cw2014;

import java.util.*;
import java.io.*;

public class Basic {

    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/cw2014/Basic.dat".toLowerCase()));
        //Scanner f = new Scanner(System.in);

        int n = f.nextInt();
        while (n --> 0) {
            int x = f.nextInt();
            int i = f.nextInt();
            System.out.println(Integer.toString(i, x));
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Basic().run();
    }

}