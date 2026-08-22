package com.warehouse.management.controller;

import com.warehouse.management.entity.EquipmentMaintenanceRecord;
import com.warehouse.management.repository.EquipmentMaintenanceRecordRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/equipment-maintenance-records")
@RequiredArgsConstructor
public class EquipmentMaintenanceRecordController {

    private final EquipmentMaintenanceRecordRepository equipmentMaintenanceRecordRepository;

    @GetMapping
    public ResponseEntity<List<EquipmentMaintenanceRecord>> getAll() {
        return ResponseEntity.ok(equipmentMaintenanceRecordRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EquipmentMaintenanceRecord> getById(@PathVariable String id) {
        return equipmentMaintenanceRecordRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<EquipmentMaintenanceRecord> create(@Valid @RequestBody EquipmentMaintenanceRecord entity) {
        EquipmentMaintenanceRecord savedEntity = equipmentMaintenanceRecordRepository.save(entity);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEntity);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EquipmentMaintenanceRecord> update(@PathVariable String id, @Valid @RequestBody EquipmentMaintenanceRecord entity) {
        if (!equipmentMaintenanceRecordRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        EquipmentMaintenanceRecord updatedEntity = equipmentMaintenanceRecordRepository.save(entity);
        return ResponseEntity.ok(updatedEntity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        if (!equipmentMaintenanceRecordRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        equipmentMaintenanceRecordRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
