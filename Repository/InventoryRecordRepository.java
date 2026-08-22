import java.util.List;
import java.util.Optional;

public interface InventoryRecordRepository {
    InventoryRecord save(InventoryRecord entity);
    Optional<InventoryRecord> findById(String id);
    List<InventoryRecord> findAll();
    void deleteById(String id);
    boolean existsById(String id);
    long count();
}
