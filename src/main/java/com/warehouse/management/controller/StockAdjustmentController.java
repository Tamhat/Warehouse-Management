package com.warehouse.management.controller;

import com.warehouse.management.entity.StockAdjustment;
import com.warehouse.management.repository.StockAdjustmentRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/stock-adjustments")
@RequiredArgsConstructor
public class StockAdjustmentController {

    private final StockAdjustmentRepository stockAdjustmentRepository;

    @GetMapping
    public ResponseEntity<List<StockAdjustment>> getAll() {
        return ResponseEntity.ok(stockAdjustmentRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<StockAdjustment> getById(@PathVariable String id) {
        return stockAdjustmentRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<StockAdjustment> create(@Valid @RequestBody StockAdjustment entity) {
        StockAdjustment savedEntity = stockAdjustmentRepository.save(entity);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEntity);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StockAdjustment> update(@PathVariable String id, @Valid @RequestBody StockAdjustment entity) {
        if (!stockAdjustmentRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        StockAdjustment updatedEntity = stockAdjustmentRepository.save(entity);
        return ResponseEntity.ok(updatedEntity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        if (!stockAdjustmentRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        stockAdjustmentRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
