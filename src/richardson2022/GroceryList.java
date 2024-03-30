package richardson2022;

import java.util.*;
import java.io.*;

public class GroceryList {
    public void run() throws Exception {
        //Scanner f = new Scanner(new File("template.dat"));
        Scanner f = new Scanner(System.in);

        int cases = f.nextInt();
        f.nextLine();
        while (cases-- > 0) {

            String in = f.nextLine();
            if (Character.isUpperCase(in.charAt(0))) {
                System.out.println(in);
            }
            else {
                System.out.println(new StringBuilder(in).reverse());
            }

        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new GroceryList().run();
    }

}