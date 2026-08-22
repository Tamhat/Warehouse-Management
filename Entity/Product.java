public class Product {

    private String productId;
    private String sku;
    private String name;
    private String category;
    private String unitOfMeasure;
    private Integer reorderThreshold;
    private ProductStatus status;

    public enum ProductStatus {
        ACTIVE,
        DISCONTINUED
    }
}
