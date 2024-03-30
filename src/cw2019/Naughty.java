package cw2019;

import java.util.*;
import java.io.*;

public class Naughty {
    public double accuracy(String correct, String str) {
        int numCorrect = 0;
        for (int i = 0; i < correct.length(); i++) {
            if (correct.charAt(i) == str.charAt(i)) {
                numCorrect++;
            }
        }

        return Math.round(numCorrect * 100.0 / correct.length());
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/Input/naughty.dat"));
        //Scanner f = new Scanner(System.in);

        int cases = f.nextInt();
        while (cases-- > 0) {

            String strCorrect = null;
            int numWords = f.nextInt()-1;
            String correct = f.next();
            int accuracy = 0;
            for (int i = 0; i < numWords; i++) {
                String word = f.next();
                if (accuracy(correct, word) > accuracy) {
                    strCorrect = word;
                    accuracy = (int)accuracy(correct, strCorrect);
                }
            }

            System.out.println(accuracy != 0 ? strCorrect + "\nAccuracy Percentage : " + accuracy  + "%": "FAILED\nAccuracy Percentage : NaN");
            System.out.println();

        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Naughty().run();
    }

}