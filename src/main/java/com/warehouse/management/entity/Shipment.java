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
@Table(name = "shipments")
public class Shipment {


    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @NotBlank(message = "shipmentId is required")
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @NotBlank(message = "shipmentId is required")
    private String shipmentId;
    @NotBlank(message = "outboundOrderId is required")
    @NotBlank(message = "outboundOrderId is required")
    private String outboundOrderId;
    @NotBlank(message = "carrier is required")
    @NotBlank(message = "carrier is required")
    private String carrier;
    @NotBlank(message = "trackingNumber is required")
    @NotBlank(message = "trackingNumber is required")
    private String trackingNumber;
    private LocalDateTime dispatchDate;
    @Enumerated(EnumType.STRING)
    @Enumerated(EnumType.STRING)
    private ShipmentStatus status;

    public enum ShipmentStatus {
        PENDING,
        DISPATCHED,
        IN_TRANSIT,
        DELIVERED,
        FAILED
    }
}