package clements2023;

import java.util.*;
import java.io.*;

public class Lamb {

    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/clements2023/Lamb.dat"));
        //Scanner f = new Scanner(System.in);

        int n = f.nextInt(); f.nextLine();
        while (n --> 0) {
            System.out.println(f.nextLine().toLowerCase().replaceAll("\\W", "").contains("lamb") ? "Lamb location confirmed." : "Where's the Lamb Sauce?!?");
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Lamb().run();
    }

}