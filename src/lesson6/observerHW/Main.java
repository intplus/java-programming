package lesson6.observerHW;

/**
 * Created by alpo123 on 27.04.16.
 */
public class Main {
    public static void main(String[] args) {
        Publisher magazin = new Publisher();
        Publisher newspaper = new Publisher();

        Subscriber ivan = new Subscriber("Ivan");
        Subscriber petr = new Subscriber("Petr");
        Subscriber sergii = new Subscriber("Sergii");

        magazin.addObserver(ivan);
        newspaper.addObserver(petr);
        magazin.addObserver(sergii);
        magazin.addObserver(petr);

        for (int i = 0; i < 10; ++i) {
            System.out.println(i + "й день" );

            magazin.doTheJob();
            newspaper.doTheJob();

            System.out.println();
        }
    }
}
