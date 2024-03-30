package a2022;

import java.util.*;
import java.io.*;

public class Harold {
    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/a2022/Harold.dat".toLowerCase()));
        //Scanner f = new Scanner(System.in);

        int cases = f.nextInt();
        while (cases-- > 0) {
            String num = f.next();
            String m = num.substring(0,1);
            if (num.length() > 1) {
                m += "." + num.substring(1);
            }
            int n = num.length()-1;
            System.out.println(num + "=" + m + "*10^" + n);
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Harold().run();
    }

}