package cw2017;

import java.util.*;
import java.io.*;

public class Reindeer {

    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/cw2017/Reindeer.dat".toLowerCase()));
        //Scanner f = new Scanner(System.in);

        int n = f.nextInt();
        while (n-- > 0) {
            int k = f.nextInt();
            ArrayList<Deer> l = new ArrayList<>();
            while (k-- > 0) {
                l.add(new Deer(f.next(), f.nextInt(), f.nextInt(), f.nextInt(), f.nextInt(), f.nextInt(), f.next()));
            }
            Collections.sort(l);
            if (l.get(0).name.equals("Sammy")) {
                l.remove(0);
            }
            for (int i = 0; i < l.size() && i < 12; i++) {
                System.out.println(l.get(i).name);
            }
            System.out.println();
        }

        f.close();
    }

    public static class Deer implements Comparable<Deer> {
        String name;
        int nav;
        int stam;
        int stren;
        int fluff;
        int ant;
        boolean spot;

        public Deer(String n, int na, int sta, int str, int f, int a, String s) {
            name = n;
            nav = na;
            stam = sta;
            stren = str;
            fluff = f;
            ant = a;
            spot = s.equals("true");

        }

        @Override
        public int compareTo(Deer o) {
            if (name.equals("Sammy")) {
                return 1;
            }
            if (name.equals("Rudolph")) {
                return -1;
            }
            if (nav == o.nav) {
                if (stam == o.stam) {
                    if (stren == o.stren) {
                        if (fluff == o.fluff) {
                            if (ant == o.ant) {
                                if (spot == o.spot) {
                                    return o.name.compareTo(name);
                                }
                                if (spot) {
                                    return -1;
                                }
                                return 1;
                            }
                            return ant - o.ant;
                        }
                        return o.fluff - fluff;
                    }
                    return o.stren - stren;
                }
                return o.stam - stam;
            }
            return o.nav - nav;
        }

        public String toString() {
            return name;
        }
    }

    public static void main(String[] args) throws Exception {
        new Reindeer().run();
    }

}