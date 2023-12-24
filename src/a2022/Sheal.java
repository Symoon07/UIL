package a2022;

import java.util.*;
import java.io.*;

public class Sheal {

    public void run() throws Exception {
        Scanner f = new Scanner(new File("Sheal.dat".toLowerCase()));
        //Scanner f = new Scanner(System.in);

        int cases = f.nextInt();
        while (cases-- > 0 ) {
            String s = f.next();
            int k = f.nextInt();
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Sheal().run();
    }

}