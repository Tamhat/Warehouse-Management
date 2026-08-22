package com.warehouse.management.entity;

import java.time.LocalDateTime;
import java.util.List;

public class PurchaseOrder {

    private String orderId;
    private String supplierId;
    private List<String> items;
    private LocalDateTime orderDate;
    private LocalDateTime expectedDeliveryDate;
    private PurchaseOrderStatus status;

    public enum PurchaseOrderStatus {
        DRAFT,
        APPROVED,
        SENT,
        PARTIALLY_RECEIVED,
        RECEIVED,
        CANCELLED
    }
}
