package state2023;

import java.util.*;
import java.io.*;

public class Gabriel {

    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/state2023/Gabriel.dat".toLowerCase()));
        //Scanner f = new Scanner(System.in);

        int cases = f.nextInt(); f.nextLine();
        while (cases-- > 0) {
            int n = f.nextInt();
            String line = f.nextLine().trim().replaceAll(" ", "");
            if (Math.pow(n, 3) > line.length()) {
                System.out.println("NOT ENOUGH LETTERS");
                continue;
            }
            int c = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(line.substring(c, c+n) + " ");
                    c += n;
                }
                System.out.println();
            }
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Gabriel().run();
    }

}