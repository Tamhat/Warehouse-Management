package com.warehouse.management.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "equipment_maintenance_records")
public class EquipmentMaintenanceRecord {


    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @NotBlank(message = "recordId is required")
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @NotBlank(message = "recordId is required")
    private String recordId;
    @NotBlank(message = "equipmentId is required")
    @NotBlank(message = "equipmentId is required")
    private String equipmentId;
    private LocalDateTime serviceDate;
    private String description;
    @PositiveOrZero(message = "cost must be positive or zero")
    private BigDecimal cost;
    private LocalDateTime nextServiceDue;
    @Enumerated(EnumType.STRING)
    @Enumerated(EnumType.STRING)
    private MaintenanceStatus status;

    public enum MaintenanceStatus {
        SCHEDULED,
        COMPLETED
    }
}