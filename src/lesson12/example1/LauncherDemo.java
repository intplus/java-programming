package lesson12.example1;

/**
 * Created by alpo123 on 19.07.16.
 */
public class LauncherDemo {

    public static void main(String[] args) {
        System.out.println("Running " + Thread.currentThread().getName());

        new MyThread().run();

        new MyThread().start();

        new Thread(new MyRunnable()).start();
    }
}
