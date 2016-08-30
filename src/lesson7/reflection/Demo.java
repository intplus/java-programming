package lesson7.reflection;
import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Demo {
    private int storeCounter;

    public Demo() {
        storeCounter = 0;
    }

    public static void main(String [ ] args)
    {
        Map <String,Object> hm = new HashMap<>();

        Class c = NewClass.class;
//        hm.put("str", "yes");
        hm.put("i", 5);
//        hm.put("bool", false);
        initClass(c, hm);
//        List<Object> list = new ArrayList<>();
//        list.add(4);
//        list.add("we");
//        list.add(true);
//        initClass(c, list);

        workWithAnnotations(c);



    }

    public static <T> void workWithAnnotations(Class<T> c) {
        if (!c.isAnnotationPresent(Service.class)) {
            System.err.println("no annotation");
        } else {
            System.out.println("class annotated ; name - " + c.getAnnotation(Service.class));
            new ApplicationManager(c);
        }

    }

    public int getStoreCounter() {
        return storeCounter;
    }

    public <T> void initClass (Class<T> c, List<Object> list) {

        storeCounter++;

        try {

            Class[] paramTypes = new Class[list.size()];
            for(int i = 0; i < paramTypes.length; i++) {
                System.out.println(list.get(i).getClass());
                paramTypes[i] = list.get(i).getClass();
            }

            Object[] o = list.toArray(new Object[list.size()]);

            Constructor<T> con =
                    c.getDeclaredConstructor(paramTypes);
            System.out.println(list);
            con.newInstance(o);
            System.out.println("Constructor = " + con.toString());

        }
        catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        catch (InvocationTargetException el) {
            el.printStackTrace();
        }
        catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    public static <T> void initClass (Class<T> c, Map<String, Object> map) {
        try {
            T obj = c.newInstance();
            Field [] fs = obj.getClass().getDeclaredFields();
            for (String key : map.keySet()) {
                for (Field f : fs) {

                    if (f.getName().equals(key)) {
                        System.out.println(f.getName() + " = " + map.get(key));
                        f.setAccessible(true);
                        f.set(obj, map.get(key));
                    }
                }
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
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
    static String getParameters(Class[] params) {
        String p = "";
        for (int i = 0, size = params.length; i < size; i++) {
            if (i > 0) p += ", ";
            p += getType(params[i]) + " param" + i;
        }
        return p;
    }
    static String getType(Class clazz) {
        String type = clazz.isArray()
                ? clazz.getComponentType().getSimpleName()
                : clazz.getSimpleName();
        if (clazz.isArray()) type += "[]";
        return type;
    }
}