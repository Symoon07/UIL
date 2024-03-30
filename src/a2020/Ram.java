package a2020;

import java.util.*;
import java.io.*;

public class Ram {
    public String reverse(String word) {
        String out = "";

        for (int i = word.length()-1; i >= 0; i--)
            out += word.charAt(i);

        return out;
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/a2020/ram.dat"));
        //Scanner f = new Scanner(System.in);

        String in = "";
        while (f.hasNextLine()) {
            in += f.nextLine();
            in += " ";
        }

        String[] inArr = in.split(" ");
        String out = "";
        for (String s : inArr) {
            if (!Character.isLetterOrDigit(s.charAt(0))) {
                if (!Character.isLetterOrDigit(s.charAt(s.length()-1))) {
                    out += s.charAt(0);
                    out += reverse(s.substring(1,s.length()-1));
                    out += s.charAt(s.length()-1) + " ";
                }
                else {
                    out += s.charAt(0);
                    out += reverse(s.substring(1)) + " ";
                }
            }
            else if (!Character.isLetterOrDigit(s.charAt(s.length()-1))) {
                out += reverse(s.substring(0,s.length()-1));
                out += s.charAt(s.length()-1) + " ";
            }
            else {
                out += reverse(s) + " ";
            }
        }

        System.out.println(out);

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Ram().run();
    }

}