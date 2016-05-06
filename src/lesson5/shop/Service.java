package lesson5.shop;

import java.util.Date;
import java.util.LinkedList;

public class Service {
    private static LinkedList<Product> products = new LinkedList<>();
    private static LinkedList<Customer> customer = new LinkedList<>();
    private static LinkedList<Purchase> purchase = new LinkedList<>();
    Goods shop;


    public Service(Goods shop) {
        this.shop = shop;

    }

    public static LinkedList<Purchase> getPurchase() {
        return purchase;
    }

    public static void Initialisation() {
        products.add(new Product("DS-2CD2012", 85));
        products.add(new Product("DS-2CD2032", 105));
        products.add(new Product("DS-2CD8153", 56));

        customer.add(new Customer("Andrey"));
        customer.add(new Customer("Vlad"));

//        purchase.add(new Purchase(210116, customer.get(0), products.get(0), 10));
//        purchase.add(new Purchase(220116, customer.get(0), products.get(2), 15));
//        purchase.add(new Purchase(220116, customer.get(1), products.get(0), 2));
//        purchase.add(new Purchase(240116, customer.get(0), products.get(1), 1));
//        purchase.add(new Purchase(240116, customer.get(0), products.get(1), 2));
//        purchase.add(new Purchase(250116, customer.get(1), products.get(0), 8));
    }

    public void sale(Product p, Customer c, int quantity) {
        Date date = new Date();
        purchase.add(new Purchase(date, p, c, quantity));
        System.out.println(date + "  " + c + "  " + p + "   " + quantity + " pcs");

    }

    public static void printStock() {
        System.out.println("-------------------------------");
//        for (int i = 0; i < lastSymbol(); ++i) {
//            System.out.print(goods[i].getName() + "  ");
//            System.out.print(goods[i].getPrice() + "  ");
//            System.out.println(goods[i].getQuantity());
//
//        }

    }
    public static void last7days() {
        int day;
        int quantity = 0;
        int today = 25;

//        for (int i = 0; i < purchase.length; ++i) {
//            day = purchase[i].getDate()/10000;
//            if (day < today - 7) continue;
//            if (day == 0) break;
//            printSale(i);
//            quantity +=purchase[i].getQuantity();
//
//        }
//        System.out.println("quantity = " + quantity);

    }
    private static void printSale(int i) {
//        System.out.print(purchase[i].getDate() + "  ");
//        System.out.print(purchase[i].getCustomer() + "  ");
//        System.out.print(purchase[i].getGoods() + "  ");
//        System.out.println(purchase[i].getQuantity());
    }

}
