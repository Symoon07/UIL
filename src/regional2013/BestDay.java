package regional2013;

import java.util.*;
import java.io.*;

public class BestDay {
    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/Input/bestday.dat"));
        //Scanner f = new Scanner(System.in);

        int cases = f.nextInt();
        for (int i = 0; i < cases; i++) {

            int[] sales = new int[7];
            int day = -1;
            int max = 0;
            for (int j = 0; j < sales.length; j++) {
                sales[j] = f.nextInt();
                if (sales[j] > max) {
                    max = sales[j];
                    day = j;
                }
            }
            String[] days = "SUNDAY MONDAY TUESDAY WEDNESDAY THURSDAY FRIDAY SATURDAY".split(" ");
            System.out.println(days[day]);

        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new BestDay().run();
    }

}