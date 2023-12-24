package state2013;

import java.util.*;
import java.io.*;

public class Absolute {
    int[] old;
    int[] arr;

    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/state2013/Absolute.dat".toLowerCase()));
        //Scanner f = new Scanner(System.in);

        int n = f.nextInt();
        while (n-- > 0) {
            old = new int[4];
            arr = new int[4];
            for (int i = 0; i < old.length; i++) {
                old[i] = f.nextInt();
            }
            int m = 0;
            int out = old[0];
            while (!same()) {
                out = abs();
                m++;
            }
            System.out.println(m + " " + out);
        }

        f.close();
    }

    public int abs() {
        for (int i = 0; i < 4; i++) {
            if (i == 3) {
                arr[3] = Math.abs(old[0] - old[3]);
            }
            else {
                arr[i] = Math.abs(old[i] - old[i+1]);
            }
        }
        old = arr.clone();
        arr = new int[4];
        if (same()) {
            return old[0];
        }
        return -1;
    }

    public boolean same() {
        for (int i = 0; i < 3; i++) {
            if (old[i] != old[i+1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        new Absolute().run();
    }

}