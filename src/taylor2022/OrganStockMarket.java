package taylor2022;

import java.util.*;
import java.io.*;

public class OrganStockMarket {
    public void run() throws Exception {
        //Scanner f = new Scanner(new File("template.dat"));
        Scanner f = new Scanner(System.in);

        double bal = f.nextDouble();
        int types = f.nextInt();
        f.next();
        HashMap<String, Double> prices = new HashMap<>();
        while (types-- > 0) {
            prices.put(f.next(), f.nextDouble());
        }
        f.next();

        while (f.hasNext()) {
            String in = f.next();
            if (in.equals("Buy") || in.equals("Sell")) {
                String organ = f.next();
                bal = in.equals("Buy") ? bal - prices.get(organ) : bal + prices.get(organ);
            }
            else {
                String change = f.next();
                double percent = f.nextInt() / 100.0;
                f.next();
                if (change.equals("up")) {
                    prices.put(in, prices.get(in) * (1 + percent));
                }
                else {
                    prices.put(in, prices.get(in) * (1 - percent));
                }
            }
        }
        System.out.println(bal);

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new OrganStockMarket().run();
    }

}