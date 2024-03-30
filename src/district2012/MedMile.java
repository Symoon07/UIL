package district2012;

import java.util.*;
import java.io.*;

public class MedMile {

    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/district2012/MedMile.dat".toLowerCase()));
        //Scanner f = new Scanner(System.in);

        int n = f.nextInt(); f.nextLine();
        while (n-- > 0) {
            String[] line = f.nextLine().split(" ");
            String name = line[0];
            ArrayList<Double> times = new ArrayList<>();
            for (int i = 1; i < line.length; i++) {
                times.add(Integer.parseInt(line[i].substring(0,2)) * 60.0 + Double.parseDouble(line[i].substring(3)));
            }
            Collections.sort(times);
            if (times.size() % 2 == 1) {
                double time = times.get(times.size()/2);
                int min = (int) (time / 60);
                double sec = time % 60;
                System.out.printf("%s %d:%05.2f\n", name, min, sec);
            }
            else {
                double avg = (times.get(times.size()/2-1) + times.get(times.size()/2)) / 2;
                int min = (int) (avg / 60);
                double sec = avg % 60;
                System.out.printf("%s %d:%05.2f\n", name, min, sec);
            }
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new MedMile().run();
    }

}