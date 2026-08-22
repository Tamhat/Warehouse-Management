package com.warehouse.management.entity;

import java.time.LocalDateTime;

public class CycleCount {

    private String countId;
    private String zoneId;
    private LocalDateTime scheduledDate;
    private Integer countedQuantity;
    private Integer systemQuantity;
    private Integer discrepancy;
    private CycleCountStatus status;

    public enum CycleCountStatus {
        SCHEDULED,
        IN_PROGRESS,
        COMPLETED,
        RECONCILED
    }
}
