package slhs2023;

import java.util.*;
import java.io.*;

public class P2 {

    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/slhs2023/P2/judgein4.txt".toLowerCase()));
        //Scanner f = new Scanner(System.in);

        System.out.println(f.nextLine().equalsIgnoreCase("gold coin") ? "yes" : "no");

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new P2().run();
    }

}