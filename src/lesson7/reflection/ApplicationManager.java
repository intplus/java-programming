package lesson7.reflection;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ApplicationManager {

    private boolean startService = false;

    public <T> ApplicationManager(Class<T> c) {
        haveAnnotation(c);
        startService = true;
        if (startService) {
            System.out.println("Start Service");
        }
    }

    public static <T> T getService(Class<T> clazz) throws InvocationTargetException, IllegalAccessException, InstantiationException {

        for (Annotation ann : clazz.getAnnotations()) {

            if (ann instanceof Service) {
                // Initialization of the service
                for (Method method : clazz.getClass().getMethods()) {
                    for (Annotation methodAnn : method.getAnnotations()) {
                        if (methodAnn.annotationType().getSimpleName().equals(initService.class.getSimpleName())) {
                            T serv = clazz.newInstance();
                            method.invoke(serv);
                            return serv;
                        }

                    }

                }
            }

        }
        return null;
    }

    public <T> void haveAnnotation(Class<T> c) {
        Method[] method = c.getMethods();
        for(Method md: method) {
            if(md.isAnnotationPresent(initService.class)) {
                System.out.println("method have annotation");

            }

        }
    }

    public boolean isStartService() {
        return startService;
    }

    public void setStartService(boolean startService) {
        this.startService = startService;
    }
}
