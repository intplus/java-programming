//package test.junit;
//
//import static org.junit.Assert.*;
//
//import lesson7.container.Service;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.junit.runners.JUnit4;
//
//@RunWith(JUnit4.class)
//public class ServiceTests {
//
//    private Service service;
//
//    @Before
//    public void init() {
//        service = new Service();
//    }
//
//    @Test
//    public void checkServiceGetName() {
//        assertNull(service.getName());
//    }
//
//    @Test
//    public void checkServiceSetName() {
//        String name = "Math";
//        service.setName(name);
//        assertEquals(name, service.getName());
//    }
//}
