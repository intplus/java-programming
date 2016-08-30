package lesson7.junit;

/**
 * Created by alpo123 on 08.05.16.
 */
public class Housewife {

    private String name;
    private int age;

    public Housewife() {
    }

    public void feed(Cat[] cats) {
        for (Cat c: cats) {
            if (c.isHungry()) {
                c.setHungry(Boolean.FALSE);
            } else {
                throw new CatNotHungryException(c.getName() + " is not hungry!");
            }
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
