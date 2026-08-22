package com.warehouse.management.repository;

import java.util.List;
import java.util.Optional;

public interface InboundShipmentRepository {
    InboundShipment save(InboundShipment entity);
    Optional<InboundShipment> findById(String id);
    List<InboundShipment> findAll();
    void deleteById(String id);
    boolean existsById(String id);
    long count();
}
