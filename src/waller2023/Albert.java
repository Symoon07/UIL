package waller2023;

import java.util.*;
import java.io.*;

public class Albert {
    
    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/waller2023/Albert.dat"));

        //Scanner f = new Scanner(System.in);

        int n = f.nextInt(); f.nextLine();
        while (n --> 0) {
            System.out.println(f.nextLine() + "!!!");
        }

        f.close();
    }
    
    public static void main(String[] args) throws Exception {
        new Albert().run();
    }

}