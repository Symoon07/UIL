package amc2024;

import java.util.*;
import java.io.*;

public class Cyclist {
    String[] nums = {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/amc2024/Cyclist.dat"));
        //Scanner f = new Scanner(System.in);

        int t = f.nextInt();
        ArrayList<Integer> l = new ArrayList<>();
        while (t --> 0) {
            int n = f.nextInt();
            l.add(n);
            if (n == 9) {
                Collections.sort(l);
                System.out.print("[");
                for (int i = 0; i < l.size() - 1; i++) {
                    System.out.print(nums[l.get(i)] + ",");
                }
                System.out.println("nine]");
                l.clear();
            }
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Cyclist().run();
    }
}