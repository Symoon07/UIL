package waller2023;

import java.util.*;
import java.io.*;

public class Bob {

    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/waller2023/Bob.dat"));
        //Scanner f = new Scanner(System.in);

        int n = f.nextInt();
        while (n --> 0) {
            int a = f.nextInt();
            int b = f.nextInt();
            String o = f.next();
            System.out.println(o.equals("+") ? a + b : a * b);
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Bob().run();
    }

}