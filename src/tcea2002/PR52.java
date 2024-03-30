package tcea2002;

import java.util.*;
import java.io.*;

public class PR52 {

    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/tcea2002/PR52.dat".toLowerCase()));
        //Scanner f = new Scanner(System.in);

        int n = f.nextInt(); f.nextLine();
        while (n-- > 0) {
            String[] line = f.nextLine().split(" ");
            String out = "";
            for (int i = 0; i < line.length; i++) {
                if (out.trim().length() + line[i].length() > 15) {
                    System.out.println(out);
                    out = "";
                }
                out += line[i] + " ";
            }
            System.out.println(out);
            System.out.println();
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new PR52().run();
    }

}