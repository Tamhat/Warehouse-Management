import java.time.LocalDateTime;

public class Equipment {

    private String equipmentId;
    private String warehouseId;
    private EquipmentType type;
    private LocalDateTime purchaseDate;
    private EquipmentStatus status;

    public enum EquipmentType {
        FORKLIFT,
        CONVEYOR,
        SCANNER
    }

    public enum EquipmentStatus {
        AVAILABLE,
        IN_USE,
        UNDER_MAINTENANCE,
        OUT_OF_SERVICE
    }
}
