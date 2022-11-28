package clements2022;

import java.io.*;
import java.util.*;

public class TurkeyRace {

    public static void main(String[] args) throws Exception {
        new TurkeyRace().run();
    }

    public void run() throws Exception {
        Scanner file = new Scanner(new File("Data/clements2022/turkeyrace.in"));
        //Scanner file = new Scanner(System.in);

        long cases = file.nextLong();
        while (cases-- > 0) {

            int turkeys = file.nextInt();
            int time = file.nextInt();
            int[] arr = new int[turkeys];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = file.nextInt();
            }

            while (time-- > 0) {
                int[] og = arr.clone();
                for (int i = 0; i < arr.length; i++) {
                    int left = i - 1;
                    int right = i + 1;
                    if (left >= 0 && right < arr.length) {
                        if (og[right] < og[i] || og[left] < og[i]) {
                            arr[i] = og[i] - 2;
                        }
                        else {
                            arr[i] = og[i] + 1;
                        }
                    }
                    else if (left >= 0) {
                        if (og[left] < og[i]) {
                            arr[i] = og[i] - 2;
                        }
                        else {
                            arr[i] = og[i] + 1;
                        }
                    }
                    else if (right < arr.length) {
                        if (og[right] < og[i]) {
                            arr[i] = og[i] - 2;
                        }
                        else {
                            arr[i] = og[i] + 1;
                        }
                    }
                }
            }
            int max = 0;
            for (int i : arr) {
                max = Math.max(i, max);
            }

            String out = "";
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == max) {
                    out += (i+1) + " ";
                }
            }
            out = out.trim();
            System.out.println(out);

        }

        file.close();
    }
}