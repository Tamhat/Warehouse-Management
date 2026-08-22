package com.warehouse.management.repository;

import java.util.List;
import java.util.Optional;

public interface WarehouseRepository {
    Warehouse save(Warehouse entity);
    Optional<Warehouse> findById(String id);
    List<Warehouse> findAll();
    void deleteById(String id);
    boolean existsById(String id);
    long count();
}
