package lesson5.shop;

import java.util.ArrayList;
import java.util.Map;

public class Goods {
    private int price;
    private String name;
    private int quantity;
    private Map<Product, Integer> order;

    private ArrayList<Product> productsHikvision = new ArrayList<>();
    private ArrayList<Product> productsActiveCam = new ArrayList<>();
    private ArrayList<Product> productsServers = new ArrayList<>();

    public Goods (Map order) {
        this.order = order;
    }

    public void sell(String name, Customer c, int quantity) {

    }

    public ArrayList<Product> getProducts(int index) {
        switch (index) {
            case 1: {
                return productsHikvision;
            }
            case 2: {
                return productsActiveCam;
            }
            case 3: {
                return productsServers;
            }
        }

        return productsHikvision;
    }

    public void addProduct(int index, Product p) {
        switch (index) {
            case 1: {
                productsHikvision.add(p);
                break;
            }
            case 2: {
                productsActiveCam.add(p);
                break;
            }
            case 3: {
                productsServers.add(p);
            }
        }
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Product> getProductsActiveCam() {
        return productsActiveCam;
    }

    public void setProductsActiveCam(ArrayList<Product> productsActiveCam) {
        this.productsActiveCam = productsActiveCam;
    }

    public ArrayList<Product> getProductsHikvision() {
        return productsHikvision;
    }

    public void setProductsHikvision(ArrayList<Product> productsHikvision) {
        this.productsHikvision = productsHikvision;
    }

    public ArrayList<Product> getProductsServers() {
        return productsServers;
    }

    public void setProductsServers(ArrayList<Product> productsServers) {
        this.productsServers = productsServers;
    }

    @Override
    public String toString() {
        return this.getName();
    }
}