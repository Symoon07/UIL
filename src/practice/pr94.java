package practice;

import java.util.*;
import java.io.*;

public class pr94 {
    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/practice/pr94.dat".toLowerCase()));
        //Scanner f = new Scanner(System.in);

        int n = f.nextInt(); f.nextLine();
        while (n-- > 0) {
            ArrayList<String> l = new ArrayList<>();
            String[] line = f.nextLine().split(" ");
            for (String s : line) {
                if (s.length() == 3) {
                    l.add(s);
                }
            }
            Collections.sort(l);
            int j = 0;
            for (int i = 0; i < line.length; i++) {
                if (line[i].length() == 3) {
                    line[i] = l.get(j++);
                }
            }
            for (String s : line) {
                System.out.print(s + " ");
            }
            System.out.println();
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new pr94().run();
    }

}