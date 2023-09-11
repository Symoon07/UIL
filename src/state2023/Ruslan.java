package state2023;

import java.util.*;
import java.io.*;

public class Ruslan {

    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/state2023/Ruslan.dat".toLowerCase()));
        //Scanner f = new Scanner(System.in);

        int cases = f.nextInt(); f.nextLine();
        while (cases-- > 0) {
            HashMap<String, HashSet<String>> hm = new HashMap<>();
            HashMap<String, Boolean> visited = new HashMap<>();
            String line = f.nextLine();
            while (!line.equals("=====")) {
                String[] temp = line.split(" ");
                hm.putIfAbsent(temp[0], new HashSet<>());
                hm.putIfAbsent(temp[1], new HashSet<>());
                hm.get(temp[0]).add(temp[1]);
                hm.get(temp[1]).add(temp[0]);
                visited.putIfAbsent(temp[0], false);
                visited.putIfAbsent(temp[1], false);
                line = f.nextLine();
            }
            System.out.println(paths("You", "Ruslan", hm, visited));
        }

        f.close();
    }

    public int paths(String cur, String rus, HashMap<String, HashSet<String>> hm, HashMap<String, Boolean> visited) {
        if (cur.equals(rus)) {
            return 1;
        }
        if (visited.get(cur)) {
            return 0;
        }
        int n = 0;
        visited.put(cur, true);
        HashSet<String> neighbors = hm.get(cur);
        for (String neighbor : neighbors) {
            n += paths(neighbor, rus, hm, visited);
        }
        visited.put(cur, false);
        return n;
    }

    public static void main(String[] args) throws Exception {
        new Ruslan().run();
    }

}