package taylor2022;

import java.util.*;
import java.io.*;

public class Calories {
    public void run() throws Exception {
        //Scanner f = new Scanner(new File("template.dat"));
        Scanner f = new Scanner(System.in);

        int cases = f.nextInt();
        while (cases-- > 0) {

            f.next();
            int goal = f.nextInt();
            int start = f.nextInt();
            start += f.nextInt();
            while (f.hasNextInt()) {
                start += f.nextInt();
            }

            System.out.println(start == goal ? "He needs to maintain his weight": start > goal ? "He needs to lose " + (start - goal) + " calories" :
                    "He needs to gain " + (goal - start) + " calories");

        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Calories().run();
    }

}