package b2024;

import java.util.*;
import java.io.*;

public class Sofia {
    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/b2024/Sofia.dat"));
        //Scanner f = new Scanner(System.in);

        int n = f.nextInt(), m = f.nextInt();
        HashMap<String, ArrayList<Node>> g = new HashMap<>();
        while (n --> 0) {
            String a = f.next();
            String b = f.next();
            int w = f.nextInt();
            g.putIfAbsent(a, new ArrayList<>());
            g.putIfAbsent(b, new ArrayList<>());
            g.get(a).add(new Node(b, w));
            g.get(b).add(new Node(a, w));
        }
        while (m --> 0) {
            String start = f.next();
            String end = f.next();
            int amo = f.nextInt();
            HashSet<String> v = new HashSet<>();
            PriorityQueue<Node> pq = new PriorityQueue<>();
            pq.add(new Node(start, 0));
            while (!pq.isEmpty()) {
                Node cur = pq.poll();
                if (v.contains(cur.n)) {
                    continue;
                }
                if (cur.n.equals(end)) {
                    System.out.println(amo >= cur.w ? cur.n + " is always a good idea." : "There's no place like home.");
                    break;
                }
                v.add(cur.n);
                for (Node next : g.get(cur.n)) {
                    pq.add(new Node(next.n, cur.w + next.w));
                }
            }
        }

        f.close();
    }

    public class Node implements Comparable<Node> {
        String n;
        int w;

        public Node(String nn, int ww) {
            n = nn;
            w = ww;
        }

        @Override
        public int compareTo(Node o) {
            return w - o.w;
        }
    }

    public static void main(String[] args) throws Exception {
        new Sofia().run();
    }
}