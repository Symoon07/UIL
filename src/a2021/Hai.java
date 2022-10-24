package a2021;

import java.util.*;
import java.io.*;

public class Hai {
    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/Input/hai.dat"));
        //Scanner f = new Scanner(System.in);

        String[] arr = f.nextLine().split(" ");
        int cases = f.nextInt();
        while (cases-- > 0) {

            String expression = f.next();
            ArrayList<String> list = new ArrayList<>();
            for (String s : arr) {
                if (s.matches(expression)) {
                    list.add(s);
                }
            }

            String out = "";
            for (int i = 0; i < list.size(); i++) {
                if (i == list.size()-1) {
                    out += list.get(i);
                }
                else {
                    out += list.get(i) + " ";
                }
            }

            if (list.size() != 0) {
                System.out.printf("%-10s%s%n", expression, out);
            }
            else {
                System.out.printf("%-10sNo matches%n", expression);
            }

        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Hai().run();
    }

}