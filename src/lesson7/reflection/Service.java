package lesson7.reflection;

import java.lang.annotation.*;

@Inherited
@Target(ElementType.TYPE)
@Retention(value = RetentionPolicy.RUNTIME)
public @interface Service {

    String name();

    boolean lazyLoad() default false;

}
