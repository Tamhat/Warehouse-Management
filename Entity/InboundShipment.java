import java.time.LocalDateTime;

public class InboundShipment {

    private String shipmentId;
    private String purchaseOrderId;
    private String supplierId;
    private String warehouseId;
    private LocalDateTime expectedDate;
    private LocalDateTime actualArrivalDate;
    private InboundShipmentStatus status;

    public enum InboundShipmentStatus {
        SCHEDULED,
        ARRIVED,
        INSPECTING,
        PUT_AWAY,
        REJECTED
    }
}
