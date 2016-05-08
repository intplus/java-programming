package lesson7.container;

import java.util.ArrayList;

/**
 * Created by alpo123 on 08.05.16.
 */
public class ServiceRepository<T extends Service> {
    private ArrayList <T> service;

    public ServiceRepository() {
        service = new ArrayList<>();
    }

}

