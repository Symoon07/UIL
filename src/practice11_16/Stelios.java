package practice11_16;

import java.util.*;
import java.io.*;

public class Stelios {
    int[][] mat;
    HashMap<Integer, ArrayList<Integer>> graph;

    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/practice11_16/Stelios.dat"));
        //Scanner f = new Scanner(System.in);

        while (f.hasNext()) {
            int N = f.nextInt();
            mat = new int[N][N];
            String[] line = f.nextLine().split(" ");
            graph = new HashMap<>();
            for (int i = 0; i < N; i++) {
                Arrays.fill(mat[i], Integer.MAX_VALUE);
            }
            for (int i = 1; i < line.length; i++) {
                graph.putIfAbsent(line[i].charAt(0) - 'A', new ArrayList<>());
                graph.putIfAbsent(line[i].charAt(1) - 'A', new ArrayList<>());
                ArrayList<Integer> l = graph.get(line[i].charAt(0) - 'A');
                l.add(line[i].charAt(1) - 'A');
                graph.put(line[i].charAt(0) - 'A', l);
                l = graph.get(line[i].charAt(1) - 'A');
                l.add(line[i].charAt(0) - 'A');
                graph.put(line[i].charAt(1) - 'A', l);
            }
            for (int i = 1; i < N; i++) {
                for (int j = i + 1; j < N; j++) {
                    recur(i, i, j, 0, new HashSet<>());
                }
            }
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    System.out.print(mat[i][j] != Integer.MAX_VALUE ? mat[i][j] + " " : 0 + " ");
                }
                System.out.println();
            }
            System.out.println("-".repeat(2 * N - 1));
        }

        f.close();
    }

    public void recur(int start, int cur, int end, int dis, HashSet<Integer> visited) {
        if (cur == end) {
            mat[start][end] = Math.min(mat[start][end], dis);
            mat[end][start] = Math.min(mat[end][start], dis);
        }
        visited.add(cur);
        for (int next : graph.get(cur)) {
            if (!visited.contains(next)) {
                recur(start, next, end, dis + 1, visited);
            }
        }
        visited.remove(cur);
    }

    public static void main(String[] args) throws Exception {
        new Stelios().run();
    }

}