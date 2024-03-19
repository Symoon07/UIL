package state2020;

import java.util.*;
import java.io.*;

public class Forest {

    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/state2020/Forest.dat".toLowerCase()));
        //Scanner f = new Scanner(System.in);

        int t = f.nextInt();
        while (t --> 0) {
            String l = f.next();
            String r = f.next();
            System.out.println("BOULDERS: " + (l.replaceAll("[^o]", "").length() > r.replaceAll("[^o]", "").length() ? "LEFT" : "RIGHT"));
            System.out.println("TREES: " + (l.replaceAll("[^i]", "").length() > r.replaceAll("[^i]", "").length() ? "LEFT" : "RIGHT"));
            System.out.println("BUSHES: " + (l.replaceAll("[^m]", "").length() > r.replaceAll("[^m]", "").length() ? "LEFT" : "RIGHT"));
            System.out.println();
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Forest().run();
    }

}