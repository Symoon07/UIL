package clements2023;

import java.text.SimpleDateFormat;
import java.util.*;
import java.io.*;

public class Calendar {

    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/clements2023/Calendar.dat"));
        //Scanner f = new Scanner(System.in);

        int n = f.nextInt();
        while (n --> 0) {
            String[] date = f.next().split("/");
            int days = f.nextInt();
            SimpleDateFormat sdf = new SimpleDateFormat("MMMMMMMM d, yyyy");
            GregorianCalendar cur = new GregorianCalendar(Integer.parseInt(date[2]), Integer.parseInt(date[0])-1, Integer.parseInt(date[1]));
            cur.add(java.util.Calendar.DAY_OF_YEAR, days);
            System.out.println(sdf.format(cur.getTime()));
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Calendar().run();
    }

}