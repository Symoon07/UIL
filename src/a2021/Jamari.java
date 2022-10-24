package a2021;

import java.util.*;
import java.io.*;

public class Jamari {
    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/Input/jamari.dat"));
        //Scanner f = new Scanner(System.in);

        int numSold = 0;
        ArrayList<String> customers = new ArrayList<>();
        while (f.hasNext()) {

            String in = f.next();
            if (in.equals(">>>")) {
                if (numSold == 0) {
                    System.out.println("No one got a donut today.");
                }
                else if (numSold == customers.size()) {
                    System.out.println("Everyone got a donut today.");
                }
                else {
                    System.out.println("The last person to get a donut was " + customers.get(numSold - 1));
                    System.out.println(customers.size()-numSold + " customers did not get a donut today.");
                }
                customers.clear();
                numSold = 0;
            }

            else {
                try {
                    numSold += Integer.parseInt(in, 10);
                }
                catch (Exception e) {
                    customers.add(in);
                }
            }

        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Jamari().run();
    }

}