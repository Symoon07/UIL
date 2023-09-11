package shootout;

import java.util.*;
import java.io.*;

public class PR93 {
    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/shootout/PR93.dat"));
        //Scanner f = new Scanner(System.in);

        int n = f.nextInt(); f.nextLine();
        while (n-- > 0) {
            String[] line = f.nextLine().split(" ");
            TreeSet<String> l = new TreeSet<>();
            for (int i = 0; i < line.length; i++) {
                if (line[i].length() == 3) {
                    l.add(line[i]);
                }
                else {
                    System.out.print(line[i] + " ");
                }
            }
            System.out.println();
            for (String s : l) {
                System.out.println(s);
            }
            System.out.println();
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new PR93().run();
    }

}