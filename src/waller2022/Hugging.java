package waller2022;

import java.util.*;
import java.io.*;

public class Hugging {
    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/waller2022/Hugging.dat"));
        //Scanner f = new Scanner(System.in);

        HashMap<String, String> hm = new HashMap<>();
        while(true){
            String from = f.next();
            if (from.equals("stop")) break;
            String to = f.next();
            hm.put(from, to);
        }

        f.nextLine();
        String[] starts = f.nextLine().split(" ");
        for (String start : starts) {

            ArrayList<String> looped = new ArrayList<>();
            String cur = start;
            String out = cur + "-";
            while (hm.get(cur) != null && !looped.contains(cur)) {
                out += hm.get(cur) + "-";
                looped.add(cur);
                cur = hm.get(cur);
            }

            System.out.println(out.substring(0, out.length()-1));

        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Hugging().run();
    }

}