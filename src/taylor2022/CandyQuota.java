package taylor2022;

import java.util.*;

public class CandyQuota {
    public void run() throws Exception {
        //Scanner f = new Scanner(new File("template.dat"));
        Scanner f = new Scanner(System.in);

        while (f.hasNext()) {

            int skittles = f.nextInt();
            int snickers = f.nextInt();
            int reese = f.nextInt();
            int total = skittles * 11 + snickers * 20 + reese * 8;
            System.out.println(total > 600 ? "False" : "True");

        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new CandyQuota().run();
    }

}