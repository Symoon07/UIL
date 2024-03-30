package practice;

import java.util.*;
import java.io.*;

public class QuestionMark {
    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/practice/QuestionMark.dat".toLowerCase()));
        //Scanner f = new Scanner(System.in);

        int cases = f.nextInt(); f.nextLine();
        while (cases-- > 0) {
            String[] line = f.nextLine().replace("?", "%1$s").split("\\. ");
            System.out.printf(line[0] + ".\n", line[1]);
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new QuestionMark().run();
    }

}