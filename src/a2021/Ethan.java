package a2021;

import java.util.*;
import java.io.*;

public class Ethan {
    class Point {
        final int x;
        final int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public static double getDistance(Point one, Point two) {
            return Math.hypot(Math.max(one.x, two.x) - Math.min(one.x, two.x), Math.max(one.y, two.y) - Math.min(one.y, two.y));
        }
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/Input/ethan.dat"));
        //Scanner f = new Scanner(System.in);

        int cases = f.nextInt();
        for (int i = 0; i < cases; i++) {

            double distance = 0;
            int dim = f.nextInt();
            HashMap<Integer, Point> lock = new HashMap<>();
            for (int j = 0; j < dim; j++) {
                for (int k = 0; k < dim; k++) {
                    lock.put(f.nextInt(), new Point(k, j));
                }
            }

            for (int j = 1; j < lock.size(); j++) {
                distance += Point.getDistance(lock.get(j), lock.get(j+1));
            }

            System.out.printf("Case %d distance: #%.4f%n", i+1, distance);

        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Ethan().run();
    }

}