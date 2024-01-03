package state2018;

import java.util.*;
import java.io.*;

public class Dinesh {
    HashMap<String, ArrayList<Edge>> hm;
    int dis;
    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/state2018/Dinesh.dat"));
        //Scanner f = new Scanner(System.in);

        int t = f.nextInt(); f.nextLine();
        while (t --> 0) {
            String[] nodes = f.nextLine().split(" ");
            hm = new HashMap<>();
            for (String node : nodes) {
                hm.put(node, new ArrayList<>());
            }
            int n = f.nextInt(); f.nextLine();
            while (n --> 0) {
                String a = f.next();
                String b = f.next();
                int w = f.nextInt(); f.nextLine();
                ArrayList<Edge> l = hm.get(a);
                l.add(new Edge(b, w));
                hm.put(a, l);
                l = hm.get(b);
                l.add(new Edge(a, w));
                hm.put(b, l);
            }
            n = f.nextInt(); f.nextLine();
            while (n --> 0) {
                String start = f.next();
                String end = f.next(); f.nextLine();
                dis = Integer.MAX_VALUE;
                recur(start, end, 0, new HashSet<>());
                System.out.println(start + " to " + end + ":" + dis);
            }
        }

        f.close();
    }

    public void recur(String cur, String end, int d, HashSet<String> visited) {
        if (visited.contains(cur) || d >= dis) {
            return;
        }
        if (cur.equals(end)) {
            dis = d;
            return;
        }
        visited.add(cur);
        for (Edge e : hm.get(cur)) {
            recur(e.des, end, d + e.dis, visited);
        }
        visited.remove(cur);
    }

    public class Edge {
        String des;
        int dis;

        public Edge(String d, int di) {
            des = d;
            dis = di;
        }
    }

    public static void main(String[] args) throws Exception {
        new Dinesh().run();
    }
}