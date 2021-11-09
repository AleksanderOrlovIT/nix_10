package ua.com.alevel.service;

import ua.com.alevel.dao.FactoryDao;
import ua.com.alevel.entity.Factory;

public class FactoryService {

    private static final FactoryDao factoryDao = new FactoryDao();

    public static void create(Factory factory) {
        if (!factoryDao.existByFactoryName(factory.getFactoryName())) {
            factoryDao.create(factory);
        } else {
            System.out.println("Factory`s name has already existed");
        }
    }

    public static void update(Factory factory) {
        factoryDao.update(factory);
    }

    public static void delete(String factoryId) {
        factoryDao.delete(factoryId);
    }

    public static Factory findByFactoryId(String factoryId) {
        return factoryDao.findByFactoryId(factoryId);
    }

    public static Factory[] findAllFactories() {
        return factoryDao.findAll();
    }
}
