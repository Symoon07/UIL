package clements2023;

import java.util.*;
import java.io.*;

public class Spices {
    String colors = "WhiteRedBrownOrangeBlue";

    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/clements2023/Spices.dat"));
        //Scanner f = new Scanner(System.in);

        int n = f.nextInt();
        ArrayList<Spice> l = new ArrayList<>();
        while (n --> 0) {
            l.add(new Spice(f.next(), f.nextInt(), f.nextInt(), f.next()));
        }
        Collections.sort(l);
        for (Spice s : l) {
            System.out.println(s);
        }

        f.close();
    }

    public class Spice implements Comparable<Spice> {
        String name;
        int amount;
        int rating;
        int color;

        public Spice(String n, int a, int r, String c) {
            name = n;
            amount = a;
            rating = r;
            color = colors.contains(c) ? colors.indexOf(c) : Integer.MAX_VALUE;
        }

        @Override
        public int compareTo(Spice o) {
            if (rating == o.rating) {
                if (color == o.color) {
                    if (amount == o.amount) {
                        return name.compareTo(o.name);
                    }
                    return o.amount - amount;
                }
                return color - o.color;
            }
            return o.rating - rating;
        }

        public String toString() {
            return name;
        }
    }

    public static void main(String[] args) throws Exception {
        new Spices().run();
    }

}