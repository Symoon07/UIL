package state2012;

import java.util.*;
import java.io.*;

public class Burpees {
    
    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/state2012/Burpees.dat".toLowerCase()));
        //Scanner f = new Scanner(System.in);

        int n = f.nextInt();
        while (n-- > 0) {
            int m = f.nextInt();
            System.out.println(m * (m + 1) / 2);
        }

        f.close();
    }
    
    public static void main(String[] args) throws Exception {
        new Burpees().run();
    }

}