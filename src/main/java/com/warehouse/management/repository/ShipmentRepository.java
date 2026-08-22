package com.warehouse.management.repository;

import java.util.List;
import java.util.Optional;

public interface ShipmentRepository {
    Shipment save(Shipment entity);
    Optional<Shipment> findById(String id);
    List<Shipment> findAll();
    void deleteById(String id);
    boolean existsById(String id);
    long count();
}
