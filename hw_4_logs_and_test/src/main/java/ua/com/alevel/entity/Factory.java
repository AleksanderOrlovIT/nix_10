package ua.com.alevel.entity;

public class Factory {
    private String factoryName;
    private String factoryId;
    private String factoryType;
    private int capacity;

    public String getFactoryName() {
        return factoryName;
    }

    public void setFactoryName(String factoryName) {
        this.factoryName = factoryName;
    }

    public void setFactoryId(String factoryId) {
        this.factoryId = factoryId;
    }

    public String getFactoryId() {
        return factoryId;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getFactoryType() {return factoryType;}

    public void setFactoryType(String factoryType) {this.factoryType = factoryType;}

    @Override
    public String toString() {
        return "Factory{" +
                "factoryName='" + factoryName + '\'' +
                ", factoryId='" + factoryId + '\'' +
                ", typeProducts='" + factoryType + '\'' +
                ", capacity=" + capacity +
                '}';
    }
}
