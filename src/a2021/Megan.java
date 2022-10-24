package a2021;

import java.util.*;
import java.io.*;

public class Megan {
    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/Input/megan.dat"));
        //Scanner f = new Scanner(System.in);

        int cases = f.nextInt();
        cases: for (int i = 1; i <= cases; i++) {

            String alpha = f.next();
            String[] words = f.next().split(",");
            for (int j = 0; j < words.length; j++) {
                String word = "";
                for (char c : words[j].toCharArray()) {
                    int index = alpha.indexOf(c);
                    word += (char)(97+index);
                }
                words[j] = word;
            }

            for (int j = 1; j < words.length; j++) {
                if (words[j].compareTo(words[j-1]) < 0) {
                    System.out.printf("Word List %d is not sorted.%n", i);
                    continue cases;
                }
            }

            System.out.printf("Word List %d is sorted.%n", i);

        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Megan().run();
    }

}