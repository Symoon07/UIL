package waller2022;

import java.util.*;
import java.io.*;

public class ShiftyTree {
    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/waller2022/shiftytree.dat"));
        //Scanner f = new Scanner(System.in);

        TreeSet<String> names = new TreeSet<>();
        TreeMap<String, Integer> amountM = new TreeMap<>();
        TreeMap<String, TreeSet<String>> descM = new TreeMap<>();
        while (f.hasNextLine()) {
            String[] in = f.nextLine().split(",");
            String name = in[0];
            int change = Integer.parseInt(in[1]);
            String desc = in[2];
            names.add(name);

            if(!amountM.containsKey(name)) {
                amountM.put(name, change);
            }
            else {
                amountM.put(name, amountM.get(name) + change);
            }

            if (!descM.containsKey(name)) {
                descM.put(name, new TreeSet<>());
                TreeSet<String> ts = descM.get(name);
                ts.add(desc);
                descM.put(name, ts);
            }
            else {
                TreeSet<String> ts = descM.get(name);
                ts.add(desc);
                descM.put(name, ts);
            }
        }

        for (String name : names) {
            String out = "";
            out += name + ",";
            out += amountM.get(name) + ",";
            for (String desc : descM.get(name)) {
                out += desc + ",";
            }
            System.out.println(out.substring(0,out.length()-1));
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new ShiftyTree().run();
    }

}