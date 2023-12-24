package waller2023;

import java.util.*;
import java.io.*;

public class Kathleen {

    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/waller2023/Kathleen.dat"));
        //Scanner f = new Scanner(System.in);

        int t = f.nextInt();
        while (t --> 0) {
            int n = f.nextInt();
            int m = f.nextInt();
            HashMap<String, ArrayList<String>> adj = new HashMap<>();
            String c = "";
            while (n --> 0) {
                c = f.next();
                adj.put(c, new ArrayList<>());
            }
            while (m-- > 0) {
                String x = f.next();
                String y = f.next();
                ArrayList<String> X = adj.get(x);
                ArrayList<String> Y = adj.get(y);
                X.add(y);
                Y.add(x);
                adj.put(x, X);
                adj.put(y, Y);
            }
            Queue<String> q = new LinkedList<>();
            int visited = adj.size();
            q.add(c);
            while (!q.isEmpty()) {
                String cur = q.poll();
                if (!adj.containsKey(cur)) {
                    continue;
                }
                visited--;
                q.addAll(adj.get(cur));
                adj.remove(cur);
            }
            System.out.println(visited == 0 ? "Yes" : "No");
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Kathleen().run();
    }

}