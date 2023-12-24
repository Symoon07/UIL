package cw2016;

import java.util.*;
import java.io.*;

public class Nick {
    HashMap<Integer, Node> hm;
    int d;
    int t;
    int s;
    boolean found;
    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/cw2016/Nick.dat"));
        //Scanner f = new Scanner(System.in);

        int n = f.nextInt(); f.nextLine();
        while (n --> 0) {
            int row = f.nextInt();
            d = f.nextInt();
            t = f.nextInt();
            s = f.nextInt(); f.nextLine();
            int[][] mat = new int[row][];
            hm = new HashMap<>();
            int Ts = 1;
            for (int i = 0; i < row; i++) {
                String temp = f.nextLine();
                mat[i] = new int[temp.length()];
                for (int j = 0; j < mat[i].length; j++) {
                    switch (temp.substring(j, j + 1)) {
                        case "S" -> mat[i][j] = -3;
                        case "H" -> mat[i][j] = -2;
                        case "@" -> mat[i][j] = -1;
                        case "." -> mat[i][j] = 0;
                    }
                    if (temp.charAt(j) == 'T') {
                        mat[i][j] = Ts++;
                        hm.put(mat[i][j], new Node(mat[i][j], i, j));
                    }
                    else if (mat[i][j] == -3 || mat[i][j] == -2) {
                        hm.put(mat[i][j], new Node(mat[i][j], i, j));
                    }
                }
            }
            for (int cur : hm.keySet()) {
                boolean[][] visited = new boolean[row][];
                for (int i = 0; i < row; i++) {
                    visited[i] = new boolean[mat[i].length];
                }
                int[] vr = {-1, 1, 0, 0};
                int[] vc = {0, 0, -1, 1};
                Queue<Integer> q = new LinkedList<>();
                q.add(hm.get(cur).sr);
                q.add(hm.get(cur).sc);
                q.add(0);
                while (!q.isEmpty()) {
                    int r = q.poll();
                    int c = q.poll();
                    int dis = q.poll();
                    if (r < 0 || r >= row || c < 0 || c >= mat[r].length || mat[r][c] == -1 || visited[r][c]) {
                        continue;
                    }
                    visited[r][c] = true;
                    if (mat[r][c] != 0) {
                        hm.get(cur).addEdge(hm.get(mat[r][c]), dis * d);
                    }
                    for (int i = 0; i < 4; i++) {
                        q.add(r + vr[i]);
                        q.add(c + vc[i]);
                        q.add(dis + 1);
                    }
                }
            }
            found = false;
            recur(-3, s, new HashSet<>());
            System.out.println(found ? "STILL ALIVE" : "RIP IN PEPRI");
        }
        f.close();
    }

    public void recur(int cur, int h, HashSet<Integer> visited) {
        if (visited.contains(cur) || h < 0) {
            return;
        }
        if (cur == -2) {
            found = true;
            return;
        }
        if (cur != -3) {
            h += t;
        }
        visited.add(cur);
        for (Edge e : hm.get(cur).edges) {
            recur(e.des.name, h - e.dis, visited);
        }
    }

    public class Node {
        int name;
        int sr;
        int sc;
        ArrayList<Edge> edges;

        public Node(int n, int r, int c) {
            name = n;
            sr = r;
            sc = c;
            edges = new ArrayList<>();
        }

        public void addEdge(Node n, int d) {
            Edge e = new Edge(n, d);
            edges.add(e);
        }
    }

    public class Edge {
        Node des;
        int dis;

        public Edge(Node d, int di) {
            des = d;
            dis = di;
        }
    }

    public static void main(String[] args) throws Exception {
        new Nick().run();
    }
}