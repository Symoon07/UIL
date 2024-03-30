package district2013_2;

import java.util.*;
import java.io.*;

public class OldFolks {

    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/district2013_2/OldFolks.dat".toLowerCase()));
        //Scanner f = new Scanner(System.in);

        int n = f.nextInt(); f.nextLine();
        ArrayList<String> l = new ArrayList<>();
        while (n-- > 0) {
            String line = f.nextLine();
            if (Integer.parseInt(line.substring(line.lastIndexOf(" ") + 1)) < 1953) {
                l.add(line.substring(0, line.lastIndexOf(" ")));
            }
        }
        for (String s : l) {
            System.out.println(s);
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new OldFolks().run();
    }

}