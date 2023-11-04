package shootout;

import java.text.SimpleDateFormat;
import java.util.*;
import java.io.*;

public class Tomorrow {

    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/shootout/Tomorrow.dat".toLowerCase()));
        //Scanner f = new Scanner(System.in);

        int t = f.nextInt();
        while (t --> 0) {
            int month = f.nextInt();
            int day = f.nextInt();
            int year = f.nextInt();
            SimpleDateFormat sdf = new SimpleDateFormat("MM dd yyyy");
            GregorianCalendar in = new GregorianCalendar(year, month-1, day);
            in.add(Calendar.DAY_OF_YEAR, 1);
            System.out.println(sdf.format(in.getTime()));
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Tomorrow().run();
    }

}