package practice;

import java.util.*;
import java.io.*;

public class pr93 {
    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/practice/pr93.dat".toLowerCase()));
        //Scanner f = new Scanner(System.in);

        ArrayList<Website> l = new ArrayList<>();
        int n = f.nextInt();
        while (n-- > 0) {
            l.add(new Website(f.next()));
        }
        Collections.sort(l);
        for (Website s : l) {
            System.out.println(s.toString());
        }

        f.close();
    }

    public static class Website implements Comparable<Website> {
        String s;

        Website(String s) {
            this.s = s;
        }

        @Override
        public int compareTo(Website o) {
            if (this.s.substring(s.indexOf(".")+1).compareTo(o.s.substring(o.s.indexOf(".")+1)) != 0) {
                return this.s.substring(s.indexOf(".")+1).compareTo(o.s.substring(o.s.indexOf(".")+1));
            }
            return this.s.substring(0, s.indexOf(".")).compareTo(o.s.substring(0, o.s.indexOf(".")));
        }

        public String toString() {
            return s;
        }
    }

    public static void main(String[] args) throws Exception {
        new pr93().run();
    }

}