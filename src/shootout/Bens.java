package shootout;

import java.util.*;
import java.io.*;

public class Bens {

    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/shootout/Bens.dat".toLowerCase()));
        //Scanner f = new Scanner(System.in);

        int t = f.nextInt();
        while (t --> 0) {
            int x = f.nextInt();
            ArrayList<Ben> l = new ArrayList<>();
            while (x --> 0) {
                String n = f.next() + " " + f.next();
                double s = f.nextDouble();
                int r = Math.abs(f.nextInt() - f.nextInt());
                double len = f.nextDouble();
                l.add(new Ben(n, s, r, len));
            }
            Collections.sort(l);
            for (int i = 0; i < l.size(); i++) {
                System.out.print(l.get(i));
                if (i != l.size()-1) {
                    System.out.print(", ");
                }
            }
            System.out.println();
        }

        f.close();
    }

    public class Ben implements Comparable<Ben> {
        String name;
        double s;
        int r;
        double l;

        public Ben(String n, double s, int r, double l) {
            name = n;
            this.s = s;
            this.r = r;
            this.l = l;
        }

        @Override
        public int compareTo(Ben o) {
            if (this.s == o.s) {
                if (this.r == o.r) {
                    return (int) Math.ceil(this.l - o.l);
                }
                return this.r - o.r;
            }
            return this.s - o.s < 0 ? (int) Math.floor(this.s - o.s) : (int) Math.ceil(this.s - o.s);
        }

        public String toString() {
            return name;
        }
    }

    public static void main(String[] args) throws Exception {
        new Bens().run();
    }

}