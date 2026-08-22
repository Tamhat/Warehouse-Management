import java.time.LocalDateTime;
import java.util.List;

public class OutboundOrder {

    private String orderId;
    private String customerId;
    private List<String> items;
    private LocalDateTime orderDate;
    private LocalDateTime requestedShipDate;
    private OutboundOrderStatus status;

    public enum OutboundOrderStatus {
        PLACED,
        CONFIRMED,
        PICKING,
        PACKED,
        SHIPPED,
        DELIVERED,
        CANCELLED
    }
}
