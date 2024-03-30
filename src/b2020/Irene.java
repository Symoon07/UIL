package b2020;

import java.util.*;
import java.io.*;

public class Irene {
    public boolean prime(int num) {
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }

        return true;
    }

    public boolean semiPrime (int num) {
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (prime(i) && num % i == 0 && prime(num / i)) return true;
        }

        return false;
    }

    public boolean disc (int num) {
        return semiPrime(num) && Math.pow((int) Math.sqrt(num), 2) != num;
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/Input/irene.dat"));
        //Scanner f = new Scanner(System.in);

        int cases = f.nextInt();
        while (cases-- > 0) {

            int num = f.nextInt();
            if (disc(num)) {
                System.out.println(num + " DISCRETE SEMIPRIME");
            }
            else if (semiPrime(num)) {
                System.out.println(num + " SEMIPRIME");
            }
            else {
                System.out.println(num + " NOT SEMIPRIME");
            }

        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Irene().run();
    }

}