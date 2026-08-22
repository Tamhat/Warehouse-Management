package com.warehouse.management.repository;

import com.warehouse.management.entity.InboundShipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InboundShipmentRepository extends JpaRepository<InboundShipment, String> {
}
