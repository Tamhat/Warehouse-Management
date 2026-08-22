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
@Table(name = "equipments")
public class Equipment {


    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @NotBlank(message = "equipmentId is required")
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @NotBlank(message = "equipmentId is required")
    private String equipmentId;
    @NotBlank(message = "warehouseId is required")
    @NotBlank(message = "warehouseId is required")
    private String warehouseId;
    @Enumerated(EnumType.STRING)
    @Enumerated(EnumType.STRING)
    private EquipmentType type;
    private LocalDateTime purchaseDate;
    @Enumerated(EnumType.STRING)
    @Enumerated(EnumType.STRING)
    private EquipmentStatus status;

    public enum EquipmentType {
        FORKLIFT,
        CONVEYOR,
        SCANNER
    }

    public enum EquipmentStatus {
        AVAILABLE,
        IN_USE,
        UNDER_MAINTENANCE,
        OUT_OF_SERVICE
    }
}