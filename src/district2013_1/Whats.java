package district2013_1;

import java.util.*;
import java.io.*;

public class Whats {

    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/district2013_1/Whats.dat".toLowerCase()));
        //Scanner f = new Scanner(System.in);

        int n = f.nextInt(); f.nextLine();
        while (n-- > 0) {
            String[] line = f.nextLine().split(" ");
            ArrayList<Diff> l = new ArrayList<>();
            int prev = 0;
            for (int i = 0; i < line.length; i++) {
                l.add(new Diff(Integer.parseInt(line[i]) - prev, i));
                prev = Integer.parseInt(line[i]);
            }
            Collections.sort(l);
            for (int i = 0; i < 4; i++) {
                System.out.println(l.get(i));
            }
            System.out.println();
        }

        f.close();
    }

    public class Diff implements Comparable<Diff> {
        int diff;
        int day;

        public Diff(int diff, int day) {
            this.diff = diff;
            this.day = day;
        }

        @Override
        public int compareTo(Diff o) {
            return diff - o.diff;
        }

        public String toString() {
            return diff + " " + day;
        }
    }

    public static void main(String[] args) throws Exception {
        new Whats().run();
    }

}