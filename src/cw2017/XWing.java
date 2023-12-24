package cw2017;

import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class XWing {

    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/cw2017/XWing.dat"));
        //Scanner f = new Scanner(System.in);

        int r = f.nextInt();
        while (r-- > 0) {
            int n = f.nextInt();
            int t = f.nextInt();
            int s = f.nextInt();
            BigInteger d = BigInteger.valueOf((long) Math.pow(Math.abs(n - t), 2)).add(fac(n)).add(fac(t));
            System.out.println(d.compareTo(BigInteger.valueOf(s)) > 0 ? "Ethan's X-Wing Spontaneously Combusts" : "Ethan's X-Wing is Okay");
        }

        f.close();
    }

    public BigInteger fac(int n) {
        BigInteger out = BigInteger.valueOf(1);
        for (int i = 2; i <= n; i++) {
            out = out.multiply(BigInteger.valueOf(i));
        }
        return out;
    }

    public static void main(String[] args) throws Exception {
        new XWing().run();
    }

}