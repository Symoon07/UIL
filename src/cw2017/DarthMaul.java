package cw2017;

import java.util.*;
import java.io.*;

public class DarthMaul {

    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/cw2017/DarthMaul.dat".toLowerCase()));
        //Scanner f = new Scanner(System.in);

        int n = f.nextInt(); f.nextLine();
        while (n-- > 0) {
            String s = f.next(); f.nextLine();
            String[] line = f.nextLine().split(" ");
            ArrayList<Integer> l = new ArrayList<>();
            for (String str : line) {
                l.add(Integer.parseInt(str));
            }
            Collections.sort(l);
            if (s.equals("B")) {
                Collections.reverse(l);
            }
            String out = " ";
            for (int i = 0; i < l.size(); i++) {
                if (i % 2 == 0) {
                    out += l.get(i) + " ";
                }
                else {
                    out = " " + l.get(i) + out;
                }
            }
            System.out.println(out);
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new DarthMaul().run();
    }

}