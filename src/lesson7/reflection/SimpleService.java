package lesson7.reflection;

/**
 * Created by alpo123 on 19.05.16.
 */
public class SimpleService {

    @Init
    public void InitService() {
        System.out.println("SuperSimpleService");

    }

    public void Init2Service() {
        System.out.println("No");
    }
}
