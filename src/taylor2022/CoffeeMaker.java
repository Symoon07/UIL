package taylor2022;

import java.util.*;
import java.io.*;

public class CoffeeMaker {
    public int converter(int val, String unit) {
        if (unit.equals("GW")) {
            return val * 1000000000;
        }
        if (unit.equals("MW")) {
            return val * 1000000;
        }
        if (unit.equals("kW")) {
            return val * 1000;
        }
        else {
            return val;
        }
    }

    public void run() throws Exception {
        //Scanner f = new Scanner(new File("template.dat"));
        Scanner f = new Scanner(System.in);

        int cases = f.nextInt();
        while (cases-- > 0) {
            int total = converter(f.nextInt(), f.next());
            int cur = converter(f.nextInt(), f.next());
            int coffee = converter(f.nextInt(), f.next());

            if (total - cur < coffee) {
                System.out.println("The coffee maker cannot be plugged in");
            }
            else {
                System.out.println("The coffee maker can be plugged in");
            }
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new CoffeeMaker().run();
    }

}