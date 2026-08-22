import java.util.List;
import java.util.Optional;

public interface PickListRepository {
    PickList save(PickList entity);
    Optional<PickList> findById(String id);
    List<PickList> findAll();
    void deleteById(String id);
    boolean existsById(String id);
    long count();
}
