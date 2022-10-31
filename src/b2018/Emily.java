package b2018;

import java.util.*;
import java.io.*;

public class Emily {
    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/b2018/emily.dat"));
        //Scanner f = new Scanner(System.in);

        while (f.hasNext()) {

            int base1 = f.nextInt();
            int base2 = f.nextInt();
            int height = f.nextInt();
            double area = ((base1 + base2) / 2.0) * height;
            if (area == (int) area) {
                System.out.println((int) area);
            }
            else {
                System.out.printf("%.1f%n", area);
            }

        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Emily().run();
    }

}