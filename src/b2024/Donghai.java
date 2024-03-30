package b2024;

import java.util.*;
import java.io.*;

public class Donghai {
    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/b2024/Donghai.dat"));
        //Scanner f = new Scanner(System.in);

        int t = f.nextInt(); f.nextLine();
        while (t --> 0) {
            String s = f.nextLine().toUpperCase();
            int[] occ = new int[26];
            for (int i = 0; i < s.length(); i++) {
                if (Character.isUpperCase(s.charAt(i))) {
                    occ[s.charAt(i) - 65]++;
                }
            }
            for (int i = 0; i < occ.length; i++) {
                if (occ[i] != 0) {
                    System.out.println((char) (i + 65) + ":" + occ[i]);
                }
            }
            System.out.println("=".repeat(10));
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Donghai().run();
    }
}