package b2020;

import java.util.*;
import java.io.*;

public class Guoliang {
    public boolean isogram (String str) {
        HashSet<Character> hs = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            hs.add(str.charAt(i));
            }

        return hs.size() == str.length();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/Input/Guoliang.dat"));
        //Scanner f = new Scanner(System.in);

        while (f.hasNext()) {

            String in = f.next();
            if (isogram(in)) {
                System.out.println(in);
            }

        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Guoliang().run();
    }

}