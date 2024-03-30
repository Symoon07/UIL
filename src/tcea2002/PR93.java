package tcea2002;

import java.util.*;
import java.io.*;

public class PR93 {

    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/tcea2002/PR93.dat".toLowerCase()));
        //Scanner f = new Scanner(System.in);

        int n = f.nextInt();
        while (n-- > 0) {
            String s = f.next();
            String word = s.substring(1);
            char[][] mat = new char[word.length() * 2][word.length()];
            for (char[] chars : mat) {
                Arrays.fill(chars, ' ');
            }
            if (s.charAt(0) == 'L') {
                for (int i = 0; i < word.length(); i++) {
                    mat[i][word.length()-i-1] = word.charAt(i);
                }
                for (int i = 0; i < word.length(); i++) {
                    mat[i+word.length()][i] = word.charAt(word.length()-i-1);
                }
            }
            else {
                for (int i = 0; i < word.length(); i++) {
                    mat[i][i] = word.charAt(i);
                }
                for (int i = 0; i < word.length(); i++) {
                    mat[i+word.length()][word.length()-i-1] = word.charAt(word.length()-i-1);
                }
            }
            for (int i = 0; i < mat.length; i++) {
                for (int j = 0; j < mat[i].length; j++) {
                    System.out.print(mat[i][j]);
                }
                System.out.println();
            }
            System.out.println();
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new PR93().run();
    }

}