package lesson7.reflection;

/**
 * Created by alpo123 on 19.05.16.
 */
public class LazyService {

    @Init
    public void LazyInit () throws Exception {
        System.out.println("VeryLazyInit");
    }
}
