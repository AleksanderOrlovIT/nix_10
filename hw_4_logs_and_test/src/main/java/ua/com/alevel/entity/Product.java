package ua.com.alevel.entity;

public class Product {
    private String name;
    private String ProductId;
    private int outlay;

    public void setProductName(String name) {
        this.name = name;
    }

    public String getProductName() {
        return name;
    }

    public String getProductId() {
        return ProductId;
    }

    public void setProductId(String productId) {
        ProductId = productId;
    }

    public void setOutlay(int outlay) {
        this.outlay = outlay;
    }

    public int getOutlay() {
        return outlay;
    }

    @Override
    public String toString() {
        return "ProductEntity{" +
                "name='" + name + '\'' +
                ", ProductId='" + ProductId + '\'' +
                ", outlay=" + outlay +
                '}';
    }
}
