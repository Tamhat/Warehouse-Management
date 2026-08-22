import java.util.List;
import java.util.Optional;

public interface CycleCountRepository {
    CycleCount save(CycleCount entity);
    Optional<CycleCount> findById(String id);
    List<CycleCount> findAll();
    void deleteById(String id);
    boolean existsById(String id);
    long count();
}
