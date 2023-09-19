package cw2017;

import java.util.*;
import java.io.*;

public class Regulations {

    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/cw2017/Regulations.dat"));
        //Scanner f = new Scanner(System.in);

        int n = f.nextInt();
        while (n-- > 0) {
            int e = f.nextInt();
            boolean pass = true;
            while (e-- > 0) {
                String color = f.next();
                long l = f.nextLong();
                long w = f.nextLong();
                long h = f.nextLong();
                long weight = f.nextLong();
                String smell = f.next();
                if (!(color.equals("Space_Grey") || color.equals("Imperial_Black") || color.equals("Royal_Guard_Red")) || !(l == h && h == w) || weight >= 20 || !(smell.equals("Clean") || smell.equals("Fruity") || smell.equals("Perfumed"))) {
                    pass = false;
                }
            }
            System.out.println(pass ? "Never tell me the odds!" : "It's a trap!");
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Regulations().run();
    }

}