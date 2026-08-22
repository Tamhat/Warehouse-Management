import java.util.List;
import java.util.Optional;

public interface PackListRepository {
    PackList save(PackList entity);
    Optional<PackList> findById(String id);
    List<PackList> findAll();
    void deleteById(String id);
    boolean existsById(String id);
    long count();
}
