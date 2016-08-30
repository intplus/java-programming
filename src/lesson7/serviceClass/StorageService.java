package lesson7.serviceClass;

import java.util.List;

public interface StorageService {

    public <T> T store(T object);

    public <T> T getById(Long id);

    public <T> List<T> getAll(Class clazz);

}
