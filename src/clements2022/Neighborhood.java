package clements2022;

import java.io.*;
import java.util.*;

public class Neighborhood {

    public static void main(String[] args) throws Exception {
        new Neighborhood().run();
    }

    public void run() throws Exception {
        Scanner file = new Scanner(new File("Data/clements2022/neighborhood.in"));
        //Scanner file = new Scanner(System.in);

        int names = file.nextInt();
        ArrayList<String> list = new ArrayList<>();
        while (names-- > 0) {
            list.add(file.next());
        }

        Collections.sort(list);
        int index = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).length() > max) {
                index = i;
                max = list.get(i).length();
            }
        }
        System.out.println(list.get(index));

        file.close();
    }
}