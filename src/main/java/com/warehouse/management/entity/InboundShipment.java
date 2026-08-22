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
@Table(name = "inbound_shipments")
public class InboundShipment {


    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @NotBlank(message = "shipmentId is required")
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @NotBlank(message = "shipmentId is required")
    private String shipmentId;
    @NotBlank(message = "purchaseOrderId is required")
    @NotBlank(message = "purchaseOrderId is required")
    private String purchaseOrderId;
    @NotBlank(message = "supplierId is required")
    @NotBlank(message = "supplierId is required")
    private String supplierId;
    @NotBlank(message = "warehouseId is required")
    @NotBlank(message = "warehouseId is required")
    private String warehouseId;
    private LocalDateTime expectedDate;
    private LocalDateTime actualArrivalDate;
    @Enumerated(EnumType.STRING)
    @Enumerated(EnumType.STRING)
    private InboundShipmentStatus status;

    public enum InboundShipmentStatus {
        SCHEDULED,
        ARRIVED,
        INSPECTING,
        PUT_AWAY,
        REJECTED
    }
}