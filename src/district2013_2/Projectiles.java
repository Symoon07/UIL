package district2013_2;

import java.util.*;
import java.io.*;

public class Projectiles {

    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/district2013_2/Projectiles.dat".toLowerCase()));
        //Scanner f = new Scanner(System.in);

        int n = f.nextInt();
        while (n-- > 0) {
            int V = f.nextInt();
            int c = f.nextInt();
            int t = (int) Math.round(V / 32.0);
            System.out.println("HEIGHT " + (int) (V * t - (16 * Math.pow(t, 2)) + c) + " TIME " + t);
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Projectiles().run();
    }

}