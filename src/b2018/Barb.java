package b2018;

import java.util.*;
import java.io.*;

public class Barb {
    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/b2018/barb.dat"));
        //Scanner f = new Scanner(System.in);

        while (f.hasNext()) {

            String in = f.next();
            StringBuilder reverse = new StringBuilder(in).reverse();
            System.out.print(in + " " + new String(reverse).toUpperCase() + " " +
                    new String(reverse).substring(reverse.length()/2) + " " + in.substring(in.length()/2).toUpperCase() +"\n");

        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Barb().run();
    }

}