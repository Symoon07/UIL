package state2001;

import java.util.*;
import java.io.*;

public class Who {

    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/state2001/Who.dat".toLowerCase()));
        //Scanner f = new Scanner(System.in);

        int t = f.nextInt(); f.nextLine();
        HashMap<String, String> hm = new HashMap<>();
        while (t --> 0) {
            String[] line = f.nextLine().split("/");
            String[] l = line[0].split(" ");
            hm.put(l[0] + l[1] + l[2] + l[3] + l[4], line[1]);
        }
        while (f.hasNext()) {
            String[] l = f.nextLine().split(" ");
            System.out.println(hm.get(l[0] + l[1] + l[2] + l[3] + l[4]));
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Who().run();
    }

}