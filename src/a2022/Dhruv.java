package a2022;

import java.util.*;
import java.io.*;

public class Dhruv {
    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/a2022/Dhruv.dat".toLowerCase()));
        //Scanner f = new Scanner(System.in);

        HashMap<Integer, String> hm = new HashMap<>();
        for (int i = 0; i < 8; i++) {
            String s = f.next();
            int n = f.nextInt();
            hm.put(n, s);
        }
        int cases = f.nextInt();
        while (cases-- > 0) {
            int n = f.nextInt();
            if (n < 535 || n > 1605) {
                System.out.println("BAD INPUT");
            }
            else {
                int close = Integer.MAX_VALUE;
                for (int key : hm.keySet()) {
                    if (Math.abs(close - n) >= Math.abs(key - n)) {
                        close = key;
                    }
                }
                System.out.println(hm.get(close));
            }
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Dhruv().run();
    }

}