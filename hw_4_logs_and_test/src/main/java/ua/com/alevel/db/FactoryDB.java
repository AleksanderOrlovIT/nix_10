package ua.com.alevel.db;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.com.alevel.entity.Factory;
import ua.com.alevel.service.FactoryService;

import java.util.Arrays;
import java.util.UUID;

public class FactoryDB {
    private Factory[] factories;
    private static FactoryDB instance;

    private static final Logger LOGGER = LoggerFactory.getLogger(FactoryService.class);
    private static final Logger LOGGER_INFO = LoggerFactory.getLogger("info");
    private static final Logger LOGGER_WARN = LoggerFactory.getLogger("warn");
    private static final Logger LOGGER_ERROR = LoggerFactory.getLogger("error");

    private FactoryDB() {factories = new Factory[0];}

    public static FactoryDB getInstance() {
        if (instance == null) {
            instance = new FactoryDB();
        }
        return instance;
    }

    public void create(Factory factory) {
        factory.setFactoryId(generateFactoryId());
        factories = Arrays.copyOf(factories, factories.length + 1);
        factories[factories.length - 1] = factory;
    }

    private String generateFactoryId() {
        String id = UUID.randomUUID().toString();
        for (int i = 0; i < factories.length; i++)
            if (id.equals(String.valueOf(factories[i].getFactoryId()))) {
                return generateFactoryId();
            }
        return id;
    }

    public void update(Factory factory) {
        Factory current = findByFactoryId(factory.getFactoryId());
        current.setFactoryName(factory.getFactoryName());
        current.setFactoryType(factory.getFactoryType());
        current.setCapacity(factory.getCapacity());
    }

    public Factory findByFactoryId(String factoryId) {
        for (int i = 0; i < factories.length; i++) {
            if (factoryId.equals(String.valueOf(factories[i].getFactoryId()))) return factories[i];
        }
        System.out.println("No factory exist by id");
        return null;
    }

    public Factory[] findAllFactories() {
        return factories;
    }

    public void delete(String factoryId) {
        Factory userToDelete = findByFactoryId(factoryId);
        int temp = -1;
        for (int i = 0; i < factories.length; i++) {
            if(factories[i].getFactoryId().equals(String.valueOf(userToDelete.getFactoryId()))){
                factories[i] = null;
                temp = i;
            }
        }
        Factory tempArray[] = new Factory[factories.length - 1];
        for (int i = 0; i < temp; i++)
            tempArray[i] = factories[i];
        for (int i = temp; i < tempArray.length; i++)
            tempArray[i] = factories[i+1];
        factories = Arrays.copyOf(tempArray, factories.length - 1);
    }

    public boolean factoryExistByName(String factoryName) {
        for (int i = 0; i < factories.length; i++) {
            if (factoryName.equals(String.valueOf(factories[i].getFactoryName()))) {
                return true;
            }
        }
        return false;
    }

    public String giveTypeByFactoryId(String factoryId){
        Factory type = findByFactoryId(factoryId);
        return type.getFactoryType();
    }

    public int getCapacity(String factoryId){
        Factory capacity = findByFactoryId(factoryId);
        return capacity.getCapacity();
    }

    public int returnCapacity(String factoryId, int newCapacity){
        Factory capacity = findByFactoryId(factoryId);
        capacity.setCapacity(newCapacity);
        return capacity.getCapacity();
    }

    public int changeCapacity(String factoryId, int outlay){
        int newCapacity;
        Factory capacity = findByFactoryId(factoryId);
        newCapacity = Integer.parseInt(String.valueOf(capacity.getCapacity()));
        newCapacity -= outlay;
        capacity.setCapacity(newCapacity);
        return capacity.getCapacity();
    }
}
