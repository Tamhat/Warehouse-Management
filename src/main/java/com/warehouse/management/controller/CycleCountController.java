package com.warehouse.management.controller;

import com.warehouse.management.entity.CycleCount;
import com.warehouse.management.repository.CycleCountRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cycle-counts")
@RequiredArgsConstructor
public class CycleCountController {

    private final CycleCountRepository cycleCountRepository;

    @GetMapping
    public ResponseEntity<List<CycleCount>> getAll() {
        return ResponseEntity.ok(cycleCountRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CycleCount> getById(@PathVariable String id) {
        return cycleCountRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<CycleCount> create(@Valid @RequestBody CycleCount entity) {
        CycleCount savedEntity = cycleCountRepository.save(entity);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEntity);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CycleCount> update(@PathVariable String id, @Valid @RequestBody CycleCount entity) {
        if (!cycleCountRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        CycleCount updatedEntity = cycleCountRepository.save(entity);
        return ResponseEntity.ok(updatedEntity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        if (!cycleCountRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        cycleCountRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
