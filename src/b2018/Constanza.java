package b2018;

import java.util.*;
import java.io.*;

public class Constanza {
    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/b2018/constanza.dat"));
        //Scanner f = new Scanner(System.in);

        String[] colors = {"red", "orange", "yellow", "green", "blue", "indigo", "violet"};
        int[] count = new int[7];
        while (f.hasNext()) {
            String in = f.next();
            switch (in) {
                case "red" -> count[0]++;
                case "orange" -> count[1]++;
                case "yellow" -> count[2]++;
                case "green" -> count[3]++;
                case "blue" -> count[4]++;
                case "indigo" -> count[5]++;
                case "violet" -> count[6]++;
            }
        }

        String star = "*";
        for (int i = 0; i < colors.length; i++) {
            System.out.printf("%-7s%s%n", colors[i], star.repeat(count[i]));
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Constanza().run();
    }

}