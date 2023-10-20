package district2013_2;

import java.util.*;
import java.io.*;

public class Bus {

    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/district2013_2/Bus.dat".toLowerCase()));
        //Scanner f = new Scanner(System.in);

        ArrayList<String> l = new ArrayList<>();
        int n = 0;
        while (f.hasNext()) {
            String[] line = f.nextLine().split(" ");
            if (line[0].equals("ON")) {
                for (int i = 1; i < line.length; i++) {
                    l.add(line[i]);
                    n++;
                }
            }
            else {
                for (int i = 1; i < line.length; i++) {
                    int pos = l.indexOf(line[i]);

                }
            }
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Bus().run();
    }

}