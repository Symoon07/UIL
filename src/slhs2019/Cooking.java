package slhs2019;

import java.util.*;
import java.io.*;

public class Cooking {
    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/Input/cooking.dat"));
        //Scanner f = new Scanner(System.in);

        while (f.hasNext()) {

            int time = 0;
            String in = f.nextLine();
            for (int i = 0; i < in.length(); i++) {
                char c = in.charAt(i);
                time += c;
            }

            System.out.printf("%dmin, %dsec%n", time/60, time%60);

        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Cooking().run();
    }

}