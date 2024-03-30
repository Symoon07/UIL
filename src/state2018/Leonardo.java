package state2018;

import java.util.*;
import java.io.*;

public class Leonardo {

    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/state2018/Leonardo.dat"));
        //Scanner f = new Scanner(System.in);

        while (f.hasNext()) {
            String[] line = f.nextLine().split(" = ");
            String[] first = line[0].split(" ");
            String[] last = line[1].split(" ");
            String out = "";
            for (String s : first) {
                out += s.charAt(0);
            }
            out += " = ";
            for (String s : last) {
                out += s.substring(s.length()-1).toUpperCase();
            }
            System.out.println(out);
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Leonardo().run();
    }

}