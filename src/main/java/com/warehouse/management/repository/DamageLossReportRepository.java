package com.warehouse.management.repository;

import com.warehouse.management.entity.DamageLossReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DamageLossReportRepository extends JpaRepository<DamageLossReport, String> {
}
