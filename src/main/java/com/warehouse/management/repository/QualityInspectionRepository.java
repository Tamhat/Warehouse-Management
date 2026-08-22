package com.warehouse.management.repository;

import java.util.List;
import java.util.Optional;

public interface QualityInspectionRepository {
    QualityInspection save(QualityInspection entity);
    Optional<QualityInspection> findById(String id);
    List<QualityInspection> findAll();
    void deleteById(String id);
    boolean existsById(String id);
    long count();
}
