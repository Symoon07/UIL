package taylor2022;

import java.util.*;
import java.io.*;

public class TakeOne {
    public void run() throws Exception {
        //Scanner f = new Scanner(new File("template.dat"));
        Scanner f = new Scanner(System.in);

        int cases = f.nextInt();
        int total = f.nextInt();
        while (cases-- > 0) {
            total -= f.nextInt();
        }

        System.out.println(total > 0 ? total : "no more candy");

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new TakeOne().run();
    }

}