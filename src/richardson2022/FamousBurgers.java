package richardson2022;

import java.util.*;
import java.io.*;

public class FamousBurgers {
    public int factorial(int n)
    {
        if(n == 0)
            return 1;
        else
            return(n*factorial(n-1));
    }

    public void run() throws Exception {
        //Scanner f = new Scanner(new File("template.dat"));
        Scanner f = new Scanner(System.in);

        int n = f.nextInt();
        int r = f.nextInt();
        System.out.println( factorial(n) /
                (factorial(r) * factorial((n - r))) % 2022 );

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new FamousBurgers().run();
    }

}