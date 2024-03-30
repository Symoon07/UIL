package state2020;

import java.util.*;
import java.io.*;

public class Currency {
    HashMap<String, ArrayList<Edge>> g;
    double rate;
    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/state2020/Currency.dat"));
        //Scanner f = new Scanner(System.in);

        int t = f.nextInt();
        while (t --> 0) {
            int n = f.nextInt();
            g = new HashMap<>();
            while (n --> 0) {
                g.put(f.next(), new ArrayList<>());
            }
            n = f.nextInt();
            while (n --> 0) {
                String u = f.next();
                String v = f.next();
                double r = f.nextDouble();
                g.get(u).add(new Edge(v, r));
                g.get(v).add(new Edge(u, 1.0 / r));
            }
            String start = f.next();
            String end = f.next();
            rate = -1;
            recur(start, end, 1, new HashSet<>());
            System.out.println(rate == -1 ? "NO CONVERSION RATE AVAILABLE." : String.format("%.2f", rate));
        }

        f.close();
    }

    public void recur(String cur, String end, double r, HashSet<String> v) {
        if (v.contains(cur)) {
            return;
        }
        if (cur.equals(end)) {
            rate = r;
            return;
        }
        v.add(cur);
        for (Edge e : g.get(cur)) {
            recur(e.des, end, r * e.dis, v);
        }
    }

    public class  Edge {
        String des;
        double dis;

        public Edge(String de, double di) {
            des = de;
            dis = di;
        }
    }
    
    public static void main(String[] args) throws Exception {
        new Currency().run();
    }
}