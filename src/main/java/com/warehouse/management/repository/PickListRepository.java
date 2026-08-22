package com.warehouse.management.repository;

import com.warehouse.management.entity.PickList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PickListRepository extends JpaRepository<PickList, String> {
}
