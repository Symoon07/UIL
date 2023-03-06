package a2022;

import java.util.*;
import java.io.*;

public class Tom {
    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/a2022/Tom.dat".toLowerCase()));
        //Scanner f = new Scanner(System.in);

        int cases = f.nextInt();
        while (cases-- > 0) {
            String s = f.next();
            HashMap<String, Integer> hm = new HashMap<>();
            int sum = 0;
            for (int i = 0; i < s.length(); i++) {
                String cur = s.substring(i,i+1);
                hm.putIfAbsent(cur, 0);
                if (hm.containsKey(cur)) {
                    hm.put(cur, hm.get(cur)+1);
                }
                sum += hm.get(cur);
            }
            System.out.println(sum);
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Tom().run();
    }

}