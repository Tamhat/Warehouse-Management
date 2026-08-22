import java.util.List;
import java.util.Optional;

public interface ReturnRMARepository {
    ReturnRMA save(ReturnRMA entity);
    Optional<ReturnRMA> findById(String id);
    List<ReturnRMA> findAll();
    void deleteById(String id);
    boolean existsById(String id);
    long count();
}
