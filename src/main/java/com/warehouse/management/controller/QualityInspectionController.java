package com.warehouse.management.controller;

import com.warehouse.management.entity.QualityInspection;
import com.warehouse.management.repository.QualityInspectionRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/quality-inspections")
@RequiredArgsConstructor
public class QualityInspectionController {

    private final QualityInspectionRepository qualityInspectionRepository;

    @GetMapping
    public ResponseEntity<List<QualityInspection>> getAll() {
        return ResponseEntity.ok(qualityInspectionRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<QualityInspection> getById(@PathVariable String id) {
        return qualityInspectionRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<QualityInspection> create(@Valid @RequestBody QualityInspection entity) {
        QualityInspection savedEntity = qualityInspectionRepository.save(entity);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEntity);
    }

    @PutMapping("/{id}")
    public ResponseEntity<QualityInspection> update(@PathVariable String id, @Valid @RequestBody QualityInspection entity) {
        if (!qualityInspectionRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        QualityInspection updatedEntity = qualityInspectionRepository.save(entity);
        return ResponseEntity.ok(updatedEntity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        if (!qualityInspectionRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        qualityInspectionRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
