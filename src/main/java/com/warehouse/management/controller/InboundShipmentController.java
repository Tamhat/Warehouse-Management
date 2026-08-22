package com.warehouse.management.controller;

import com.warehouse.management.entity.InboundShipment;
import com.warehouse.management.repository.InboundShipmentRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/inbound-shipments")
@RequiredArgsConstructor
public class InboundShipmentController {

    private final InboundShipmentRepository inboundShipmentRepository;

    @GetMapping
    public ResponseEntity<List<InboundShipment>> getAll() {
        return ResponseEntity.ok(inboundShipmentRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<InboundShipment> getById(@PathVariable String id) {
        return inboundShipmentRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<InboundShipment> create(@Valid @RequestBody InboundShipment entity) {
        InboundShipment savedEntity = inboundShipmentRepository.save(entity);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEntity);
    }

    @PutMapping("/{id}")
    public ResponseEntity<InboundShipment> update(@PathVariable String id, @Valid @RequestBody InboundShipment entity) {
        if (!inboundShipmentRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        InboundShipment updatedEntity = inboundShipmentRepository.save(entity);
        return ResponseEntity.ok(updatedEntity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        if (!inboundShipmentRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        inboundShipmentRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
