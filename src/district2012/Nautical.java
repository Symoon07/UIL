package district2012;

import java.util.*;
import java.io.*;

public class Nautical {

    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/district2012/Nautical.dat".toLowerCase()));
        //Scanner f = new Scanner(System.in);

        int cases = f.nextInt();
        while (cases-- > 0) {
            int nMile = f.nextInt();
            System.out.printf("%.1f\n", nMile * 1.15);
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Nautical().run();
    }

}