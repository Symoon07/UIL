package district2013_1;

import java.util.*;
import java.io.*;

public class PhoneNumbers {

    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/district2013_1/PhoneNumbers.dat".toLowerCase()));
        //Scanner f = new Scanner(System.in);

        int n = f.nextInt();
        while (n-- > 0) {
            String s = f.next();
            System.out.println(s.matches("\\d{3}-\\d{3}-\\d{4}") ? s : "INVALID PHONE NUMBER");
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new PhoneNumbers().run();
    }

}