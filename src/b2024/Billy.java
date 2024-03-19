package b2024;

import java.util.*;
import java.io.*;

public class Billy {
    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/b2024/Billy.dat"));
        //Scanner f = new Scanner(System.in);

        String best = "";
        double per = 0;
        while (f.hasNext()) {
            String n = f.nextLine();
            double p = (double) f.nextInt() / f.nextInt(); f.nextLine();
            if (p > per) {
                best = n;
                per = p;
            }
        }
        System.out.println(best);

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Billy().run();
    }
}