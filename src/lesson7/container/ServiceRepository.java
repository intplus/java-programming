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

    public void addService(T serv) {
        service.add(serv);
    }

    public void deleteService(T serv) {
        service.remove(serv);
    }

    public T giveService(T serv) {
        int i = 0;
        for (; i < service.size(); ++i) {
            if (serv.equals(service.get(i))) {
                return service.get(i);
            }
        }
        return null;
    }

}

