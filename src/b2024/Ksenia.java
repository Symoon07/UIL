package b2024;

import java.util.*;
import java.io.*;

public class Ksenia {
    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/b2024/Ksenia.dat"));
        //Scanner f = new Scanner(System.in);

        int t = f.nextInt(); f.nextLine();
        while (t --> 0) {
            int V = f.nextInt(), E = f.nextInt(); f.nextLine();
            if (E != 0) {
                f.nextLine();
            }
            int m = f.nextInt(); f.nextLine();
            for (int i = 0; i < m; i++) {
                E = E * 2 + V;
                V *= 2;
            }
            System.out.println(V + " " + E);
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Ksenia().run();
    }
}