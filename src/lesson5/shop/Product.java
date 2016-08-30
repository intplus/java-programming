package lesson5.shop;

public class Product {
    private String name;
    private int goods_id;
    private double price;
    private int category;

    public Product() {

    }
    public Product(int category, int goods_id, String name, double price) {
        this.category = category;
        this.goods_id = goods_id;
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(int goods_id) {
        this.goods_id = goods_id;
    }

    public int getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return this.name + "    " + this.price + "$";

    }
}
