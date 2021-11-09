package ua.com.alevel.dao;

import ua.com.alevel.db.FactoryDB;
import ua.com.alevel.entity.Factory;

public class FactoryDao {
    public void create(Factory factory) {
        FactoryDB.getInstance().create(factory);
    }

    public void update(Factory factory) {
        FactoryDB.getInstance().update(factory);
    }

    public void delete(String factoryId) {FactoryDB.getInstance().delete(factoryId);}

    public Factory findByFactoryId(String factoryId) { return FactoryDB.getInstance().findByFactoryId(factoryId); }

    public Factory[] findAll() { return FactoryDB.getInstance().findAllFactories(); }

    public boolean existByFactoryName(String factoryName) {
        return FactoryDB.getInstance().factoryExistByName(factoryName);
    }
}
