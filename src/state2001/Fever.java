package state2001;

import java.util.*;
import java.io.*;

public class Fever {

    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/state2001/Fever.dat".toLowerCase()));
        //Scanner f = new Scanner(System.in);

        while (f.hasNext()) {
            int P = f.nextInt();
            int W = f.nextInt();
            int C = f.nextInt();
            double ratio = (double) P / W;
            int out = (int) Math.floor(ratio * C);
            System.out.println(out == 0 ? "Consult your child's pediatrician." : out);
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Fever().run();
    }

}