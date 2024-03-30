package b2020;

import java.util.*;
import java.io.*;

public class Emilio {
    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/Input/emilio.dat"));
        //Scanner f = new Scanner(System.in);

        int cases = f.nextInt();
        for (int i = 0; i < cases; i++) {

            int numRuns = f.nextInt();
            ArrayList<Double> list = new ArrayList<>();
            for (int j = 0; j < numRuns; j++) {
                list.add(f.nextDouble());
            }
            Collections.sort(list);

            double avgMax = 0;
            double avgMin = 0;
            for (int j = 0; j < 10; j++) {
                avgMin += list.get(j);
            }
            for (int j = list.size()-1; j >= list.size()-10; j--) {
                avgMax += list.get(j);
            }

            System.out.printf("%d: %.1f%n", i+1, avgMax/10);
            System.out.printf("%d: %.1f%n------%n", i+1, avgMin/10);

        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Emilio().run();
    }

}