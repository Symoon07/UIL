package state2020;

import java.text.SimpleDateFormat;
import java.util.*;
import java.io.*;

public class Grey {

    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/state2020/Grey.dat".toLowerCase()));
        //Scanner f = new Scanner(System.in);

        int t = f.nextInt();
        while (t --> 0) {
            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
            GregorianCalendar gc = new GregorianCalendar();
            gc.setTime(sdf.parse(f.next()));
            int weeks = f.nextInt();
            gc.add(Calendar.WEEK_OF_YEAR, -weeks);
            System.out.println(sdf.format(gc.getTime()));
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Grey().run();
    }

}