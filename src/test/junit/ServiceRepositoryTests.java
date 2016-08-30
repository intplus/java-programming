//package test.junit;
//
//import lesson7.container.Service;
//import lesson7.container.ServiceRepository;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.junit.runners.JUnit4;
//import static org.junit.Assert.*;
//
//@RunWith(JUnit4.class)
//public class ServiceRepositoryTests {
//
//    private Service service1, service2, service3;
//    private ServiceRepository sr;
//
//
//    @Before
//    public void init() {
//        sr = new ServiceRepository();
//        service1 = new Service();
//        service2 = new Service();
//        service3 = new Service();
//
//        sr.addService(service1);
//        sr.addService(service2);
//    }
//
//    @Test
//    public void testGiveService() {
//        assertNotNull(sr.giveService(service1));
//        assertEquals(service1, sr.giveService(service1));
//
//    }
//
//    @Test
//    public void testAddService() {
//        sr.addService(service3);
//        assertNotNull(sr.giveService(service3));
//    }
//
//    @Test
//    public void testDeleteService() {
//
//        sr.deleteService(service3);
//        assertEquals(null, sr.giveService(service3));
//    }
//
//
//
//}
