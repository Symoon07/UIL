package slhs2022;

import java.util.*;
import java.io.*;

public class Jesters {
    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/slhs2022/jesters.dat"));
        //Scanner f = new Scanner(System.in);

        int people = f.nextInt();
        String stroud = "stroud";
        String list = "Fungeon List:\n";
        f.nextLine();
        while (people-- > 0) {
            String name = f.nextLine();
            name = name.substring(0, name.length()-1);
            while (f.hasNextLine()) {
                String line = f.nextLine();
                if (line.replace(" ", "").length() == 0) break;
                if (line.toLowerCase().contains(stroud) && !name.equals("Jester") && !list.contains(name)) {
                    list += name + "\n";
                }
            }
        }

        System.out.println(list);

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Jesters().run();
    }

}