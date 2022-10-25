package practice;

import java.util.*;

public class KeyMaster {

    public void run() throws Exception {
        //Scanner f = new Scanner(new File("template.dat"));
        Scanner f = new Scanner(System.in);

        int cases = f.nextInt();
        while (cases-- > 0) {

            String in = f.nextInt() + f.nextInt() + "";
            String out = "";
            for (char c : in.toCharArray()) {
                out += (char)(c-48+65);
            }

            System.out.println(out);

        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new KeyMaster().run();
    }

}