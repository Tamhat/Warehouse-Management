package com.warehouse.management.entity;

import java.time.LocalDateTime;

public class StockAdjustment {

    private String adjustmentId;
    private String inventoryId;
    private AdjustmentReason reason;
    private Integer quantityChange;
    private LocalDateTime adjustmentDate;
    private StockAdjustmentStatus status;

    public enum AdjustmentReason {
        DAMAGE,
        LOSS,
        COUNT_ERROR,
        THEFT
    }

    public enum StockAdjustmentStatus {
        PENDING,
        APPROVED,
        REJECTED,
        APPLIED
    }
}
