package state1999;

import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class Math {
    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/state1999/math.dat"));
        //Scanner f = new Scanner(System.in);

        while (f.hasNext()) {
            BigInteger one = f.nextBigInteger();
            BigInteger two = f.nextBigInteger();
            System.out.println(one.compareTo(BigInteger.ZERO) > 0 ? "+" + one : one);
            System.out.println(two.compareTo(BigInteger.ZERO) > 0 ? "+" + two : two);
            System.out.println(one.add(two).compareTo(BigInteger.ZERO) > 0 ? "+" + one.add(two) : one.add(two));
            System.out.println();
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Math().run();
    }

}