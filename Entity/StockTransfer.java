import java.time.LocalDateTime;

public class StockTransfer {

    private String transferId;
    private String productId;
    private String fromZoneId;
    private String toZoneId;
    private Integer quantity;
    private LocalDateTime requestedDate;
    private StockTransferStatus status;

    public enum StockTransferStatus {
        REQUESTED,
        APPROVED,
        IN_TRANSIT,
        COMPLETED
    }
}
