package com.warehouse.management.controller;

import com.warehouse.management.entity.Zone;
import com.warehouse.management.repository.ZoneRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/zones")
@RequiredArgsConstructor
public class ZoneController {

    private final ZoneRepository zoneRepository;

    @GetMapping
    public ResponseEntity<List<Zone>> getAll() {
        return ResponseEntity.ok(zoneRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Zone> getById(@PathVariable String id) {
        return zoneRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Zone> create(@Valid @RequestBody Zone entity) {
        Zone savedEntity = zoneRepository.save(entity);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEntity);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Zone> update(@PathVariable String id, @Valid @RequestBody Zone entity) {
        if (!zoneRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        Zone updatedEntity = zoneRepository.save(entity);
        return ResponseEntity.ok(updatedEntity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        if (!zoneRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        zoneRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
