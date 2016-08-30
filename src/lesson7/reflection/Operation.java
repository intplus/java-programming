package lesson7.reflection;

/**
 * Created by alpo123 on 19.05.16.
 */
public class Operation {

    public static void main(String[] args) {
        inspectService(SimpleService.class);
        inspectService(LazyService.class);
        inspectService(String.class);
    }
    static void inspectService(Class<?> service) {
        if (service.isAnnotationPresent(Service.class) ) {
            Service ann = service.getAnnotation(Service.class);
            System.out.println(ann.name());
        }
    }
}
