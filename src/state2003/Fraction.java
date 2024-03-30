package state2003;

import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class Fraction {

    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/state2003/Fraction.dat".toLowerCase()));
        //Scanner f = new Scanner(System.in);

        while (f.hasNext()) {
            BigInteger n = BigInteger.valueOf(f.nextInt());
            BigInteger d = BigInteger.valueOf(f.nextInt());
            BigInteger gcd = n.gcd(d);
            System.out.println(n.divide(gcd) + " " + d.divide(gcd));
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Fraction().run();
    }

}