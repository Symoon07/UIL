package slhs2019;

import java.util.*;
import java.io.*;

public class Creeper {
    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/Input/creeper.dat"));
        //Scanner f = new Scanner(System.in);

        while (f.hasNextLine()) {

            String in = f.next().toLowerCase();
            String out = "";
            String creeper = "creeper";
            int i = 0;
            for (int j = 0; j < in.length(); j++) {
                if (i < creeper.length() && in.charAt(j) == creeper.charAt(i)) {
                    out += in.charAt(j);
                    i++;
                }
            }

            System.out.println(out.equals(creeper) ? "Aww Man" : "I Still Rule The World");

        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Creeper().run();
    }

}