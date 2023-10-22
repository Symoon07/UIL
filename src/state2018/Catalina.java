package state2018;

import java.util.*;
import java.io.*;

public class Catalina {

    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/state2018/Catalina.dat"));
        //Scanner f = new Scanner(System.in);

        while (f.hasNext()) {
            String line = f.nextLine();
            String out = "";
            for (int i = 0; i < line.length(); i++) {
                if (Character.isUpperCase(line.charAt(i))) {
                    out += line.charAt(i);
                }
            }
            System.out.println(out);
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Catalina().run();
    }

}