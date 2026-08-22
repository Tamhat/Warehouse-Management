package com.warehouse.management.repository;

import java.util.List;
import java.util.Optional;

public interface StockTransferRepository {
    StockTransfer save(StockTransfer entity);
    Optional<StockTransfer> findById(String id);
    List<StockTransfer> findAll();
    void deleteById(String id);
    boolean existsById(String id);
    long count();
}
