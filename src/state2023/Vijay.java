package state2023;

import java.util.*;
import java.io.*;

public class Vijay {
    HashMap<Character, Node> hm;
    int CDs;
    int time;
    int found;
    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/state2023/Vijay.dat"));
        //Scanner f = new Scanner(System.in);

        int t = f.nextInt();
        while (t --> 0) {
            int height = f.nextInt();
            int row = f.nextInt();
            int col = f.nextInt();
            CDs = f.nextInt();
            time = f.nextInt();
            char[][][] mat = new char[height][row][col];
            hm = new HashMap<>();
            int CD = '1';
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < row; j++) {
                    mat[i][j] = f.next().toCharArray();
                    for (int k = 0; k < col; k++) {
                        if (mat[i][j][k] == 'O') {
                            mat[i][j][k] = (char) CD++;
                            hm.put(mat[i][j][k], new Node(mat[i][j][k], i, j, k));
                        }
                        else if (mat[i][j][k] == 'S' || mat[i][j][k] == 'E') {
                            hm.put(mat[i][j][k], new Node(mat[i][j][k], i, j, k));
                        }
                    }
                }
            }
            for (char cur : hm.keySet()) {
                boolean[][][] visited = new boolean[height][row][col];
                int[] vh = {-1, 1, 0, 0, 0, 0};
                int[] vr = {0, 0, -1, 1, 0, 0};
                int[] vc = {0, 0, 0, 0, -1, 1};
                Queue<Integer> q = new LinkedList<>();
                q.add(hm.get(cur).sh);
                q.add(hm.get(cur).sr);
                q.add(hm.get(cur).sc);
                q.add(0);
                while (!q.isEmpty()) {
                    int h = q.poll();
                    int r = q.poll();
                    int c = q.poll();
                    int dis = q.poll();
                    if (h < 0 || h >= height || r < 0 || r >= row || c < 0 || c >= col || mat[h][r][c] == '#' || visited[h][r][c]) {
                        continue;
                    }
                    visited[h][r][c] = true;
                    if (mat[h][r][c] != '.') {
                        hm.get(cur).addEdge(hm.get(mat[h][r][c]), dis);
                    }
                    for (int i = 0; i < 6; i++) {
                        q.add(h + vh[i]);
                        q.add(r + vr[i]);
                        q.add(c + vc[i]);
                        q.add(dis + 1);
                    }
                }
            }
            found = Integer.MAX_VALUE;
            recur('S', 0, 0, new HashSet<>());
            System.out.println(found == Integer.MAX_VALUE ? "None shall pass." : "# of steps achieved: " + found);
        }

        f.close();
    }

    public void recur(char cur, int t, int o, HashSet<Character> visited) {
        if (visited.contains(cur) || t > time) {
            return;
        }
        if (cur == 'E' && o == CDs) {
            found = Math.min(found, t);
            return;
        }
        if (cur != 'S') {
            o+=1;
        }
        visited.add(cur);
        for (Edge e : hm.get(cur).edges) {
            recur(e.des.name, t + e.dis, o, visited);
        }
        visited.remove(cur);
    }

    public class Node {
        char name;
        int sh;
        int sr;
        int sc;
        ArrayList<Edge> edges;

        public Node(char n, int h, int r, int c) {
            name = n;
            sh = h;
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
        new Vijay().run();
    }
}