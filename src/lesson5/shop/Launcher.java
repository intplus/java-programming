package lesson5.shop;

public class Launcher {
    public static void main(String [] args) {
//        Goods goods;
//        Customer customer;
        Goods shop = new Goods();
        setUpProducts(shop);

        ShopUI ui = new ShopUI(shop);

//        Service.Initialisation();
//        Service.printStock();
//        Service.Sale(1,0,15);
//        Service.last7days();

    }
    private static void setUpProducts(Goods shop) {
        Product p = new Product();
        p.setName("ds-2cd2012f-i");
        p.setPrice(65.5);
        shop.addProduct(p);

        p = new Product();
        p.setName("ds-2cd2032f-i");
        p.setPrice(90.0);
        shop.addProduct(p);

        p = new Product();
        p.setName("ds-2cd2132f-i");
        p.setPrice(120.0);
        shop.addProduct(p);

        p = new Product();
        p.setName("ds-2cd2232f-i");
        p.setPrice(150.0);
        shop.addProduct(p);
    }
}

