import java.util.List;
import java.util.Optional;

public interface DamageLossReportRepository {
    DamageLossReport save(DamageLossReport entity);
    Optional<DamageLossReport> findById(String id);
    List<DamageLossReport> findAll();
    void deleteById(String id);
    boolean existsById(String id);
    long count();
}
