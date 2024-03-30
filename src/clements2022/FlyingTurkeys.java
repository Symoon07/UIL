package clements2022;

import java.io.*;
import java.util.*;
public class FlyingTurkeys {

    public static void main(String[] args) throws Exception {
        new FlyingTurkeys().run();
    }

    public void run() throws Exception {
        Scanner file = new Scanner(new File("Data/clements2022/flyingturkeys.in"));
        //Scanner file = new Scanner(System.in);

        int trees = file.nextInt();
        int[] in = new int[trees];
        for (int i = 0; i < trees; i++) {
            in[i] = file.nextInt();
        }

        int max = 0;
        for (int i = 0; i < trees; i++) {
            int height = in[i];
            int dis = 0;
            for (int j = i; j < trees; j++) {
                if (height >= in[j]) {
                    dis++;
                    height--;
                }
                else {
                    break;
                }
            }
            max = Math.max(max, dis);
        }
        System.out.println(max-1);

        file.close();
    }
}