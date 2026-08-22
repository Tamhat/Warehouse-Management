package com.warehouse.management.controller;

import com.warehouse.management.entity.BarcodeTag;
import com.warehouse.management.repository.BarcodeTagRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/barcode-tags")
@RequiredArgsConstructor
public class BarcodeTagController {

    private final BarcodeTagRepository barcodeTagRepository;

    @GetMapping
    public ResponseEntity<List<BarcodeTag>> getAll() {
        return ResponseEntity.ok(barcodeTagRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BarcodeTag> getById(@PathVariable String id) {
        return barcodeTagRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<BarcodeTag> create(@Valid @RequestBody BarcodeTag entity) {
        BarcodeTag savedEntity = barcodeTagRepository.save(entity);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEntity);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BarcodeTag> update(@PathVariable String id, @Valid @RequestBody BarcodeTag entity) {
        if (!barcodeTagRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        BarcodeTag updatedEntity = barcodeTagRepository.save(entity);
        return ResponseEntity.ok(updatedEntity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        if (!barcodeTagRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        barcodeTagRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
