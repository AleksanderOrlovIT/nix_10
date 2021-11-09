package ua.com.alevel.db;

import ua.com.alevel.entity.Factory;

import java.util.Arrays;
import java.util.UUID;

public class FactoryDB {
    private Factory[] factories;
    private static FactoryDB instance;

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
        current.setCapacity(factory.getCapacity());
    }

    public Factory findByFactoryId(String factoryId) {
        for (int i = 0; i < factories.length; i++) {
            if (factoryId.equals(String.valueOf(factories[i].getFactoryId()))) return factories[i];
            else throw new RuntimeException("factory not found");
        }
        return factories[factories.length];
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
        for (int i = 0; i < temp; i++) {
            tempArray[i] = factories[i];
        }
        for (int i = temp; i < tempArray.length; i++) {
            tempArray[i] = factories[i+1];
        }
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
}
