package cw2017;

import java.util.*;
import java.io.*;

public class Decrypt {
    
    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/cw2017/Decrypt.dat".toLowerCase()));
        //Scanner f = new Scanner(System.in);

        int n = f.nextInt(); f.nextLine();
        while (n-- > 0) {
            String line = f.nextLine();
            String out = "";
            for (int i = 0; i < line.length(); i++) {
                out += (char) (line.charAt(i) - 2);
            }
            int m = f.nextInt();
            int r = 0;
            while (m-- > 0) {
                String dir = f.next();
                int v = f.nextInt();
                r += dir.equals("R") ? v : -v;
            }
            f.nextLine();
            if (r > 0) {
                r = r % out.length();
                System.out.println(out.substring(out.length()-r) + out.substring(0, out.length()-r));
            }
            else if (r < 0) {
                r = Math.abs(r % out.length());
                System.out.println(out.substring(r) + out.substring(0, r));
            }
        }

        f.close();
    }
    
    public static void main(String[] args) throws Exception {
        new Decrypt().run();
    }

}