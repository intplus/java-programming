package lesson5.shop;

import java.util.Date;

public class Purchase {
    Product p;
    Customer c;
    int date;
    int quantity;
    public Purchase() {

    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public Purchase(Product p, Customer c, int quantity) {
        this.p = p;
        this.c = c;
        this.quantity = quantity;
    }

    public Purchase(Date date, Product p, Customer c, int quantity) {

    }

    public Product getP() {
        return p;
    }

    public void setP(Product p) {
        this.p = p;
    }

    public Customer getC() {
        return c;
    }

    public void setC(Customer c) {
        this.c = c;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

}