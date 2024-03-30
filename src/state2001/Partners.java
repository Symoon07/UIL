package state2001;

import java.util.*;
import java.io.*;

public class Partners {
    HashMap<String, ArrayList<String>> g;
    boolean found;

    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/state2001/Partners.dat".toLowerCase()));
        //Scanner f = new Scanner(System.in);

        g = new HashMap<>();
        int t = f.nextInt();
        while (t --> 0) {
            g.put(f.next(), new ArrayList<>());
        }
        t = f.nextInt();
        while (t --> 0) {
            String w = f.next();
            String u = f.next();
            ArrayList<String> l = g.get(w);
            l.add(u);
            g.put(w, l);
            l = g.get(u);
            l.add(w);
            g.put(u, l);
        }
        t = f.nextInt();
        while (t --> 0) {
            String start = f.next();
            String end = f.next();
            found = false;
            recur(start, end, new HashSet<>());
            System.out.println(found ? "PARTNERS" : "No miles for you");
        }

        f.close();
    }

    public void recur(String cur, String end, HashSet<String> visited) {
        if (visited.contains(cur)) {
            return;
        }
        if (cur.equals(end)) {
            found = true;
            return;
        }
        visited.add(cur);
        for (String next : g.get(cur)) {
            recur(next, end, visited);
        }
        visited.remove(cur);
    }

    public static void main(String[] args) throws Exception {
        new Partners().run();
    }

}