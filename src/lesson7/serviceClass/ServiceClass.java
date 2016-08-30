package lesson7.serviceClass;

import java.util.Map;

public class ServiceClass {

    private StorageService storageService;

    public void storeUserData(Map<String, Object> data) {
        storageService.store(new Object());
    }

    public void setStorageService(StorageService storageService) {
        this.storageService = storageService;
    }
}
