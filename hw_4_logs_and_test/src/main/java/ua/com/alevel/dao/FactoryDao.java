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

    public String giveTypeByFactoryId(String factoryId){
        return FactoryDB.getInstance().giveTypeByFactoryId(factoryId);
    }

    public int getCapacity(String factoryId){
        return FactoryDB.getInstance().getCapacity(factoryId);
    }

    public int changeCapacity(String factoryId, int outlay){
        return FactoryDB.getInstance().changeCapacity(factoryId, outlay);
    }

    public int returnCapacity(String factoryId, int newCapacity){
        return FactoryDB.getInstance().returnCapacity(factoryId, newCapacity);
    }
}
