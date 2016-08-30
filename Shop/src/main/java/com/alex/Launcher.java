package com.alex;

import java.util.HashMap;

public class Launcher {
    public static void main(String [] args) throws Exception{
//        try {
//            SplashScreen splash = SplashScreen.getSplashScreen();
//            Thread.sleep(2000);
//            Graphics2D g = splash.createGraphics();
//            g.setColor(Color.BLACK);
//            g.drawString("Loading...", 15, 70);
//            splash.update();
//            Thread.sleep(5000);
//
//            splash.close();
//        } catch (NullPointerException e) {
//            System.err.println("no splash");
//        }

        HashMap order = new HashMap();
        Goods shop= new Goods(order);
        setUpProducts(shop);

        new ShopUI(shop, order);

    }
    private static void setUpProducts(Goods shop) throws Exception{
        Service s = new Service();

        s.addGoods(1, shop);
        s.addGoods(2, shop);
        s.addGoods(3, shop);
    }
}

