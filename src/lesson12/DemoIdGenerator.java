package lesson12;

/**
 * Created by alpo123 on 25.07.16.
 */
public class DemoIdGenerator {
    public static void main(String[] args) {
        IdGenerator id = new IdGenerator();


        for (int i=0; i<200; i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(id.getNextId());
                }
            }).start();
        }
    }
}
