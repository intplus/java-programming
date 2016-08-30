//package lesson7.reflection;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.junit.runners.JUnit4;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import static org.junit.Assert.*;
//
//@RunWith(JUnit4.class)
//public class InitClassTest {
//
//    private Demo demo;
//    private List<Object> list;
//
//    @Before
//    public void init() {
//        list = new ArrayList<>();
////        list.add(4);
//        list.add("we");
////        list.add(true);
//
//        demo = new Demo();
//
//    }
//
//    @Test
//    public void TestInitClass() {
//
//        demo.initClass(NewClass.class, list);
//        System.out.println(demo.getStoreCounter());
//        assertTrue(demo.getStoreCounter() == 1);
//
//    }
//    public void setPrivatesTest() {
//        HashMap<String, Object> map = new HashMap<>();
//        map.put("guarantee", 7);
//
////        Assert.assertEquals(7, car.getGuarantee());
//    }
//
//
//}
