package com.warehouse.management.repository;

import java.util.List;
import java.util.Optional;

public interface ZoneRepository {
    Zone save(Zone entity);
    Optional<Zone> findById(String id);
    List<Zone> findAll();
    void deleteById(String id);
    boolean existsById(String id);
    long count();
}
