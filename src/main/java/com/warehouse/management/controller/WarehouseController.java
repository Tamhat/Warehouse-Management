package com.warehouse.management.controller;

import com.warehouse.management.entity.Warehouse;
import com.warehouse.management.repository.WarehouseRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/warehouses")
@RequiredArgsConstructor
public class WarehouseController {

    private final WarehouseRepository warehouseRepository;

    @GetMapping
    public ResponseEntity<List<Warehouse>> getAll() {
        return ResponseEntity.ok(warehouseRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Warehouse> getById(@PathVariable String id) {
        return warehouseRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Warehouse> create(@Valid @RequestBody Warehouse entity) {
        Warehouse savedEntity = warehouseRepository.save(entity);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEntity);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Warehouse> update(@PathVariable String id, @Valid @RequestBody Warehouse entity) {
        if (!warehouseRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        Warehouse updatedEntity = warehouseRepository.save(entity);
        return ResponseEntity.ok(updatedEntity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        if (!warehouseRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        warehouseRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
