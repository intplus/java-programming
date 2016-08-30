package lesson6.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class RTTIPrivateConstructorCall {

    public static void main(String[] args) {
        try {

            UtilityClass      instance;
            Constructor<UtilityClass>  privateConstructor =
                    UtilityClass.class.getDeclaredConstructor();
            privateConstructor.setAccessible(true);

            instance = privateConstructor.newInstance();

            System.out.println("Hello from " + instance);

        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
}
