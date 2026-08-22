package com.warehouse.management.repository;

import java.util.List;
import java.util.Optional;

public interface PurchaseOrderRepository {
    PurchaseOrder save(PurchaseOrder entity);
    Optional<PurchaseOrder> findById(String id);
    List<PurchaseOrder> findAll();
    void deleteById(String id);
    boolean existsById(String id);
    long count();
}
