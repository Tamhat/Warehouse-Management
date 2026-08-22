package com.warehouse.management.repository;

import com.warehouse.management.entity.EquipmentMaintenanceRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipmentMaintenanceRecordRepository extends JpaRepository<EquipmentMaintenanceRecord, String> {
}
