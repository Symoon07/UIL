package district2013_1;

import java.util.*;
import java.io.*;

public class Qualified {

    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/district2013_1/Qualified.dat".toLowerCase()));
        //Scanner f = new Scanner(System.in);

        int n = f.nextInt();
        while (n-- > 0) {
            String s = f.next();
            int score = f.nextInt();
            String c = f.next();
            switch (c) {
                case "STC": {
                    if (score >= 560) {
                        System.out.println(s);
                        break;
                    }
                }
                case "WTC": {
                    if (score >= 340) {
                        System.out.println(s);
                        break;
                    }
                }
                case "NTC": {
                    if (score >= 420) {
                        System.out.println(s);
                        break;
                    }
                }
                case "CTC": {
                    if (score >= 370) {
                        System.out.println(s);
                        break;
                    }
                }
                case "LVC": {
                    if (score >= 470) {
                        System.out.println(s);
                        break;
                    }
                }
            }
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Qualified().run();
    }

}