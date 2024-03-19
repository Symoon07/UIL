package state2020;

import java.util.*;
import java.io.*;

public class Elven {

    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/state2020/Elven.dat".toLowerCase()));
        //Scanner f = new Scanner(System.in);

        int t = f.nextInt(); f.nextLine();
        while (t --> 0) {
            int n = f.nextInt(); f.nextLine();
            while (n --> 0) {
                String line = f.nextLine();
                for (int i = 0; i < line.length(); i++) {
                    if (line.substring(i, i + 1).matches("[AEIOU]")) {
                        line = line.substring(0, i) + Character.toLowerCase(line.charAt(i)) + line.substring(i + 1);
                    }
                }
                System.out.println(new StringBuilder(line).reverse());
            }
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Elven().run();
    }

}