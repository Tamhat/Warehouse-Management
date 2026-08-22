package com.warehouse.management.repository;

import java.util.List;
import java.util.Optional;

public interface EquipmentMaintenanceRecordRepository {
    EquipmentMaintenanceRecord save(EquipmentMaintenanceRecord entity);
    Optional<EquipmentMaintenanceRecord> findById(String id);
    List<EquipmentMaintenanceRecord> findAll();
    void deleteById(String id);
    boolean existsById(String id);
    long count();
}
