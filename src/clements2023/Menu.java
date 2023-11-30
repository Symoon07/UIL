package clements2023;

import java.util.*;
import java.io.*;

public class Menu {

    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/clements2023/Menu.dat"));
        //Scanner f = new Scanner(System.in);

        int n = f.nextInt(); f.nextLine();
        while (n --> 0) {
            int col = f.nextInt();
            int row = f.nextInt(); f.nextLine();
            String[] words = f.nextLine().split(" ");
            System.out.println("-".repeat(col));
            int i = 0;
            for (int j = 0; j < row-2; j++) {
                String cur = words[i++];
                while (i < words.length && cur.length() + words[i].length() + 1 < col -2) {
                    cur += " " + words[i++];
                }
                System.out.printf("|%-" + (col - 2) + "s|\n", cur);
            }
            System.out.println("-".repeat(col));
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Menu().run();
    }

}