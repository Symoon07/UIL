package amc2024;

import java.util.*;
import java.io.*;

public class Farm {
    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/amc2024/Farm.dat"));
        //Scanner f = new Scanner(System.in);

        int t = f.nextInt(), n = f.nextInt();
        HashSet<String> hs = new HashSet<>();
        while (n --> 0) {
            hs.add(f.next());
        }
        while (t --> 0) {
            String in = f.next();
            if (hs.contains(in)) {
                System.out.println("SHIPMENT DISAPPROVED\n");
            }
            else {
                int len = (int) Math.ceil(Math.sqrt(in.length()));
                char[][] mat = new char[len][len];
                for (int i = 0; i < len; i++) {
                    Arrays.fill(mat[i], '*');
                }
                int ct = 0;
                loop : for (int i = len - 1; i >= 0; i--) {
                    for (int j = 0; j < len; j++) {
                        if (ct >= in.length()) {
                            break loop;
                        }
                        mat[i][j] = in.charAt(ct++);
                    }
                }
                for (int i = 0; i < len; i++) {
                    for (int j = 0; j < len; j++) {
                        System.out.print(mat[i][j]);
                    }
                    System.out.println();
                }
                System.out.println();
            }
        }

        f.close();
    }
    
    public static void main(String[] args) throws Exception {
        new Farm().run();
    }
}