package b2018;

import java.util.*;
import java.io.*;

public class Baldo {

    public void run() throws Exception {
        //Scanner f = new Scanner(new File("Data/b2018/Baldo.dat".toLowerCase()));
        //Scanner f = new Scanner(System.in);

        for (int i = 65; i <= 90; i++) {
            System.out.printf("%c %d %c %d\n", i, i, i + 32, i + 32);
        }

        //f.close();
    }

    public static void main(String[] args) throws Exception {
        new Baldo().run();
    }

}