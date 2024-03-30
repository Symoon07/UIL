package b2024;

import java.util.*;
import java.io.*;

public class Daniella {
    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/b2024/Daniella.dat"));
        //Scanner f = new Scanner(System.in);

        int t = f.nextInt();
        while (t --> 0) {
            String s = f.next();
            int n = f.nextInt();
            int i;
            for (i = 0; i < s.length()-n; i+=n) {
                System.out.print(s.substring(i, i + n) + "-");
            }
            System.out.println(s.substring(i));
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Daniella().run();
    }
}