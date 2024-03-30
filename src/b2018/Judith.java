package b2018;

import java.math.BigDecimal;
import java.util.*;
import java.io.*;

public class Judith {
    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/b2018/judith.dat"));
        //Scanner f = new Scanner(System.in);

        ArrayList<BigDecimal> list = new ArrayList<>();
        while (f.hasNext()) {
            String in = f.next();
            list.add(new BigDecimal(in));
        }
        Collections.sort(list);

        for (BigDecimal dec : list) {
            System.out.println(dec);
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Judith().run();
    }

}