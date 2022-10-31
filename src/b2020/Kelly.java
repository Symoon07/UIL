package b2020;

import java.util.*;
import java.io.*;

public class Kelly {
    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/Input/kelly.dat"));
        //Scanner f = new Scanner(System.in);

        while (f.hasNextLine()) {

            String[] in = f.nextLine().split(" ");
            String out = "";
            for (int i = 0; i < in.length; i+=2) {
                int one = Integer.parseInt(in[i]);
                int two = Integer.parseInt(in[i+1]);
                int assci = (one - 1) * 5 + two + 65;
                if (assci < 76) {
                    assci--;
                }
                if (assci == 59) {
                    out += " ";
                }
                else {
                    out += Character.toString(assci);
                }
            }

            System.out.println(out);

        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Kelly().run();
    }

}