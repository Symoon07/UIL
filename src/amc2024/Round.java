package amc2024;

import java.util.*;
import java.io.*;

public class Round {
    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/amc2024/Round.dat"));
        //Scanner f = new Scanner(System.in);

        int t = f.nextInt();
        while (t --> 0) {
            System.out.println((int) (f.nextInt() * 105600 / f.nextDouble()));
        }

        f.close();
    }
    
    public static void main(String[] args) throws Exception {
        new Round().run();
    }
}