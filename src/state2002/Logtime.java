package state2002;

import java.text.SimpleDateFormat;
import java.util.*;
import java.io.*;

public class Logtime {

    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/state2002/Logtime.dat".toLowerCase()));
        //Scanner f = new Scanner(System.in);

        while (f.hasNext()) {
            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
            GregorianCalendar gc = new GregorianCalendar();
            gc.setTime(sdf.parse(f.nextLine()));
            GregorianCalendar a = new GregorianCalendar();
            a.setTime(sdf.parse("01/01/2002 00:00:00"));
            long s = (gc.getTimeInMillis() - a.getTimeInMillis()) / 1000;
            System.out.println(sdf.format(gc.getTime()) + " => " + s);
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Logtime().run();
    }

}