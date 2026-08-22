package com.warehouse.management.controller;

import com.warehouse.management.entity.InventoryRecord;
import com.warehouse.management.repository.InventoryRecordRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/inventory-records")
@RequiredArgsConstructor
public class InventoryRecordController {

    private final InventoryRecordRepository inventoryRecordRepository;

    @GetMapping
    public ResponseEntity<List<InventoryRecord>> getAll() {
        return ResponseEntity.ok(inventoryRecordRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<InventoryRecord> getById(@PathVariable String id) {
        return inventoryRecordRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<InventoryRecord> create(@Valid @RequestBody InventoryRecord entity) {
        InventoryRecord savedEntity = inventoryRecordRepository.save(entity);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEntity);
    }

    @PutMapping("/{id}")
    public ResponseEntity<InventoryRecord> update(@PathVariable String id, @Valid @RequestBody InventoryRecord entity) {
        if (!inventoryRecordRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        InventoryRecord updatedEntity = inventoryRecordRepository.save(entity);
        return ResponseEntity.ok(updatedEntity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        if (!inventoryRecordRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        inventoryRecordRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
