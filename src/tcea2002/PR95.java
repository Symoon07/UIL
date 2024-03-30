package tcea2002;

import java.util.*;
import java.io.*;

public class PR95 {

    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/tcea2002/PR95.dat".toLowerCase()));
        //Scanner f = new Scanner(System.in);

        int n = f.nextInt(); f.nextLine();
        int max = 0;
        String[][] mat = new String[n][];
        TreeMap<String, String> tm = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            String[] line = f.nextLine().split(" ");
            mat[i] = line;
            for (int j = 0; j < mat[i].length; j++) {
                tm.putIfAbsent(mat[i][j], "");
                tm.put(mat[i][j], tm.get(mat[i][j]) + (i+1) + " ");
                max = Math.max(max, mat[i][j].length());
            }
        }
        for (String s : tm.keySet()) {
            String format = "%-" + (max + 1) + "s";
            System.out.printf(format + "%s\n", s, tm.get(s));
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new PR95().run();
    }

}