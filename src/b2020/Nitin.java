package b2020;

import java.util.*;
import java.io.*;

public class Nitin {
    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/Input/nitin.dat"));
        //Scanner f = new Scanner(System.in);

        int pets = f.nextInt();
        Queue<String> clist = new LinkedList<>();
        Queue<String> dlist = new LinkedList<>();
        while (pets-- > 0) {
            String name = f.next();
            if (f.next().equals("D")) {
                dlist.add(name);
            }
            else {
                clist.add(name);
            }
        }

        int adopers = f.nextInt();
        ArrayList<String> alist = new ArrayList<>();
        while (adopers-- > 0) {
            alist.add(f.next());
            alist.add(f.next());
        }

        for (int i = 0; i < alist.size(); i+=2) {
            String name = alist.get(i);
            String prefer = alist.get(i+1);
            if (prefer.equals("D")) {
                if (dlist.isEmpty()) {
                    System.out.println(name + " WAIT LIST DOG");
                }
                else {
                    System.out.println(name + " DOG " + dlist.remove());
                }
            }
            else {
                if (clist.isEmpty()) {
                    System.out.println(name + " WAIT LIST CAT");
                }
                else {
                    System.out.println(name + " CAT " + clist.remove());
                }
            }
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Nitin().run();
    }

}