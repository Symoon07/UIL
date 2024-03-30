package richardson2022;

import java.util.*;
import java.io.*;

public class ForgetsIngredients {
    public double converter(double val, String unit) {
        double out = val;
        if (unit.equals("gallon")) {
            out *= 4;
            unit = "quart";
        }
        if (unit.equals("quart")) {
            out *= 2;
            unit = "pint";
        }
        if (unit.equals("pint")) {
            out *= 2;
            unit = "cup";
        }
        if (unit.equals("cup")) {
            out *= 16;
            unit = "tbsp";
        }
        if (unit.equals("tbsp")) {
            out *= 3;
        }
        return out;
    }

    public void run() throws Exception {
        //Scanner f = new Scanner(new File("template.dat"));
        Scanner f = new Scanner(System.in);

        int numForgets = f.nextInt();
        int ingredients = f.nextInt();
        String[] names = new String[ingredients];
        String[] units = new String[ingredients];
        double[] val = new double[ingredients];
        for (int i = 0; i < ingredients; i++) {
            names[i] = f.next();
            units[i] = f.next();
            val[i] = f.nextDouble();
        }

        for (int i = 0; i < ingredients; i++) {
            val[i] = converter(val[i], units[i]);
        }

        TreeMap<Double, String> temp = new TreeMap<>();
        ArrayList<String> out = new ArrayList<>();
        for (int i = 0; i < ingredients; i++) {
            temp.put(val[i], names[i]);
        }

        for (Double key : temp.keySet()) {
            if (numForgets-- > 0) {
                out.add(temp.get(key));
            }
        }
        Collections.sort(out);
        for (String s : out) {
            System.out.println(s);
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new ForgetsIngredients().run();
    }

}