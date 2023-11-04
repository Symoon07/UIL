package waller2023;

import java.util.*;
import java.io.*;

public class Louis {
    
    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/waller2023/Louis.dat"));
        //Scanner f = new Scanner(System.in);

        int t = f.nextInt();
        while (t --> 0) {
            int n = f.nextInt();
            System.out.println((int) Math.ceil(Math.log(n) / Math.log(2)));
        }

        f.close();
    }
    
    public static void main(String[] args) throws Exception {
        new Louis().run();
    }

}