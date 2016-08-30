package com.alex;

import java.util.ArrayList;

public class Purchase {
    private ArrayList<Product> products;
    private ArrayList<Integer> quantitys;
    private ArrayList<Integer> goods_ids;

    private Customer c;
    private int status;

    public Purchase(Customer c, ArrayList<Integer> goods_ids, ArrayList<Product> products,
                    ArrayList<Integer> quantitys, int status) {
        this.c = c;
        this.goods_ids = goods_ids;
        this.products = products;
        this.quantitys = quantitys;
        this.status = status;

    }

    public Customer getC() {
        return c;
    }

    public void setC(Customer c) {
        this.c = c;
    }

    public ArrayList<Integer> getGoods_ids() {
        return goods_ids;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public ArrayList<Integer> getQuantitys() {
        return quantitys;
    }

    public int getStatus() {
        return status;
    }
}