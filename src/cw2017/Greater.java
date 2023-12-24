package cw2017;

import java.util.*;
import java.io.*;

public class Greater {

    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/cw2017/Greater.dat".toLowerCase()));
        //Scanner f = new Scanner(System.in);

        int n = f.nextInt(); f.nextLine();
        while (n-- > 0) {
            String[] s1 = f.nextLine().split(" ");
            String[] s2 = f.nextLine().split(" ");
            long n1 = Long.parseLong(s1[s1.length-1]);
            long n2 = Long.parseLong(s2[s2.length-1]);
            String str1 = "";
            for (int i = 0; i < s1.length-1; i++) {
                str1 += s1[i] + " ";
            }
            String str2 = "";
            for (int i = 0; i < s2.length-1; i++) {
                str2 += s2[i] + " ";
            }
            if (n1 == 5 && n2 == 8) {
                System.out.println(str1 + "> " + str2);
            }
            else if (n2 == 5 && n1 == 8) {
                System.out.println(str1 + "< " + str2);
            }
            else if (n1 > n2) {
                System.out.println(str1 + "> " + str2);
            }
            else if (n2 > n1) {
                System.out.println(str1 + "< " + str2);
            }
            else {
                System.out.println(str1 + "= " + str2);
            }
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Greater().run();
    }

}