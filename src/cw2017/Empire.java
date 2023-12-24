package cw2017;

import java.util.*;
import java.io.*;

public class Empire {

    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/cw2017/Empire.dat".toLowerCase()));
        //Scanner f = new Scanner(System.in);

        int n = f.nextInt(); f.nextLine();
        while (n-- > 0) {
            int x = f.nextInt();
            String p = f.next(); f.nextLine();
            String l = f.nextLine();
            while (x-- > 0) {
                System.out.println(l);
                System.out.println("The Empire Loves the Citizens of " + p + "!");
            }
            System.out.println();
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Empire().run();
    }

}