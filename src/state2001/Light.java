package state2001;

import java.util.*;
import java.io.*;

public class Light {

    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/state2001/Light.dat".toLowerCase()));
        //Scanner f = new Scanner(System.in);

        while (f.hasNext()) {
            boolean[] l = new boolean[3];
            for (int i = 0; i < 3; i++) {
                String s = f.next();
                if (s.equals("u")) {
                    l[i] = true;
                }
            }
            int t = f.nextInt();
            while (t --> 0) {
                int n = f.nextInt() - 1;
                l[n] ^= true;
            }
            int on = 0;
            for (int i = 0; i < 3; i++) {
                if (l[i]) {
                    on++;
                }
            }
            System.out.println(on == 1 || on == 3 ? "on" : "off");
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Light().run();
    }

}