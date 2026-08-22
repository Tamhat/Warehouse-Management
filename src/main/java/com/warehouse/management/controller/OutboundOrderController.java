package com.warehouse.management.controller;

import com.warehouse.management.entity.OutboundOrder;
import com.warehouse.management.repository.OutboundOrderRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/outbound-orders")
@RequiredArgsConstructor
public class OutboundOrderController {

    private final OutboundOrderRepository outboundOrderRepository;

    @GetMapping
    public ResponseEntity<List<OutboundOrder>> getAll() {
        return ResponseEntity.ok(outboundOrderRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<OutboundOrder> getById(@PathVariable String id) {
        return outboundOrderRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<OutboundOrder> create(@Valid @RequestBody OutboundOrder entity) {
        OutboundOrder savedEntity = outboundOrderRepository.save(entity);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEntity);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OutboundOrder> update(@PathVariable String id, @Valid @RequestBody OutboundOrder entity) {
        if (!outboundOrderRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        OutboundOrder updatedEntity = outboundOrderRepository.save(entity);
        return ResponseEntity.ok(updatedEntity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        if (!outboundOrderRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        outboundOrderRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
