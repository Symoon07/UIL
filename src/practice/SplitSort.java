package practice;

import java.util.*;
import java.io.*;

public class SplitSort {
    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/practice/SplitSort.dat".toLowerCase()));
        //Scanner f = new Scanner(System.in);

        int cases = f.nextInt();
        while (cases-- > 0) {
            ArrayList<Integer> l = new ArrayList<>();
            while (f.hasNext()) {
                int n = f.nextInt();
                if (n == 0) {
                    break;
                }
                l.add(n);
            }
            ArrayList<Integer> first = new ArrayList<>();
            ArrayList<Integer> second = new ArrayList<>();
            int m = l.size() % 2 == 1 ? l.size() / 2 + 1 : l.size() / 2;
            for (int i = 0; i < m; i++) {
                first.add(l.get(i));
            }
            for (int i = m; i < l.size(); i++) {
                second.add(l.get(i));
            }
            Collections.sort(first);
            Collections.reverse(first);
            Collections.sort(second);
            for (int n : first) {
                System.out.print(n + " ");
            }
            for (int n : second) {
                System.out.print(n + " ");
            }
            System.out.println();
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new SplitSort().run();
    }

}