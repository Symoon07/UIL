package richardson2022;

import java.util.*;
import java.io.*;

public class RecipeBook {
    public void run() throws Exception {
        //Scanner f = new Scanner(new File("template.dat"));
        Scanner f = new Scanner(System.in);

        TreeSet<Integer> even = new TreeSet<>();
        NavigableSet<Integer> odd = new TreeSet<Integer>().descendingSet();
        while (f.hasNextInt()) {
            int num = f.nextInt();
            if (num % 2 == 0) {
                even.add(num);
            }
            else {
                odd.add(num);
            }
        }

        ArrayList<Integer> out = new ArrayList<>();
        out.addAll(even);
        out.addAll(odd);
        for (int num : out) {
            System.out.print(num + " ");
        }


        f.close();
    }

    public static void main(String[] args) throws Exception {
        new RecipeBook().run();
    }

}