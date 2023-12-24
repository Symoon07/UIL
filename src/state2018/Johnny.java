package state2018;

import java.util.*;
import java.io.*;

public class Johnny {

    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/state2018/Johnny.dat"));
        //Scanner f = new Scanner(System.in);

        HashMap<String, String> hm = new HashMap<>();
        while (f.hasNext()) {
            String line = f.nextLine();
            if (Character.isAlphabetic(line.charAt(0))) {
                String[] s = line.split(" ");
                for (int i = 0; i < s.length; i++) {
                    System.out.print(hm.get(s[i]));
                }
                System.out.println();
            }
            else {
                String[] s = line.split("[ /]");
                for (int i = 1; i < s.length; i++) {
                    hm.put(s[i], s[0]);
                }
            }
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Johnny().run();
    }

}