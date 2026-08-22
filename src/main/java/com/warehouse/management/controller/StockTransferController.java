package com.warehouse.management.controller;

import com.warehouse.management.entity.StockTransfer;
import com.warehouse.management.repository.StockTransferRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/stock-transfers")
@RequiredArgsConstructor
public class StockTransferController {

    private final StockTransferRepository stockTransferRepository;

    @GetMapping
    public ResponseEntity<List<StockTransfer>> getAll() {
        return ResponseEntity.ok(stockTransferRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<StockTransfer> getById(@PathVariable String id) {
        return stockTransferRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<StockTransfer> create(@Valid @RequestBody StockTransfer entity) {
        StockTransfer savedEntity = stockTransferRepository.save(entity);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEntity);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StockTransfer> update(@PathVariable String id, @Valid @RequestBody StockTransfer entity) {
        if (!stockTransferRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        StockTransfer updatedEntity = stockTransferRepository.save(entity);
        return ResponseEntity.ok(updatedEntity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        if (!stockTransferRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        stockTransferRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
