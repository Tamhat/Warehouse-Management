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
@Table(name = "quality_inspections")
public class QualityInspection {


    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @NotBlank(message = "inspectionId is required")
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @NotBlank(message = "inspectionId is required")
    private String inspectionId;
    @Enumerated(EnumType.STRING)
    @Enumerated(EnumType.STRING)
    private TargetType targetType;
    @NotBlank(message = "targetId is required")
    @NotBlank(message = "targetId is required")
    private String targetId;
    private LocalDateTime inspectionDate;
    @NotBlank(message = "result is required")
    @NotBlank(message = "result is required")
    private String result;
    @Enumerated(EnumType.STRING)
    @Enumerated(EnumType.STRING)
    private InspectionStatus status;

    public enum TargetType {
        INBOUND_SHIPMENT,
        OUTBOUND_ORDER
    }

    public enum InspectionStatus {
        SCHEDULED,
        PASSED,
        FAILED
    }
}