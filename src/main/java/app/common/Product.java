package app.common;

public class Product {
    private final int productId;
    private final String nameOfProduct;
    private final String producer;

    public Product(int productId, String nameOfProduct, String producer) {
        this.productId = productId;
        this.nameOfProduct = nameOfProduct;
        this.producer = producer;
    }

    public String getProducer() {
        return producer;
    }

    public int getProductId() {
        return productId;
    }

    public String getNameOfProduct() {
        return nameOfProduct;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", nameOfProduct='" + nameOfProduct + '\'' +
                ", producer='" + producer + '\'' +
                '}';
    }
}
