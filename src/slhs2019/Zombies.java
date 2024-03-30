package slhs2019;

import java.util.*;
import java.io.*;

public class Zombies {
    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/Input/zombies.dat"));
        //Scanner f = new Scanner(System.in);

        while (f.hasNext()) {

            String in = f.nextLine();
            String zombie = "zombie";
            String out = "";
            for (int i = 0; i < in.length(); i++) {
                boolean found = false;
                for (int j = 0; j < zombie.length(); j++) {
                    if (in.substring(i,i+1).toLowerCase().equals(zombie.substring(j,j+1))) {
                        found = true;
                    }
                }
                if (!found) {
                    out += in.charAt(i);
                }
            }

            System.out.println(out);

        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Zombies().run();
    }

}