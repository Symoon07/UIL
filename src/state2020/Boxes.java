package state2020;

import java.util.*;
import java.io.*;

public class Boxes {
    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/state2020/Boxes.dat"));
        //Scanner f = new Scanner(System.in);

        int t= f.nextInt(); f.nextLine();
        while (t --> 0) {
            String s = f.nextLine();
            int B = s.length() - s.replaceAll("B", "").length();
            int b = s.length() - s.replaceAll("b", "").length();
            System.out.println("B".repeat(B) + s.replaceAll("[Bb]", "") + "b".repeat(b));
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Boxes().run();
    }
}