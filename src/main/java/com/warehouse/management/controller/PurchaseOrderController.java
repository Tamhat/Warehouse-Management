package com.warehouse.management.controller;

import com.warehouse.management.entity.PurchaseOrder;
import com.warehouse.management.repository.PurchaseOrderRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/purchase-orders")
@RequiredArgsConstructor
public class PurchaseOrderController {

    private final PurchaseOrderRepository purchaseOrderRepository;

    @GetMapping
    public ResponseEntity<List<PurchaseOrder>> getAll() {
        return ResponseEntity.ok(purchaseOrderRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PurchaseOrder> getById(@PathVariable String id) {
        return purchaseOrderRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<PurchaseOrder> create(@Valid @RequestBody PurchaseOrder entity) {
        PurchaseOrder savedEntity = purchaseOrderRepository.save(entity);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEntity);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PurchaseOrder> update(@PathVariable String id, @Valid @RequestBody PurchaseOrder entity) {
        if (!purchaseOrderRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        PurchaseOrder updatedEntity = purchaseOrderRepository.save(entity);
        return ResponseEntity.ok(updatedEntity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        if (!purchaseOrderRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        purchaseOrderRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
