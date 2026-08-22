package com.warehouse.management.controller;

import com.warehouse.management.entity.DamageLossReport;
import com.warehouse.management.repository.DamageLossReportRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/damage-loss-reports")
@RequiredArgsConstructor
public class DamageLossReportController {

    private final DamageLossReportRepository damageLossReportRepository;

    @GetMapping
    public ResponseEntity<List<DamageLossReport>> getAll() {
        return ResponseEntity.ok(damageLossReportRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DamageLossReport> getById(@PathVariable String id) {
        return damageLossReportRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<DamageLossReport> create(@Valid @RequestBody DamageLossReport entity) {
        DamageLossReport savedEntity = damageLossReportRepository.save(entity);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEntity);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DamageLossReport> update(@PathVariable String id, @Valid @RequestBody DamageLossReport entity) {
        if (!damageLossReportRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        DamageLossReport updatedEntity = damageLossReportRepository.save(entity);
        return ResponseEntity.ok(updatedEntity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        if (!damageLossReportRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        damageLossReportRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
