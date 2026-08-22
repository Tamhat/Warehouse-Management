package com.warehouse.management.entity;

import java.time.LocalDateTime;

public class InventoryRecord {

    private String inventoryId;
    private String productId;
    private String zoneId;
    private Integer quantityOnHand;
    private Integer quantityReserved;
    private LocalDateTime lastCountedDate;
    private InventoryStatus status;

    public enum InventoryStatus {
        IN_STOCK,
        LOW_STOCK,
        OUT_OF_STOCK
    }
}
