package com.warehouse.management.repository;

import java.util.List;
import java.util.Optional;

public interface OutboundOrderRepository {
    OutboundOrder save(OutboundOrder entity);
    Optional<OutboundOrder> findById(String id);
    List<OutboundOrder> findAll();
    void deleteById(String id);
    boolean existsById(String id);
    long count();
}
