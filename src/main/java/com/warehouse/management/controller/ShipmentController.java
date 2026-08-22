package com.warehouse.management.controller;

import com.warehouse.management.entity.Shipment;
import com.warehouse.management.repository.ShipmentRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/shipments")
@RequiredArgsConstructor
public class ShipmentController {

    private final ShipmentRepository shipmentRepository;

    @GetMapping
    public ResponseEntity<List<Shipment>> getAll() {
        return ResponseEntity.ok(shipmentRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Shipment> getById(@PathVariable String id) {
        return shipmentRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Shipment> create(@Valid @RequestBody Shipment entity) {
        Shipment savedEntity = shipmentRepository.save(entity);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEntity);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Shipment> update(@PathVariable String id, @Valid @RequestBody Shipment entity) {
        if (!shipmentRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        Shipment updatedEntity = shipmentRepository.save(entity);
        return ResponseEntity.ok(updatedEntity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        if (!shipmentRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        shipmentRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
