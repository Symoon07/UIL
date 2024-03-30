package shootout;

import java.util.*;
import java.io.*;

public class Downsize {

    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/shootout/Downsize.dat".toLowerCase()));
        //Scanner f = new Scanner(System.in);

        int n = f.nextInt();
        while (n --> 0) {
            System.out.println(f.next().replaceAll("[0-9]", ""));
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Downsize().run();
    }

}