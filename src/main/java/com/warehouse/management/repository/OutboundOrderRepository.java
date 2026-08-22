package com.warehouse.management.repository;

import com.warehouse.management.entity.OutboundOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OutboundOrderRepository extends JpaRepository<OutboundOrder, String> {
}
