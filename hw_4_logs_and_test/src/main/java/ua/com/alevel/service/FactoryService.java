package ua.com.alevel.service;

import org.slf4j.LoggerFactory;
import ua.com.alevel.dao.FactoryDao;
import ua.com.alevel.entity.Factory;

import org.slf4j.Logger;

public class FactoryService {

    private static final Logger LOGGER_INFO = LoggerFactory.getLogger("info");
    private static final Logger LOGGER_WARN = LoggerFactory.getLogger("warn");

    private static final FactoryDao factoryDao = new FactoryDao();

    public static void create(Factory factory) {
        LOGGER_INFO.info("start create factory");
        if (!factoryDao.existByFactoryName(factory.getFactoryName())) {
            factoryDao.create(factory);
            LOGGER_INFO.info("finish create Factory");
        } else {
            System.out.println("Factory`s name has already existed");
            LOGGER_WARN.warn("Factory`s name has already existed" + factory.getFactoryName());
        }
    }

    public static void update(Factory factory) {
        LOGGER_INFO.info("start update factory");
        factoryDao.update(factory);
    }

    public static void delete(String factoryId) {
        LOGGER_INFO.info("start delete factory");
        factoryDao.delete(factoryId);
    }

    public static Factory findByFactoryId(String factoryId) {
        return factoryDao.findByFactoryId(factoryId);
    }

    public static Factory[] findAllFactories() {
        return factoryDao.findAll();
    }

    public static String giveTypeByFactoryId(String factoryId){
        return factoryDao.giveTypeByFactoryId(factoryId);
    }

    public static int getCapacity(String factoryId){
        return factoryDao.getCapacity(factoryId);
    }

    public static int changeCapacity(String factoryId, int outlay){
        return factoryDao.changeCapacity(factoryId, outlay);
    }

    public static int returnCapacity(String factoryId, int newCapacity){
        return factoryDao.returnCapacity(factoryId, newCapacity);
    }
}
