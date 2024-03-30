package practice;

import java.util.*;

public class PriceIsRight {
    public void run() throws Exception {
        //Scanner f = new Scanner(new File("template.dat"));
        Scanner f = new Scanner(System.in);

        int cases = f.nextInt();
        while (cases-- > 0) {

            int opp = f.nextInt();
            int retail = f.nextInt();
            if (opp > retail) {
                System.out.println("$1");
            }
            else {
                System.out.println("$" + (opp + 1));
            }

        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new PriceIsRight().run();
    }

}