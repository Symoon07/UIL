package a2021;

import java.util.*;
import java.io.*;

public class William {
    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/Input/william.dat"));
        //Scanner f = new Scanner(System.in);

        TreeMap<String, String> names = new TreeMap<>();
        while (f.hasNext()) {
            String firsName = f.next();
            String lastName = f.next();
            names.put(lastName, firsName);
        }

        for (String lastName : names.keySet()) {
            System.out.println(names.get(lastName) + " " + lastName);
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new William().run();
    }

}