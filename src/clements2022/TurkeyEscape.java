package clements2022;

import java.io.*;
import java.util.*;

public class TurkeyEscape {

    public static void main(String[] args) throws Exception {
        new TurkeyEscape().run();
    }

    public void run() throws Exception {
        Scanner file = new Scanner(new File("Data/clements2022/turkeyescape.in"));
        //Scanner file = new Scanner(System.in);

        int cases = file.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        while (cases-- > 0) {
            int x = file.nextInt();
            int y = file.nextInt();
            if (x % 13 != 0 && y % 13 != 0 && x + y != 13) {
                double distance = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
                list.add((int) Math.round(distance));
            }
        }
        Collections.sort(list);
        Collections.reverse(list);
        System.out.println(list.get(0));

        file.close();
    }
}