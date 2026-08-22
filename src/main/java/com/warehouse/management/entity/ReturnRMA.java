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
@Table(name = "return_rmas")
public class ReturnRMA {


    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @NotBlank(message = "rmaId is required")
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @NotBlank(message = "rmaId is required")
    private String rmaId;
    @Enumerated(EnumType.STRING)
    @Enumerated(EnumType.STRING)
    private ReferenceType referenceType;
    @NotBlank(message = "referenceId is required")
    @NotBlank(message = "referenceId is required")
    private String referenceId;
    @NotBlank(message = "reason is required")
    @NotBlank(message = "reason is required")
    private String reason;
    private LocalDateTime requestDate;
    @Enumerated(EnumType.STRING)
    @Enumerated(EnumType.STRING)
    private RmaStatus status;

    public enum ReferenceType {
        INBOUND_SHIPMENT,
        OUTBOUND_ORDER
    }

    public enum RmaStatus {
        REQUESTED,
        APPROVED,
        REJECTED,
        PROCESSED
    }
}