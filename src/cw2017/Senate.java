package cw2017;

import java.util.*;
import java.io.*;

public class Senate {
    HashSet<String> connections;

    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/cw2017/Senate.dat"));
        //Scanner f = new Scanner(System.in);

        int n = f.nextInt();
        int numTreason = 0;
        while (n-- > 0) {
            int s = f.nextInt();
            HashMap<String, ArrayList<String>> hm = new HashMap<>();
            connections = new HashSet<>();
            for (int i = 0; i < s; i++) {
                String[] line = f.next().split("-");
                String[] relations = line[1].length() != 2 ? line[1].replaceAll("\\[", "").replaceAll("]", "").split(",") : new String[0];
                ArrayList<String> l = new ArrayList<>(Arrays.asList(relations));
                hm.put(line[0], l);
            }
            recur("palpatine", hm, new ArrayList<>());
            if (connections.size() > s / 2) {
                System.out.println("\"I am the senate!\"");
            }
            else {
                numTreason++;
                System.out.println("\"It's treason then\"");
            }
        }
        System.out.println("\"Make the Republic Great Again\" " + numTreason);

        f.close();
    }

    public void recur(String cur, HashMap<String, ArrayList<String>> hm, ArrayList<String> visited) {
        connections.add(cur);
        visited.add(cur);
        for (String s : hm.get(cur)) {
            if (!visited.contains(s)) {
                recur(s, hm, visited);
            }
        }
        visited.remove(cur);
    }

    public static void main(String[] args) throws Exception {
        new Senate().run();
    }

}