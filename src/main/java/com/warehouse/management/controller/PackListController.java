package com.warehouse.management.controller;

import com.warehouse.management.entity.PackList;
import com.warehouse.management.repository.PackListRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/pack-lists")
@RequiredArgsConstructor
public class PackListController {

    private final PackListRepository packListRepository;

    @GetMapping
    public ResponseEntity<List<PackList>> getAll() {
        return ResponseEntity.ok(packListRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PackList> getById(@PathVariable String id) {
        return packListRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<PackList> create(@Valid @RequestBody PackList entity) {
        PackList savedEntity = packListRepository.save(entity);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEntity);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PackList> update(@PathVariable String id, @Valid @RequestBody PackList entity) {
        if (!packListRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        PackList updatedEntity = packListRepository.save(entity);
        return ResponseEntity.ok(updatedEntity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        if (!packListRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        packListRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
