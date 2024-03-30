package cw2017;

import java.util.*;
import java.io.*;

public class Sand {

    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/cw2017/Sand.dat".toLowerCase()));
        //Scanner f = new Scanner(System.in);

        int n = f.nextInt(); f.nextLine();
        while (n-- > 0) {
            int s = f.nextInt(); f.nextLine();
            while (s-- > 0) {
                String str = f.nextLine().replaceAll(" ", "").toLowerCase();
                System.out.println(str.contains("sand") ? "I HATE SAND!!!" : "Here everything is soft and smooth.");
            }
            System.out.println();
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Sand().run();
    }

}