package lesson5.shop;

import java.util.Date;

public class Purchase {
    Product p;
    Customer c;
    int quantity;
    Date date;
    int i = 0;
    public Purchase() {

    }

    public Date getDate() {
        return date;
    }


    public Purchase(Date date, Product p, Customer c, int quantity) {
        i++;
        this.date = date;
        this.p = p;
        this.c = c;
        this.quantity = quantity;
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