//package test.junit;
//
//import lesson7.junit.Cat;
//import static org.junit.Assert.*;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.junit.runners.JUnit4;
//
//@RunWith(JUnit4.class)
//public class CatTests {
//
//    private Cat cat;
//
//    @Before
//    public void init() {
//        cat = new Cat();
//    }
//
//    @Test
//    public void checkCatNameDefaultValue() {
//        assertNull("Default name of cat should be null", cat.getName());
//    }
//
//    @Test
//    public void checkCatWeightDefaultValue() {
//        assertTrue("Default weight of cat should be 0.0", cat.getWeight() == 0.0);
//    }
//
//    @Test
//    public void checkCatIsHungryDefaultValue() {
//        assertTrue("Cat should be hungry by default", cat.isHungry());
//    }
//
//    @Test
//    public void checkCatSetName() {
//        String name = "Mikky";
//        cat.setName(name);
//        assertEquals(name, cat.getName());
//    }
//}
