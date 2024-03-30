package slhs2023;

import java.util.*;
import java.io.*;

public class P3 {

    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/slhs2023/P3/judgein2.txt".toLowerCase()));
        //Scanner f = new Scanner(System.in);

        int n = f.nextInt();
        int m = f.nextInt(); f.nextLine();
        int out = 0;
        String[] pirates = f.nextLine().split(" ");
        String[] swords = f.nextLine().split(" ");
        ArrayList<Pirate> l = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            l.add(new Pirate(Integer.parseInt(pirates[i]), Integer.parseInt(swords[i])));
        }
        Collections.sort(l);
        for (int i = 0; i < l.size() && m >= 0; i++) {
            if (m - l.get(i).str > 0) {
                m -= l.get(i).str;
                out += l.get(i).swords;
            }
        }
        System.out.println(out);

        f.close();
    }

    public class Pirate implements Comparable<Pirate> {
        int str;
        int swords;
        int tstr;

        public Pirate(int str, int swords) {
            this.str = str;
            this.swords = swords;
            this.tstr = swords == 2 ? str : str * 2;
        }

        @Override
        public int compareTo(Pirate o) {
            if (tstr == o.tstr) {
                return o.swords - swords;
            }
            return tstr - o.tstr;
        }

        public String toString() {
            return str + " " + swords;
        }
    }

    public static void main(String[] args) throws Exception {
        new P3().run();
    }

}