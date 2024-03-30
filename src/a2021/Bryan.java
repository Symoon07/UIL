package a2021;

import java.util.*;
import java.io.*;

public class Bryan {
    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/Input/bryan.dat"));
        //Scanner f = new Scanner(System.in);

        int cases = f.nextInt();
        while (cases-- > 0) {

            int sum = 0;
            int transactions = f.nextInt();
            for (int j = 0; j < transactions; j++) {
                f.next();
                sum += f.nextInt();
            }

            if (sum > 0) {
                System.out.println("Wow, Bryan saved $" + Math.abs(sum));
            }
            else if (sum < 0) {
                System.out.println("Oh no! Bryan had to borrow $" + Math.abs(sum));
            }
            else {
                System.out.println("Phew, broke even!");
            }

        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Bryan().run();
    }

}