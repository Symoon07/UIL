package slhs2022;

import java.util.*;
import java.io.*;

public class Animal {
    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/slhs2022/animal.dat"));
        //Scanner f = new Scanner(System.in);

        int cases = f.nextInt();
        while (cases-- > 0) {

            int side1 = f.nextInt();
            int side2 = f.nextInt();
            int side3 = f.nextInt();
            int side4 = f.nextInt();
            if (side1 == side2 && side2 == side3 && side3 == side4) {
                System.out.println("sheep");
            }
            else if (side1 == side3 && side2 == side4) {
                System.out.println("cattle");
            }
            else {
                System.out.println("pigs");
            }

        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Animal().run();
    }

}