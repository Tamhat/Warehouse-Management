package com.warehouse.management.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "inventory_records")
public class InventoryRecord {


    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @NotBlank(message = "inventoryId is required")
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @NotBlank(message = "inventoryId is required")
    private String inventoryId;
    @NotBlank(message = "productId is required")
    @NotBlank(message = "productId is required")
    private String productId;
    @NotBlank(message = "zoneId is required")
    @NotBlank(message = "zoneId is required")
    private String zoneId;
    @Min(value = 0, message = "quantityOnHand cannot be negative")
    private Integer quantityOnHand;
    @Min(value = 0, message = "quantityReserved cannot be negative")
    private Integer quantityReserved;
    private LocalDateTime lastCountedDate;
    @Enumerated(EnumType.STRING)
    @Enumerated(EnumType.STRING)
    private InventoryStatus status;

    public enum InventoryStatus {
        IN_STOCK,
        LOW_STOCK,
        OUT_OF_STOCK
    }
}