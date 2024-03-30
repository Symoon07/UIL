package state2013;

import java.util.*;
import java.io.*;

public class Sort {
    String alpha;

    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/state2013/Sort.dat".toLowerCase()));
        //Scanner f = new Scanner(System.in);

        int t = f.nextInt();
        while (t --> 0) {
            TreeSet<Word> ts = new TreeSet<>();
            alpha = f.next();
            int n = f.nextInt();
            while (n --> 0) {
                ts.add(new Word(f.next()));
            }
            for (Word w : ts) {
                System.out.println(w);
            }
            System.out.println();
        }

        f.close();
    }

    public class Word implements Comparable<Word> {
        String word;

        public Word(String w) {
            word = w;
        }

        @Override
        public int compareTo(Word o) {
            for (int i = 0; i < word.length() && i < o.word.length(); i++) {
                if (alpha.indexOf(word.charAt(i)) != alpha.indexOf(o.word.charAt(i))) {
                    return alpha.indexOf(word.charAt(i)) - alpha.indexOf(o.word.charAt(i));
                }
            }
            return word.length() < o.word.length() ? -1 : 1;
        }

        public String toString() {
            return word;
        }
    }

    public static void main(String[] args) throws Exception {
        new Sort().run();
    }

}