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
@Table(name = "damage_loss_reports")
public class DamageLossReport {


    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @NotBlank(message = "reportId is required")
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @NotBlank(message = "reportId is required")
    private String reportId;
    @NotBlank(message = "inventoryId is required")
    @NotBlank(message = "inventoryId is required")
    private String inventoryId;
    @NotBlank(message = "reportedBy is required")
    @NotBlank(message = "reportedBy is required")
    private String reportedBy;
    private String description;
    @Min(value = 0, message = "quantityAffected cannot be negative")
    private Integer quantityAffected;
    private LocalDateTime reportedDate;
    @Enumerated(EnumType.STRING)
    @Enumerated(EnumType.STRING)
    private DamageReportStatus status;

    public enum DamageReportStatus {
        REPORTED,
        UNDER_INVESTIGATION,
        RESOLVED
    }
}