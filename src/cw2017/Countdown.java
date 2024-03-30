package cw2017;

import java.text.SimpleDateFormat;
import java.util.*;
import java.io.*;

public class Countdown {

    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/cw2017/Countdown.dat"));
        //Scanner f = new Scanner(System.in);

        int n = f.nextInt();
        while (n-- > 0) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
            Date sw = sdf.parse("15/12/2017");
            Date cur = sdf.parse(f.next());
            int days = (int) ((sw.getTime() - cur.getTime()) / 86400000);
            System.out.println(days == 0 ? "It's Today!" : days + " day(s) left!");
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Countdown().run();
    }

}