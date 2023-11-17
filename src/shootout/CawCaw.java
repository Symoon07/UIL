package shootout;

import java.util.*;
import java.io.*;

public class CawCaw {

    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/shootout/CawCaw.dat".toLowerCase()));
        //Scanner f = new Scanner(System.in);



        f.close();
    }

    public static void main(String[] args) throws Exception {
        new CawCaw().run();
    }

}