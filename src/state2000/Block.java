package state2000;

import java.util.*;
import java.io.*;

public class Block {
    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/state2000/block.dat"));
        //Scanner f = new Scanner(System.in);

        while (f.hasNext()) {
            String[] line = f.nextLine().split(":");
            char[][] mat = new char[4][5];
            int temp = 0;
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 5; j++) {
                    mat[i][j] = line[0].charAt(temp++);
                }
            }
            for (int i = 0; i < line[1].length(); i++) {
                String cur = line[1].substring(i,i+1);
                for (int j = 0; j < 4; j++) {
                    for (int k = 0; k < 5; k++) {
                        if (cur.toUpperCase().charAt(0) == mat[j][k]) {
                            mat[j][k] = Character.isUpperCase(cur.charAt(0)) ? '.' : '#';
                        }
                    }
                }
            }
            boolean family = false;
            boolean solo = false;
            for (int i = 0; i < 4; i++) {
                if (mat[i][0] == '.') {
                    Queue<Integer> q = new LinkedList<>();
                    int[] evr = {-1, 1, 0, 0, -1, -1};
                    int[] evc = {0, 0, -1, 1, 1, -1};
                    int[] ovr = {-1, 1, 0, 0, 1, 1};
                    int[] ovc = {0, 0, -1, 1, 1, -1};
                    q.add(i);
                    q.add(0);
                    while (!q.isEmpty()) {
                        int r = q.poll();
                        int c = q.poll();
                        if (r < 0 || r >= 4 || c < 0 || c >= 5 || mat[r][c] != '.') {
                            continue;
                        }
                        if (c == 4) {
                            family = true;
                            break;
                        }
                        for (int j = 0; j < 6; j++) {
                            if (c % 2 == 0) {
                                int rr = r + evr[j];
                                int cc = c + evc[j];
                                q.add(rr);
                                q.add(cc);
                            }
                            else {
                                int rr = r + ovr[j];
                                int cc = c + ovc[j];
                                q.add(rr);
                                q.add(cc);
                            }
                        }
                        mat[r][c] = '-';
                    }
                }
            }
            for (int i = 0; i < 5; i++) {
                if (mat[0][i] == '#') {
                    Queue<Integer> q = new LinkedList<>();
                    int[] evr = {-1, 1, 0, 0, -1, -1};
                    int[] evc = {0, 0, -1, 1, 1, -1};
                    int[] ovr = {-1, 1, 0, 0, 1, 1};
                    int[] ovc = {0, 0, -1, 1, 1, -1};
                    q.add(0);
                    q.add(i);
                    while (!q.isEmpty()) {
                        int r = q.poll();
                        int c = q.poll();
                        if (r < 0 || r >= 4 || c < 0 || c >= 5 || mat[r][c] != '#') {
                            continue;
                        }
                        if (r == 3) {
                            solo = true;
                            break;
                        }
                        for (int j = 0; j < 6; j++) {
                            if (c % 2 == 0) {
                                int rr = r + evr[j];
                                int cc = c + evc[j];
                                q.add(rr);
                                q.add(cc);
                            }
                            else {
                                int rr = r + ovr[j];
                                int cc = c + ovc[j];
                                q.add(rr);
                                q.add(cc);
                            }
                        }
                        mat[r][c] = '-';
                    }
                }
            }
            System.out.println(!family && !solo ? "No Winner Yet" : family ? "Family Pair Wins" : "Solo Player Wins");
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Block().run();
    }

}