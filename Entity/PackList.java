import java.time.LocalDateTime;
import java.util.List;

public class PackList {

    private String packListId;
    private String outboundOrderId;
    private String pickListId;
    private List<String> packedItems;
    private LocalDateTime packedDate;
    private PackListStatus status;

    public enum PackListStatus {
        PENDING,
        IN_PROGRESS,
        COMPLETED
    }
}
