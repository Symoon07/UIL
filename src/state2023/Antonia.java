package state2023;

import java.util.*;
import java.io.*;

public class Antonia {

    public void run() throws Exception {
        //Scanner f = new Scanner(new File("Antonia.dat".toLowerCase()));
        //Scanner f = new Scanner(System.in);

        System.out.println("""
                BB
                RRRRRRRRRRRRRRRRRR
                A
                VVVVVVVVVVVVVVVVVVVVVV
                OOOOOOOOOOOOOOO

                UUUUUUUUUUUUUUUUUUUUU
                IIIIIIIII
                LLLLLLLLLLLL

                CCC
                OOOOOOOOOOOOOOO
                MMMMMMMMMMMMM
                PPPPPPPPPPPPPPPP
                SSSSSSSSSSSSSSSSSSS
                CCC
                IIIIIIIII
                """);

        //f.close();
    }

    public static void main(String[] args) throws Exception {
        new Antonia().run();
    }

}