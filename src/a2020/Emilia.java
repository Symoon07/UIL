package a2020;

import java.util.*;
import java.io.*;

public class Emilia {

    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/a2020/Emilia.dat".toLowerCase()));
        //Scanner f = new Scanner(System.in);

        int n = f.nextInt();
        while (n-- > 0) {
            double h = f.nextDouble();
            double m = f.nextDouble();
            int hour = (int) Math.floor((450 - h) / 30);
            int min = (int) (450 - m) / 6 % 60;
            System.out.printf("%02d:%02d\n", hour % 12 == 0 ? 12 : hour % 12, min);
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Emilia().run();
    }

}