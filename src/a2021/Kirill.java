package a2021;

import java.util.*;

public class Kirill {
    public void run() throws Exception {
        //Scanner f = new Scanner(new File("template.dat"));
        Scanner f = new Scanner(System.in);

        int cases = f.nextInt();
        for (int i = 1; i <= cases; i++) {

            for (int j = f.nextInt(); j > 0; j--) {
                if (isSelfNumber(j)) {
                    System.out.printf("Case #%1$d: %2$d%n", i, j);
                    break;
                }
            }

        }

        f.close();
    }

    public boolean isSelfNumber (int num) {
        for (int i = 0; i <= num; i++) {
            int temp = i;
            int sum = temp;
            while (temp != 0) {
                sum += temp % 10;
                temp /= 10;
            }

            if (sum == num) return false;
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        new Kirill().run();
    }

}