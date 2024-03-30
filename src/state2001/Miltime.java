package state2001;
import java.util.*;
import java.io.*;

public class Miltime {

    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/state2001/Miltime.dat".toLowerCase()));
        //Scanner f = new Scanner(System.in);

        while (f.hasNext()) {
            int t = f.nextInt();
            int h = t / 3600;
            t %= 3600;
            int m = t / 60;
            t %= 60;
            System.out.printf("%02d:%02d:%02d\n", h, m, t);
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Miltime().run();
    }

}