package com.warehouse.management.entity;

import java.time.LocalDateTime;

public class Shipment {

    private String shipmentId;
    private String outboundOrderId;
    private String carrier;
    private String trackingNumber;
    private LocalDateTime dispatchDate;
    private ShipmentStatus status;

    public enum ShipmentStatus {
        PENDING,
        DISPATCHED,
        IN_TRANSIT,
        DELIVERED,
        FAILED
    }
}
