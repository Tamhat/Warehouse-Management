package com.warehouse.management.repository;

import com.warehouse.management.entity.PackList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PackListRepository extends JpaRepository<PackList, String> {
}
