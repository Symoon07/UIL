package state2003;

import java.util.*;
import java.io.*;

public class SpaceCamp {
    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/state2003/SpaceCamp.dat".toLowerCase()));
        //Scanner f = new Scanner(System.in);

        while (f.hasNext()) {
            f.next();
            String[] rooms = new String[5];
            String[][] buttons = new String[4][5];
            int out = 1;
            for (int i = 0; i < 5; i++) {
                rooms[i] = f.next();
            }
            for (int i = 0; i < buttons.length; i++) {
                for (int j = 0; j < buttons[i].length; j++) {
                    buttons[i][j] = f.next();
                }
            }
            for (int i = 0; i < rooms.length-1; i++) {
                if (rooms[i+1].equals("O")) {
                    continue;
                }
                for (int j = 0; j < buttons[i].length; j++) {
                    switch (buttons[i][j]) {
                        case "O" -> rooms[j] = "O";
                        case "C" -> rooms[j] = "C";
                        case "T" -> {
                            if (rooms[j].equals("C")) {
                                rooms[j] = "O";
                            }
                            else {
                                rooms[j] = ("C");
                            }
                        }
                    }
                }
                ghost: if (rooms[i].equals("O")) {
                    for (int j = i; j >= 0; j--) {
                        if (rooms[j].equals("C")) {
                            break ghost;
                        }
                    }
                    out = -1;
                    break;
                }
                if (rooms[i+1].equals("C")) {
                    out = 0;
                    break;
                }
            }
            System.out.println(out == -1 ? "SPACE GHOST" : out == 0 ? "SPACE MONKEY" : "SPACE CADET");
            f.next();
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new SpaceCamp().run();
    }

}