package practice;

import java.util.*;

public class Password {
    public void run() throws Exception {
        //Scanner f = new Scanner(new File("template.dat"));
        Scanner f = new Scanner(System.in);

        int cases = f.nextInt();
        while (cases-- > 0) {

            int password = f.nextInt();
            String passwordStr = String.valueOf(password);
            if (passwordStr.length() < 6) {
                System.out.println("INVALID");
            }
            else if (password % 2 == 0) {
                System.out.println("INVALID");
            }

            else if (passwordStr.indexOf('3') == -1) {
                System.out.println("INVALID");
            }

            else if (password % 7 != 0) {
                System.out.println("INVALID");
            }

            else {
                System.out.println("VALID");
            }

        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Password().run();
    }

}