package com.warehouse.management.controller;

import com.warehouse.management.entity.ReturnRMA;
import com.warehouse.management.repository.ReturnRMARepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/return-rmas")
@RequiredArgsConstructor
public class ReturnRMAController {

    private final ReturnRMARepository returnRMARepository;

    @GetMapping
    public ResponseEntity<List<ReturnRMA>> getAll() {
        return ResponseEntity.ok(returnRMARepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReturnRMA> getById(@PathVariable String id) {
        return returnRMARepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ReturnRMA> create(@Valid @RequestBody ReturnRMA entity) {
        ReturnRMA savedEntity = returnRMARepository.save(entity);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEntity);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReturnRMA> update(@PathVariable String id, @Valid @RequestBody ReturnRMA entity) {
        if (!returnRMARepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        ReturnRMA updatedEntity = returnRMARepository.save(entity);
        return ResponseEntity.ok(updatedEntity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        if (!returnRMARepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        returnRMARepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
