package state1999;

import java.util.*;
import java.io.*;

public class Binary {
    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/state1999/binary.dat"));
        //Scanner f = new Scanner(System.in);

        while (f.hasNext()) {
            String s = f.next();
            System.out.println(s + " = " + Integer.parseInt(s, 2));
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Binary().run();
    }

}