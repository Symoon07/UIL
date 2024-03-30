package a2020;

import java.util.*;
import java.io.*;

public class Sebastian {
    class Word implements Comparable<Word> {
        public String word;

        public Word(String word) {
            this.word = word;
        }

        @Override
        public int compareTo(Word o) {
            return ascii(this.word) - ascii(o.word);
        }
    }

    public int ascii(String str) {
        int sum = 0;
        for (int i = 0; i < str.length(); i++) {
            sum += str.charAt(i);
        }

        return sum;
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/a2020/sebastian.dat"));
        //Scanner f = new Scanner(System.in);

        TreeSet<Word> set = new TreeSet<>();
        while (f.hasNext()) {
            set.add(new Word(f.next()));
        }

        for (Word word : set) {
            System.out.println(word.word);
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Sebastian().run();
    }

}