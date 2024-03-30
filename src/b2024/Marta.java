package b2024;

import java.util.*;
import java.io.*;

public class Marta {
    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/b2024/Marta.dat"));
        //Scanner f = new Scanner(System.in);

        int t = f.nextInt();
        for (int i = 1; i <= t; i++) {
            int n = f.nextInt(), p = f.nextInt();
            int[] nums = new int[n];
            for (int j = 0; j < n; j++) {
                nums[j] = f.nextInt();
            }
            boolean swapped;
            int iter = 0;
            for (int j = 0; j < p; j++) {
                swapped = false;
                iter++;
                for (int k = 0; k < n - j - 1; k++) {
                    if (nums[k] > nums[k + 1]) {
                        int temp = nums[k];
                        nums[k] = nums[k + 1];
                        nums[k + 1] = temp;
                        swapped = true;
                    }
                }
                if (!swapped) {
                    break;
                }
            }
            System.out.print("Test case " + i + " pass " + iter + ": ");
            for (int j = 0; j < nums.length; j++) {
                System.out.print(nums[j] + " ");
            }
            System.out.println();
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Marta().run();
    }
}