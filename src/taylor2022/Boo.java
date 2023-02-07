package taylor2022;

import java.util.*;
import java.io.*;

public class Boo {
    public void run() throws Exception {
        //Scanner f = new Scanner(new File("template.dat"));
        Scanner f = new Scanner(System.in);

        String in = f.next();
        for (int i = 0; i < in.length(); i++) {
            if (in.charAt(i) == 'N') {
                System.out.println("Nobody's There");
            }
            else {
                System.out.println("Boo!");
            }
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Boo().run();
    }

}