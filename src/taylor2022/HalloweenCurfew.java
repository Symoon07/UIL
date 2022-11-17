package taylor2022;

import java.util.*;
import java.io.*;

public class HalloweenCurfew {
    public void run() throws Exception {
        //Scanner f = new Scanner(new File("template.dat"));
        Scanner f = new Scanner(System.in);

        int cases = f.nextInt();
        f.nextLine();
        while (cases-- > 0) {

            String[] in = f.nextLine().split(" ");
            int hourStart = Integer.parseInt(in[0].substring(0,in[0].indexOf(":")));
            int minStart = Integer.parseInt(in[0].substring(in[0].indexOf(":") + 1));
            int time = Integer.parseInt(in[1]);
            String name = in[2];
            int hourCur = Integer.parseInt(in[3].substring(0,in[3].indexOf(":")));
            int minCur = Integer.parseInt(in[3].substring(in[3].indexOf(":") + 1));

            if (hourStart * 60 + minStart  + time > hourCur * 60 + minCur) {
                System.out.println(name + " is in trouble");
            }
            else {
                System.out.println(name + " is not in trouble");
            }
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new HalloweenCurfew().run();
    }

}
