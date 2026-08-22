package com.warehouse.management.repository;

import java.util.List;
import java.util.Optional;

public interface StockAdjustmentRepository {
    StockAdjustment save(StockAdjustment entity);
    Optional<StockAdjustment> findById(String id);
    List<StockAdjustment> findAll();
    void deleteById(String id);
    boolean existsById(String id);
    long count();
}
