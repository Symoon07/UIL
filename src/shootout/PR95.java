package shootout;

import java.util.*;
import java.io.*;

public class PR95 {
    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/shootout/PR95.dat"));
        //Scanner f = new Scanner(System.in);

        int n = f.nextInt();
        ArrayList<Birthday> l = new ArrayList<>();
        while (n-- > 0) {
            int month = f.nextInt();
            int day = f.nextInt();
            int year = f.nextInt();
            String name = f.next();
            l.add(new Birthday(name, year, month, day));
        }
        Collections.sort(l);
        for (Birthday s : l) {
            System.out.println(s.toString());
        }

        f.close();
    }

    public static class Birthday implements Comparable<Birthday> {
        String name;
        int year;
        int month;
        int day;

        public Birthday(String n, int y, int m, int d) {
            name = n;
            year = y;
            month = m;
            day = d;
        }

        @Override
        public int compareTo(Birthday o) {
            if (this.year == o.year) {
                if (this.month == o.month) {
                    if (this.day == o.day) {
                        return this.name.compareTo(o.name);
                    }
                    return this.day - o.day;
                }
                return this.month - o.month;
            }
            return this.year - o.year;
        }

        public String toString() {
            return name;
        }
    }

    public static void main(String[] args) throws Exception {
        new PR95().run();
    }

}