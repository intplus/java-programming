package lesson5.shop;

public class Customer {
    private String name;
//    private String number;
    public Customer () {

    }
    public Customer(String name) {
        this.name = name;
//        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.getName();
    }
}