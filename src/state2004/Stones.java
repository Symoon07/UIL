package state2004;

import java.util.*;
import java.io.*;

public class Stones {

    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/state2004/Stones.dat"));
        //Scanner f = new Scanner(System.in);

        int t = f.nextInt(); f.nextLine();
        while (t --> 0) {
            int[] val = Arrays.stream(f.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            ArrayList<ArrayList<Integer>> v = new ArrayList<>();
            ArrayList<Integer> cur = new ArrayList<>();
            for (int i = 2; i < val.length; i++) {
                cur.add(val[i]);
            }
            int ct = 0;
            boolean win = false;
            if (cur.equals(newMove(cur))) {
                System.out.println("1 WIN " + cur);
            }
            else {
                cur = newMove(cur);
                while (!v.contains(cur)) {
                    ct++;
                    v.add(cur);
                    if (newMove(cur).equals(v.get(v.size() - 1))) {
                        win = true;
                        break;
                    }
                    cur = newMove(cur);
                }
                if (!win) {
                    ct++;
                }
                System.out.printf("%d %s %s\n", ct, win ? "WIN" : "LOSS", cur);
            }
        }

        f.close();
    }

    public ArrayList<Integer> newMove(ArrayList<Integer> cur) {
        ArrayList<Integer> out = new ArrayList<>();
        out.add(cur.size());
        for (int i = 0; i < cur.size(); i++) {
            if (cur.get(i) > 1) {
                out.add(cur.get(i) - 1);
            }
        }
        out.sort(Collections.reverseOrder());
        return out;
    }

    public static void main(String[] args) throws Exception {
        new Stones().run();
    }
}