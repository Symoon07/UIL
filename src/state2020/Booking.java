package state2020;

import java.util.*;
import java.io.*;

public class Booking {
    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/state2020/Booking.dat"));
        //Scanner f = new Scanner(System.in);

        int t = f.nextInt();
        while (t --> 0) {
            int n = f.nextInt();
            ArrayList<Patron> l = new ArrayList<>();
            while (n --> 0) {
                l.add(new Patron(f.next(), f.next(), f.nextInt()));
            }
            Collections.sort(l);
            for (Patron p : l) {
                System.out.println(p);
            }
            System.out.println();
        }

        f.close();
    }

    public class Patron implements Comparable<Patron> {
        String first;
        String last;
        int floor;

        public Patron(String fn, String ln, int f) {
            first = fn;
            last = ln;
            floor = f;
        }

        @Override
        public int compareTo(Patron o) {
            if (floor == o.floor) {
                return (last + first).compareTo((o.last + o.first));
            }
            return floor - o.floor;
        }

        public String toString() {
            return first + " " + last;
        }
    }

    public static void main(String[] args) throws Exception {
        new Booking().run();
    }
}