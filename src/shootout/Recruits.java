package shootout;

import java.util.*;
import java.io.*;

public class Recruits {

    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/shootout/Recruits.dat".toLowerCase()));
        //Scanner f = new Scanner(System.in);

        int t = f.nextInt(); f.nextLine();
        while (t --> 0) {
            int r = f.nextInt(); f.nextLine();
            TreeMap<String, ArrayList<String>> hm = new TreeMap<>();
            ArrayList<String> left = new ArrayList<>();
            while (r --> 0) {
                String s = f.nextLine();
                if (s.contains("-")) {
                    String[] line = s.split("-");
                    hm.putIfAbsent(line[1], new ArrayList<>());
                    if (hm.get(line[1]).size() < 3) {
                        ArrayList<String> l = hm.get(line[1]);
                        l.add(line[0]);
                        hm.put(line[1], l);
                    }
                    else {
                        left.add(line[0]);
                    }
                }
                else {
                    left.add(s);
                }
            }
            ArrayList<String> cur = new ArrayList<>();
            int team = 1;
            for (int i = 0; i < left.size(); i++) {
                cur.add(left.get(i));
                if (cur.size() == 3 || i == left.size()-1) {
                    hm.put("Untitled Team " + team++, cur);
                    cur = new ArrayList<>();
                }
            }
            for (String key : hm.keySet()) {
                System.out.println(key);
                ArrayList<String> l = hm.get(key);
                Collections.sort(l);
                for (String s :l) {
                    System.out.println(s);
                }
                System.out.println();
            }
            System.out.println("-----");
            System.out.println();
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Recruits().run();
    }

}