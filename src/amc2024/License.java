package amc2024;

import java.util.*;
import java.io.*;

public class License {
    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/amc2024/License.dat"));
        //Scanner f = new Scanner(System.in);

        int t = f.nextInt(); f.nextLine();
        while (t --> 0) {
            String l = f.nextLine();
            System.out.println("*".repeat(l.length() + 4));
            System.out.printf("* %s *\n", l);
            System.out.println("*".repeat(l.length() + 4));
            System.out.println();
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new License().run();
    }
}