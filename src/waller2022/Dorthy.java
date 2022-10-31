package waller2022;

import java.io.File;
import java.util.*;

public class Dorthy {
    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/waller2022/Dorthy.dat"));
        //Scanner f = new Scanner(System.in);

        String one = f.next().toLowerCase();
        String two = f.next().toLowerCase();
        int oneVol = 0;
        int oneCon = 0;
        int twoVol = 0;
        int twoCon = 0;
        String vowels = "aeiou";
        for (int i = 0; i < one.length(); i++) {
            if (vowels.indexOf(one.charAt(i)) != -1) {
                oneVol++;
            }
            else {
                oneCon++;
            }
        }
        for (int i = 0; i < two.length(); i++) {
            if (vowels.indexOf(two.charAt(i)) != -1) {
                twoVol++;
            }
            else {
                twoCon++;
            }
        }

        System.out.println("Vowels:" + oneVol);
        System.out.println("Constants:" + oneCon);
        System.out.println(oneVol == oneCon ? "Same" : oneVol > oneCon ? "Vowels" : "Constants");
        System.out.println("Vowels:" + twoVol);
        System.out.println("Constants:" + twoCon);
        System.out.println(twoVol == twoCon ? "Same" : twoVol > twoCon ? "Vowels" : "Constants");

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Dorthy().run();
    }

}