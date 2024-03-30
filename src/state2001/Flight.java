package state2001;

import java.util.*;
import java.io.*;

public class Flight {
    
    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/state2001/Flight.dat".toLowerCase()));
        //Scanner f = new Scanner(System.in);

        while (f.hasNext()) {
            String dir = f.next();
            int dis = f.nextInt();
            double d;
            if (dir.equals("W")) {
                d = dis / 480.0;
            }
            else if (dir.equals("E")) {
                d = dis / 540.0;
            }
            else {
                d = dis / 510.0;
            }
            System.out.printf("%.2f\n", .2 + .4 + d);
        }

        f.close();
    }
    
    public static void main(String[] args) throws Exception {
        new Flight().run();
    }

}