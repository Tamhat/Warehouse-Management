import java.util.List;
import java.util.Optional;

public interface BarcodeTagRepository {
    BarcodeTag save(BarcodeTag entity);
    Optional<BarcodeTag> findById(String id);
    List<BarcodeTag> findAll();
    void deleteById(String id);
    boolean existsById(String id);
    long count();
}
