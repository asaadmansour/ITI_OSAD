package model.productModel;

public class ProductImp implements Product {
    private int id;
    private String productName;
    private String categoryName;
    private double price;

    public ProductImp(int id, String productName, String categoryName, double price) {
        this.id = id;
        this.productName = productName;
        this.categoryName = categoryName;
        this.price = price;
    }
    @Override
    public int getId() {
        return id;
    }
    @Override
    public String getProductName() {
        return productName;
    }
}
