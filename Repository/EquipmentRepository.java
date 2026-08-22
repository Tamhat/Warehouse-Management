import java.util.List;
import java.util.Optional;

public interface EquipmentRepository {
    Equipment save(Equipment entity);
    Optional<Equipment> findById(String id);
    List<Equipment> findAll();
    void deleteById(String id);
    boolean existsById(String id);
    long count();
}
