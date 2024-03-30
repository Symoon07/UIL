package state2023;

import java.util.*;
import java.io.*;

public class Daria {

    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/state2023/Daria.dat".toLowerCase()));
        //Scanner f = new Scanner(System.in);

        int cases = f.nextInt();
        for (int i = 1; i <= cases; i++) {
            int n = f.nextInt();
            int questions = f.nextInt();
            double total = 0;
            double med = 0;
            ArrayList<Double> l = new ArrayList<>();
            String ans = f.next();
            for (int j = 0; j < n; j++) {
                String res = f.next();
                double correct = 0;
                for (int k = 0; k < ans.length(); k++) {
                    if (ans.charAt(k) == res.charAt(k)) {
                        correct++;
                    }
                }
                total += correct / questions * 100;
                l.add(correct / questions * 100);
            }
            Collections.sort(l);
            if (l.size() % 2 == 1) {
                med = l.get(l.size()/2);
            }
            else {
                med = (l.get(l.size()/2) + l.get(l.size()/2-1)) / 2.0;
            }
            System.out.printf("Assignment #%d:\nMean Score: %.2f\nMedian Score: %.1f\n", i, total / n, med);
            System.out.println();
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Daria().run();
    }

}