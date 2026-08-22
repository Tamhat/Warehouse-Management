package com.warehouse.management.controller;

import com.warehouse.management.entity.Equipment;
import com.warehouse.management.repository.EquipmentRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/equipments")
@RequiredArgsConstructor
public class EquipmentController {

    private final EquipmentRepository equipmentRepository;

    @GetMapping
    public ResponseEntity<List<Equipment>> getAll() {
        return ResponseEntity.ok(equipmentRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Equipment> getById(@PathVariable String id) {
        return equipmentRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Equipment> create(@Valid @RequestBody Equipment entity) {
        Equipment savedEntity = equipmentRepository.save(entity);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEntity);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Equipment> update(@PathVariable String id, @Valid @RequestBody Equipment entity) {
        if (!equipmentRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        Equipment updatedEntity = equipmentRepository.save(entity);
        return ResponseEntity.ok(updatedEntity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        if (!equipmentRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        equipmentRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
