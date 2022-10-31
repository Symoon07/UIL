package waller2022;

import java.util.*;
import java.io.*;

public class Carol {
    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/waller2022/Carol.dat"));
        //Scanner f = new Scanner(System.in);

        int total = 0;
        String alpa = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        while (f.hasNext()) {
            String n = f.next();
            int pos = alpa.indexOf(n);
            total += Math.pow(2, pos);
        }

        System.out.println(total);

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Carol().run();
    }

}