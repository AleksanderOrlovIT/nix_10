package ua.com.alevel.entity;

public class Product {
    private String productName;
    private String ProductId;
    private String productType;
    private int outlay;

    public void setProductName(String name) {
        this.productName = name;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductId() {
        return ProductId;
    }

    public void setProductId(String productId) {ProductId = productId;}

    public void setOutlay(int outlay) {
        this.outlay = outlay;
    }

    public int getOutlay() {
        return outlay;
    }

    public String getProductType() {return productType;}

    public void setProductType(String productType) {this.productType = productType;}

    @Override
    public String toString() {
        return "Product{" +
                "productName='" + productName + '\'' +
                ", ProductId='" + ProductId + '\'' +
                ", productType='" + productType + '\'' +
                ", outlay=" + outlay +
                '}';
    }
}
