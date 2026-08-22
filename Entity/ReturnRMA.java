import java.time.LocalDateTime;

public class ReturnRMA {

    private String rmaId;
    private ReferenceType referenceType;
    private String referenceId;
    private String reason;
    private LocalDateTime requestDate;
    private RmaStatus status;

    public enum ReferenceType {
        INBOUND_SHIPMENT,
        OUTBOUND_ORDER
    }

    public enum RmaStatus {
        REQUESTED,
        APPROVED,
        REJECTED,
        PROCESSED
    }
}
