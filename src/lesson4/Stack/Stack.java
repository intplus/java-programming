package lesson4.Stack;

import java.util.ArrayList;
import java.util.List;

public class Stack {
    List <Object> array = new ArrayList<Object>();

    public void push(Object obj) {
        array.add(obj);
    }
    public Object pop() {
        Object o = peak();
        array.remove(array.size() - 1);
        return o;
    }
    public Object peak() {
        return array.get(array.size() - 1);
    }
    public void print() {
        System.out.println(array);
    }

}
