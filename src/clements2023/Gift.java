package clements2023;

import java.util.*;
import java.io.*;

public class Gift {

    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/clements2023/Gift.dat"));
        //Scanner f = new Scanner(System.in);

        int n = f.nextInt();
        while (n --> 0) {
            int m = f.nextInt();
            HashMap<String, ArrayList<String>> graph = new HashMap<>();
            while (m --> 0) {
                String s1 = f.next();
                String s2 = f.next();
                graph.putIfAbsent(s1, new ArrayList<>());
                graph.putIfAbsent(s2, new ArrayList<>());
                ArrayList<String> l = graph.get(s1);
                l.add(s2);
                graph.put(s1, l);
                l = graph.get(s2);
                l.add(s1);
                graph.put(s2, l);
            }
            boolean found = false;
            if (graph.containsKey("You")) {
                Queue<String> q = new LinkedList<>();
                HashSet<String> visited = new HashSet<>();
                q.add("You");
                while (!q.isEmpty()) {
                    String cur = q.poll();
                    if (visited.contains(cur)) {
                        continue;
                    }
                    if (cur.equals("Ramsey")) {
                        found = true;
                        break;
                    }
                    visited.add(cur);
                    q.addAll(graph.get(cur));
                }
            }
            System.out.println(found ? "Happy Gifting." : "Not So Secret Santa.");
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Gift().run();
    }

}