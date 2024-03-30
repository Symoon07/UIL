package b2018;

import java.util.*;
import java.io.*;

public class Peter {
    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/b2018/peter.dat"));
        //Scanner f = new Scanner(System.in);

        while (f.hasNext()) {

            int price = f.nextInt();
            int total = price;
            String out = "";
            f.nextLine();
            String[] in = f.nextLine().split(" ");
            int[] vals = new int[in.length];
            for (int i = 0; i < in.length; i++) {
                vals[i] = Integer.parseInt(in[i]);
            }
            int index = vals.length-1;
            int coins = 0;
            while (total > 0) {
                if (vals[index] <= total) {
                    out = vals[index] + " " + out;
                    total -= vals[index];
                    coins++;
                }
                else {
                    index--;
                }
            }

            System.out.println(price + " " + coins + " " + out);

        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Peter().run();
    }

}