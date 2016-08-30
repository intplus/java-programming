//package test.junit;
//
//import lesson7.junit.Cat;
//import lesson7.junit.CatNotHungryException;
//import lesson7.junit.Housewife;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.junit.runners.JUnit4;
//import static org.junit.Assert.*;
//
//@RunWith(JUnit4.class)
//public class HousewifeTests {
//
//    private Cat[] cats;
//    private Housewife housewife;
//
//    @Before
//    public void init() {
//        housewife = new Housewife();
//        cats = new Cat[2];
//
//        cats[0] = new Cat();
//        cats[0].setName("Mikki1");
//
//        cats[1] = new Cat();
//        cats[1].setName("Mikki2");
//    }
//
//    @Test
//    public void testFeedCats() {
//        housewife.feed(cats);
//        for (Cat cat:cats) {
//            assertFalse(cat.isHungry());
//        }
//    }
//
//    @Test(expected = CatNotHungryException.class)
//    public void testCatNotHungryException() {
//
//        cats[1].setName("Mikki3");
//        cats[1].setHungry(false);
//
//        housewife.feed(cats);
//        for (Cat cat:cats) {
//            assertFalse(cat.isHungry());
//        }
//    }
//}
