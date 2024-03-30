package waller2022;

import java.util.*;
import java.io.*;

public class Georgia {
    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/waller2022/Georgia.dat"));
        //Scanner f = new Scanner(System.in);

        String[] word = f.nextLine().toUpperCase().split(" ");
        TreeMap<Character, Integer> hm = new TreeMap<>();
        for (int i = 'A'; i <= 'Z'; i++) {
            hm.put((char)i, 0);
        }

        for (String s : word) {
            for (int j = 0; j < s.length(); j++) {
                if (Character.isLetter(s.charAt(j))) {
                    hm.put(s.charAt(j), hm.get(s.charAt(j)) + 1);
                }
            }
        }

        for (Map.Entry<Character, Integer> entry : hm.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Georgia().run();
    }

}