package cw2017;

import java.util.*;
import java.io.*;

public class Yoda {

    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/cw2017/Yoda.dat"));
        //Scanner f = new Scanner(System.in);

        while (f.hasNext()) {
            String[] line = f.nextLine().split(" ");
            String out = "";
            for (int i = 2; i < line.length; i++) {
                out += line[i] + " ";
            }
            out = out.substring(0,1).toUpperCase() + out.substring(1).trim() + ", ";
            out += line[0].substring(0,1).toLowerCase() + line[0].substring(1) + " " + line[1];
            System.out.println(out);
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Yoda().run();
    }

}