package a2021;

import java.util.*;

public class Ana {
    public void run() throws Exception {
        //Scanner f = new Scanner(new File("template.dat"));
        Scanner f = new Scanner(System.in);

        for (int i = 0; i < 12; i++) {

            int num = f.nextInt();
            System.out.printf("%d*%d=%d", num, num, num*num);

        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Ana().run();
    }

}