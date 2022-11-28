package taylor2022;

import java.util.*;
import java.io.*;

public class MonsterMash {
    public void run() throws Exception {
        //Scanner f = new Scanner(new File("template.dat"));
        Scanner f = new Scanner(System.in);

        int cases = f.nextInt();
        int a = f.nextInt();
        int b = f.nextInt();
        for (int i = 1; i <= cases; i++) {

            if (i % a == 0 && i % b == 0) {
                System.out.println("It was a graveyard smash!");
            }
            else if (i % a == 0) {
                System.out.println("He did the Monster Mash!");
            }
            else if (i % b == 0) {
                System.out.println("He did the flash,");
            }
            else {
                System.out.println("He did the mash,");
            }

        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new MonsterMash().run();
    }

}