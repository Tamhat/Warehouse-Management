package com.warehouse.management.repository;

import com.warehouse.management.entity.CycleCount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CycleCountRepository extends JpaRepository<CycleCount, String> {
}
