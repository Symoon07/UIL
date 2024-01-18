package state2001;

import java.util.*;
import java.io.*;

public class Marbles {

    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/state2001/Marbles.dat".toLowerCase()));
        //Scanner f = new Scanner(System.in);

        int[] prize = {100, 500, 1000, 5000, 1000, 500, 100};
        while (f.hasNext()) {
            String s = f.next();
            boolean[] b = new boolean[28];
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == 'L') {
                    b[i] = true;
                }
            }
            int cur = 0;
            int level = 0;
            while (cur < 21) {
                cur = b[cur] ? cur + 1 + level : cur + 2 + level;
                level++;

            }
            System.out.println("$" + prize[cur - 21]);
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Marbles().run();
    }

}