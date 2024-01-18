package state2001;

import java.util.*;
import java.io.*;

public class Que {
    
    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/state2001/Que.dat".toLowerCase()));
        //Scanner f = new Scanner(System.in);

        int t = f.nextInt(); f.nextLine();
        HashMap<String, String> hm = new HashMap<>();
        while (t --> 0) {
            hm.put(f.next(), f.next()); f.nextLine();
        }
        while (f.hasNext()) {
            String[] line = f.nextLine().split(" ");
            for (String s : line) {
                System.out.print(hm.get(s) + " ");
            }
            System.out.println();
        }

        f.close();
    }
    
    public static void main(String[] args) throws Exception {
        new Que().run();
    }

}