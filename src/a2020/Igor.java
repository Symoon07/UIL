package a2020;

import java.util.*;
import java.io.*;

public class Igor {
    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/a2020/igor.dat"));
        //Scanner f = new Scanner(System.in);

        int cases = f.nextInt();
        while (cases-- > 0) {

            String[] arr = f.next().split("");
            HashMap<String, Integer> map = new HashMap<>();
            for (String s : arr) {
                if (map.containsKey(s)) {
                    map.put(s, map.get(s) + 1);
                }
                else {
                    map.put(s, 1);
                }
            }

            int val = 0;
            boolean added = false;
            for (String key : map.keySet()) {
                if (!added && map.get(key) % 2 == 1) {
                    added = true;
                    val += map.get(key) % 2;
                    map.put(key, map.get(key) - 1);
                }
                if (map.get(key) >= 2) {
                    val += map.get(key) - map.get(key) % 2;
                    map.put(key, map.get(key) % 2);
                }
            }
            val *= val;

            for (String key : map.keySet()) {
                if (map.get(key) % 2 == 1) {
                    val += 1;
                }
            }

            System.out.println(val);

        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Igor().run();
    }

}