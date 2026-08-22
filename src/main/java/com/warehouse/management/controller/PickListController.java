package com.warehouse.management.controller;

import com.warehouse.management.entity.PickList;
import com.warehouse.management.repository.PickListRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/pick-lists")
@RequiredArgsConstructor
public class PickListController {

    private final PickListRepository pickListRepository;

    @GetMapping
    public ResponseEntity<List<PickList>> getAll() {
        return ResponseEntity.ok(pickListRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PickList> getById(@PathVariable String id) {
        return pickListRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<PickList> create(@Valid @RequestBody PickList entity) {
        PickList savedEntity = pickListRepository.save(entity);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEntity);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PickList> update(@PathVariable String id, @Valid @RequestBody PickList entity) {
        if (!pickListRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        PickList updatedEntity = pickListRepository.save(entity);
        return ResponseEntity.ok(updatedEntity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        if (!pickListRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        pickListRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
