package ua.com.alevel.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import ua.com.alevel.entity.Factory;

public class FactoryServiceTest {
    private FactoryService factoryService = new FactoryService();
    private static final String RANDOM_NAME= "RandomFactory";
    private static final String RANDOM_TYPE= "RandomType";

    @Test
    @Order(1)
    public void createFactory(){
        int randomNumber = (int)Math.random() * 15;
        Factory[] factories = new Factory[randomNumber];
        for(int i=0; i<randomNumber; i++) {
            Factory factory = new Factory();
            factory.setFactoryName(RANDOM_NAME + i);
            factory.setFactoryType(RANDOM_TYPE + i);
            factory.setCapacity(i);
            factories[i] = factory;
        }
        Assertions.assertEquals(factories.length, randomNumber);
    }

    @Test
    @Order(2)
    public void updateFactory(){
        Factory factory = new Factory();
        factory.setFactoryName("qwe");
        factory.setFactoryType("asd");
        factory.setCapacity(1);
        factoryService.create(factory);
        factoryService.update(factory);
        factory.setFactoryId(factory.getFactoryId());
        factory.setFactoryName("name");
        factory.setFactoryType("type");
        factory.setCapacity(2);
        Assertions.assertEquals(factory.getFactoryName(), "name");
        Assertions.assertEquals(factory.getFactoryType(), "type");
        Assertions.assertEquals(factory.getCapacity(), 2);
    }

    @Test
    @Order(3)
    public void deleteFactory(){
        Factory factory = generateRandomFactory();
        factoryService.create(factory);
        String factoryId = factory.getFactoryId();
        factoryService.delete(factoryId);
        Factory[] factories = factoryService.findAllFactories();
        Assertions.assertEquals(factories.length, 0 );
    }

    @Test
    @Order(4)
    public void findFactoryType(){
        Factory factory = generateRandomFactory();
        factoryService.create(factory);
        String factoryId = factory.getFactoryId();
        factoryService.giveTypeByFactoryId(factoryId);
        Assertions.assertEquals(factory.getFactoryType(), RANDOM_TYPE );
    }

    @Test
    @Order(5)
    public void getCapacity(){
        Factory factory = new Factory();
        factory.setFactoryName("google");
        factory.setFactoryType("fish");
        factory.setCapacity(1);
        factoryService.create(factory);
        String factoryId = factory.getFactoryId();
        int capacity = FactoryService.getCapacity(factoryId);
        Assertions.assertEquals(capacity, factory.getCapacity());
    }


    private static Factory generateRandomFactory() {
        Factory factory = new Factory();
        factory.setFactoryName(RANDOM_NAME);
        factory.setFactoryType(RANDOM_TYPE);
        factory.setCapacity(1);
        return factory;
    }
}
