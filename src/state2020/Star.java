package state2020;

import java.util.*;
import java.io.*;

public class Star {
    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/state2020/Star.dat"));
        //Scanner f = new Scanner(System.in);

        int p = f.nextInt(), n = f.nextInt(), i = f.nextInt();
        HashMap<String, HashSet<String>> g = new HashMap<>();
        HashMap<String, Planets> planets = new HashMap<>();
        while (p --> 0) {
            String name = f.next();
            g.put(name, new HashSet<>());
            planets.put(name, new Planets(name, f.nextDouble(), f.nextDouble(), f.nextDouble()));
        }
        while (n --> 0) {
            String a = f.next();
            String b = f.next();
            g.get(a).add(b);
            g.get(b).add(a);
        }
        while (i --> 0) {
            String start = f.next();
            String end = f.next();
            double dis = -1;
            PriorityQueue<Node> pq = new PriorityQueue<>();
            HashSet<String> v = new HashSet<>();
            pq.add(new Node(start, 0));
            while (!pq.isEmpty()) {
                Node cur = pq.poll();
                if (v.contains(cur.name)) {
                    continue;
                }
                if (cur.name.equals(end)) {
                    dis = cur.dis;
                    break;
                }
                v.add(cur.name);
                for (String next : g.get(cur.name)) {
                    pq.add(new Node(next, cur.dis + planets.get(cur.name).dis(planets.get(next))));
                }
            }
            System.out.println(dis == -1 ? "These are not the planets you're looking for." : String.format("%s -> %s : %,.3f", start, end, dis));
        }

        f.close();
    }

    public class Planets {
        String name;
        double x, y, z;

        public Planets(String n, double x, double y, double z) {
            name = n;
            this.x = x;
            this.y = y;
            this.z = z;
        }

        public double dis(Planets o) {
            return Math.sqrt(Math.pow(x - o.x, 2) + Math.pow(y - o.y, 2) + Math.pow(z - o.z, 2));
        }
    }

    public class Node implements Comparable<Node> {
        String name;
        double dis;

        public Node(String n, double d) {
            name = n;
            dis = d;
        }

        @Override
        public int compareTo(Node o) {
            return Double.compare(dis, o.dis);
        }
    }

    public static void main(String[] args) throws Exception {
        new Star().run();
    }
}