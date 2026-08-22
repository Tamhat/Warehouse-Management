package com.warehouse.management.repository;

import com.warehouse.management.entity.InventoryRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRecordRepository extends JpaRepository<InventoryRecord, String> {
}
