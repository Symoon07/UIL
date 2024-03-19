package amc2024;

import java.util.*;
import java.io.*;

public class Light {
    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/amc2024/Light.dat"));
        //Scanner f = new Scanner(System.in);

        int t = f.nextInt();
        while (t --> 0) {
            System.out.println(f.nextInt() <= f.nextInt() - f.nextInt() * 2 ? "yes" : "no");
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Light().run();
    }
}