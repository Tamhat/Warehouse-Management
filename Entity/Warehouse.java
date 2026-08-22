public class Warehouse {

    private String warehouseId;
    private String name;
    private String address;
    private Integer totalCapacity;
    private String operatingHours;
    private WarehouseStatus status;

    public enum WarehouseStatus {
        ACTIVE,
        UNDER_MAINTENANCE,
        CLOSED
    }
}
