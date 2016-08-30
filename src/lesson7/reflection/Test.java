package lesson7.reflection;

import java.io.Serializable;

public abstract class Test implements Serializable, Cloneable {
    private int field;

    public Test(Object field) { }

    protected static void method(String[] params) { }
}