package lesson7.serviceClass;

import lesson7.serviceClass.StorageService;

import java.util.List;

public class DbStorageService implements StorageService {

    @Override
    public <T> T store(T object) {
        return null;
    }

    @Override
    public <T> T getById(Long id) {
        return null;
    }

    @Override
    public <T> List<T> getAll(Class clazz) {
        return null;
    }
}
