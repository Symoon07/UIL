package b2020;

public class Aran {
    public void run() throws Exception {
        //Scanner f = new Scanner(new File("template.dat"));
        //Scanner f = new Scanner(System.in);

        for (int i = 1; i < 27; i++) {

            char cap = 'A';
            char low = 'a';
            System.out.printf("Day %d: ", i);
            for (int j = 0; j < i; j++) {
                System.out.print(cap++);
                System.out.print(low++);
            }

            System.out.println();

        }

        //f.close();
    }

    public static void main(String[] args) throws Exception {
        new Aran().run();
    }

}