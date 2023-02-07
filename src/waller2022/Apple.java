package waller2022;

public class Apple {
    public void run() throws Exception {
        //Scanner f = new Scanner(new File("template.dat"));
        //Scanner f = new Scanner(System.in);

        for (int i = 65; i <= 126; i++) {

            System.out.println(i + " " + (char)i);

        }

        //f.close();
    }

    public static void main(String[] args) throws Exception {
        new Apple().run();
    }

}