public class Zone {

    private String zoneId;
    private String warehouseId;
    private ZoneType zoneType;
    private String aisle;
    private String rack;
    private String bin;
    private Integer capacity;
    private ZoneStatus status;

    public enum ZoneType {
        RECEIVING,
        STORAGE,
        PICKING,
        SHIPPING
    }

    public enum ZoneStatus {
        ACTIVE,
        FULL,
        INACTIVE
    }
}
