package a2020;

import java.util.*;
import java.io.*;

public class Brian {
    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/a2020/brian.dat"));
        //Scanner f = new Scanner(System.in);

        int cases = f.nextInt();
        while (cases-- > 0) {
            int year = f.nextInt();
            int ver = (year - 1995) / 2;
            System.out.println("In the year " + year + ", Brian will be coding in Java " + ver + "!");
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Brian().run();
    }

}