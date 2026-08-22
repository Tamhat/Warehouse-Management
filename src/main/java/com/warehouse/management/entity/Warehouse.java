package com.warehouse.management.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "warehouses")
public class Warehouse {


    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @NotBlank(message = "warehouseId is required")
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @NotBlank(message = "warehouseId is required")
    private String warehouseId;
    @NotBlank(message = "name is required")
    @NotBlank(message = "name is required")
    private String name;
    private String address;
    @Min(value = 0, message = "totalCapacity cannot be negative")
    private Integer totalCapacity;
    @NotBlank(message = "operatingHours is required")
    @NotBlank(message = "operatingHours is required")
    private String operatingHours;
    @Enumerated(EnumType.STRING)
    @Enumerated(EnumType.STRING)
    private WarehouseStatus status;

    public enum WarehouseStatus {
        ACTIVE,
        UNDER_MAINTENANCE,
        CLOSED
    }
}