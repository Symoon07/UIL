package state2023;

import java.util.*;
import java.io.*;

public class Vijay {
    char[][][] mat;
    int[][][][] smat;
    int[] vh = {-1, 1, 0, 0, 0, 0};
    int[] vr = {0, 0, -1, 1, 0, 0};
    int[] vc = {0, 0, 0, 0, -1, 1};
    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/state2023/Vijay.dat"));
        //Scanner f = new Scanner(System.in);

        int t = f.nextInt();
        while (t --> 0) {
            int height = f.nextInt();
            int row = f.nextInt();
            int col = f.nextInt();
            int o = f.nextInt();
            int minTime = f.nextInt();
            mat = new char[height][row][col];
            smat = new int[1 << o][height][row][col];
            ArrayList<Integer> ends = new ArrayList<>();
            int sh = 0;
            int sr = 0;
            int sc = 0;
            int CDs = 0;
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < row; j++) {
                    mat[i][j] = f.next().toCharArray();
                    for (int k = 0; k < 1 << o; k++) {
                        Arrays.fill(smat[k][i][j], Integer.MAX_VALUE);
                    }
                    for (int k = 0; k < col; k++) {
                        if (mat[i][j][k] == 'S') {
                            sh = i;
                            sr = j;
                            sc = k;
                        }
                        else if (mat[i][j][k] == 'O') {
                            mat[i][j][k] = (char) CDs++;
                        }
                        else if (mat[i][j][k] == 'E') {
                            ends.add(i);
                            ends.add(j);
                            ends.add(k);
                        }
                    }
                }
            }
            int min = Integer.MAX_VALUE;
            recur(sh, sr, sc, 0, 0);
            while (!ends.isEmpty()) {
                min = Math.min(min, smat[smat.length-1][ends.remove(0)][ends.remove(0)][ends.remove(0)]);
            }
            System.out.println(min <= minTime ? "# of steps achieved: " + min : "None shall pass.");
        }

        f.close();
    }

    public void recur(int h, int r, int c, int mask, int s) {
        if (h < 0 || h >= mat.length || r < 0 || r >= mat[h].length || c < 0 || c >= mat[h][r].length || mat[h][r][c] == '#' || s >= smat[mask][h][r][c]) {
            return;
        }
        if (mat[h][r][c] <= 10) {
            mask |= 1 << mat[h][r][c];
        }
        smat[mask][h][r][c] = s;
        for (int i = 0; i < 6; i++) {
            recur(h + vh[i], r + vr[i], c + vc[i], mask, s+1);
        }
    }

    public static void main(String[] args) throws Exception {
        new Vijay().run();
    }
}