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
@Table(name = "cycle_counts")
public class CycleCount {


    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @NotBlank(message = "countId is required")
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @NotBlank(message = "countId is required")
    private String countId;
    @NotBlank(message = "zoneId is required")
    @NotBlank(message = "zoneId is required")
    private String zoneId;
    private LocalDateTime scheduledDate;
    @Min(value = 0, message = "countedQuantity cannot be negative")
    private Integer countedQuantity;
    @Min(value = 0, message = "systemQuantity cannot be negative")
    private Integer systemQuantity;
    private Integer discrepancy;
    @Enumerated(EnumType.STRING)
    @Enumerated(EnumType.STRING)
    private CycleCountStatus status;

    public enum CycleCountStatus {
        SCHEDULED,
        IN_PROGRESS,
        COMPLETED,
        RECONCILED
    }
}