public class Main {

    public static void main(String[] args) {

        int[] werte = {5, 3, 7, 2, 4, 6, 8, 1, 0};

        Baum baum = new Baum();

        for (int wert : werte) {
            baum.einfuegen(wert);
        }

        baum.durchlaufen();

        System.out.println("Minimum: " + baum.findeMin());
        System.out.println("Maximum: " + baum.findeMax());

        System.out.println(baum.suche(11));
    }
}
