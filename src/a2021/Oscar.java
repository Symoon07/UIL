package a2021;

import java.util.*;
import java.io.*;

public class Oscar {
    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/Input/oscar.dat"));
        //Scanner f = new Scanner(System.in);

        int cases = f.nextInt();
        f.nextLine();
        while (cases-- > 0 ) {

            String[] in = f.nextLine().split(" ");
            int cur = 0;
            for (int j = 1; j < in.length; j+=2) {
                if (Integer.parseInt(in[j]) >= cur) {
                    System.out.print(in[j-1] + " ");
                    cur = Integer.parseInt(in[j]);
                }
            }

            System.out.println();

        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Oscar().run();
    }

}