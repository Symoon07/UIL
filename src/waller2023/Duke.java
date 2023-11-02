package waller2023;

import java.util.*;
import java.io.*;

public class Duke {

    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/waller2023/Duke.dat"));
        //Scanner f = new Scanner(System.in);

        int n = f.nextInt();
        while (n --> 0) {
            int r = f.nextInt();
            int c = f.nextInt();
            String s = f.next();
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    System.out.print(s);
                }
                System.out.println();
            }
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Duke().run();
    }

}