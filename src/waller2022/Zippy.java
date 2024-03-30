package waller2022;

import java.util.*;
import java.io.*;

public class Zippy {
    public boolean Prime(int num) {
        for (int i = 2; i < Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }

        return true;
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/waller2022/Zippy.dat"));
        //Scanner f = new Scanner(System.in);

        int start = f.nextInt();
        int end = f.nextInt();
        String out = "";
        for (int i = start; i <= end; i++) {
            if (Prime(i)) {
                out += i + " ";
            }
        }

        System.out.println(out.trim());

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Zippy().run();
    }

}