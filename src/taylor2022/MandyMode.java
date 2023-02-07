package taylor2022;

import java.util.*;
import java.io.*;

public class MandyMode {
    public void run() throws Exception {
        //Scanner f = new Scanner(new File("template.dat"));
        Scanner f = new Scanner(System.in);

        int cases = f.nextInt();
        f.nextLine();
        String vowels = "aeiou";
        while (cases-- > 0) {
            String[] in = f.nextLine().split(", ");
            String[] inNum = f.nextLine().split(",");
            int start = Integer.MAX_VALUE;
            for (int i = 0; i < in.length; i++) {
                for (int j = 0; j < 5;j++) {
                    if (in[i].indexOf(vowels.charAt(j)) < start && in[i].indexOf(vowels.charAt(j)) != -1) {
                        start = in[i].indexOf(vowels.charAt(j));
                    }
                }

                for (int j = 0; j < Integer.parseInt(inNum[i]); j++) {
                    String out = "m" + in[i].substring(start);
                    if (out.charAt(out.length()-1) == 's') {
                        out = out.substring(0, out.length()-1);
                    }
                    System.out.println(out);
                }
            }
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new MandyMode().run();
    }

}