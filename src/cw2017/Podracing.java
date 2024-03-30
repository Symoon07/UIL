package cw2017;

import java.util.*;
import java.io.*;

public class Podracing {

    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/cw2017/Podracing.dat".toLowerCase()));
        //Scanner f = new Scanner(System.in);

        int n = f.nextInt(); f.nextLine();
        while (n-- > 0) {
            String s = f.nextLine();
            System.out.println(s.equals("mos espa grand arena") ? "Now this is podracing!" : "Oof! This is NOT podracing!");
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Podracing().run();
    }

}