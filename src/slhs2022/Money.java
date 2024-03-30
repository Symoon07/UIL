package slhs2022;

import java.util.*;
import java.io.*;

public class Money {
    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/slhs2022/money.dat"));
        //Scanner f = new Scanner(System.in);

        int cases = f.nextInt();
        while (cases-- > 0) {

            int bill = f.nextInt();
            String out = "";
            out += bill / 1000 + ":";
            bill %= 1000;

            out += bill / 100 + ":";
            bill %= 100;

            out += bill / 50 + ":";
            bill %= 50;

            out += bill / 20 + ":";
            bill %= 20;

            out += bill / 10 + ":";
            bill %= 10;

            out += bill / 5 + ":";
            bill %= 5;

            out += bill;

            System.out.println(out);

        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Money().run();
    }

}