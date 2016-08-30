package lesson7.reflection;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class RefInfo {

    public void printClassinfo(Class o) {

        Package p = o.getPackage();
        System.out.println("package " + p.getName() + ";");

        int modifiers = o.getModifiers();
        System.out.print(getModifiers(modifiers));
        System.out.print("class " + o.getSimpleName() + " ");
        if (!o.getSuperclass().getSimpleName().equals("Object")) {
            System.out.print("extends " + o.getSuperclass().getSimpleName() + " ");
        }
        Class[] interfaces = o.getInterfaces();
        for (int i = 0, size = interfaces.length; i < size; i++) {
            System.out.print(i == 0 ? "implements " : ", ");
            System.out.print(interfaces[i].getSimpleName());
        }
        System.out.println();
    }

    public void printClassMethod(Class o) {

        Method[] methods = o.getDeclaredMethods();
        for (Method m : methods) {
            Annotation[] annotations = m.getAnnotations();
            System.out.print("\t");
            for (Annotation a : annotations)
                System.out.print("@" + a.annotationType().getSimpleName() + " ");
            System.out.println();

            System.out.print("\t" + getModifiers(m.getModifiers()) +
                    getType(m.getReturnType()) + " " + m.getName() + "(");
            System.out.print(getParameters(m.getParameterTypes()));
            System.out.println(") { }");
        }

    }

    static String getType(Class o) {
        String type = o.isArray() ? o.getComponentType().getSimpleName() : o.getSimpleName();
        if (o.isArray()) type += "[]";
        return type;
    }

    static String getParameters(Class[] params) {
        String p = "";
        for (int i = 0, size = params.length; i < size; i++) {
            if (i > 0) p += ", ";
            p += getType(params[i]) + " param" + i;
        }
        return p;
    }

    public void printClassFields(Class o) {
        Field[] fields = o.getDeclaredFields();
        for (Field field : fields) {
            System.out.println("\t" + getModifiers(field.getModifiers())
                    + getType(field.getType()) + " " + field.getName() + ";");
        }
    }
    static String getModifiers(int m) {
        String modifiers = "";
        if (Modifier.isPublic(m)) modifiers += "public ";
        if (Modifier.isProtected(m)) modifiers += "protected ";
        if (Modifier.isPrivate(m)) modifiers += "private ";
        if (Modifier.isStatic(m)) modifiers += "static ";
        if (Modifier.isAbstract(m)) modifiers += "abstract ";
        return modifiers;
    }
}
