package waller2022;

import java.util.*;
import java.io.*;

public class Zero {
    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/waller2022/Zero.dat"));
        //Scanner f = new Scanner(System.in);

        String word = f.next();
        System.out.println("THE STRING WAS " + word);
        for (int i = 0; i < word.length(); i++) {
            for (int j = 0; j < word.length(); j++) {
                System.out.print(word.charAt(i));
            }
            System.out.println();
        }

        int index = word.length()-1;
        for (int i = word.length()-1; i >= 0; i--) {
            for (int j = word.length()-1; j >= 0; j--) {
                if (i == index && j == index) {
                    System.out.print(word.charAt(index));
                }
                else {
                    System.out.print(" ");
                }
            }
            System.out.println();
            index--;
        }

        index = 0;
        for (int i = 0; i < word.length(); i++) {
            for (int j = 0; j < word.length(); j++) {
                if (i == index && word.length()-j-1 == index) {
                    System.out.print(word.charAt(index));
                }
                else {
                    System.out.print(" ");
                }
            }
            System.out.println();
            index++;
        }

        for (int i = word.length()-1; i >= 0; i--) {
            for (int j = 0; j < word.length(); j++) {
                System.out.print(word.charAt(i));
            }
            System.out.println();
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Zero().run();
    }

}