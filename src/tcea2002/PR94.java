package tcea2002;

import java.text.SimpleDateFormat;
import java.util.*;
import java.io.*;

public class PR94 {

    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/tcea2002/PR94.dat".toLowerCase()));
        //Scanner f = new Scanner(System.in);

        int n = f.nextInt();
        while (n-- > 0) {
            String[] s = f.next().split("/");
            int d = f.nextInt();
            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
            GregorianCalendar cur = new GregorianCalendar(Integer.parseInt(s[2]), Integer.parseInt(s[0])-1, Integer.parseInt(s[1]));
            cur.add(Calendar.DAY_OF_YEAR, d);
            System.out.println(sdf.format(cur.getTime()));
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new PR94().run();
    }

}