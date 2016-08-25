package lesson12.example1;

/**
 * Created by alpo123 on 19.07.16.
 */
public class MyThread extends Thread {

    @Override
    public void run() {
        System.out.println("Running " + Thread.currentThread().getName() + " " + this.getClass().getSimpleName());
    }
}
