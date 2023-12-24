package district2013_1;

import java.util.*;
import java.io.*;

public class DiceRoll {
    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/district2013_1/DiceRoll.dat"));
        //Scanner f = new Scanner(System.in);

        int n = f.nextInt();
        Random r = new Random();
        String[] colors = {"WHITE", "RED", "BLUE"};
        while (n-- > 0) {
            r.setSeed(f.nextLong());
            //0 = White, 1 = Red, 2 = Blue
            int[] faces = {0, 1, 2}; //[0] = Bottom [1] = Front [2] = Side
            int dir = r.nextInt(4) + 1;
            int times = r.nextInt(25) + 1;
            if ((dir == 1 ||dir == 2) && times % 2 == 1) {
                int temp = faces[0];
                faces[0] = faces[1];
                faces[1] = temp;
            }
            else if ((dir == 3 || dir == 4) && times % 2 == 1) {
                int temp = faces[0];
                faces[0] = faces[2];
                faces[2] = temp;
            }
            System.out.println(colors[faces[0]]);
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new DiceRoll().run();
    }

}