package com.warehouse.management.entity;

import java.time.LocalDateTime;

public class DamageLossReport {

    private String reportId;
    private String inventoryId;
    private String reportedBy;
    private String description;
    private Integer quantityAffected;
    private LocalDateTime reportedDate;
    private DamageReportStatus status;

    public enum DamageReportStatus {
        REPORTED,
        UNDER_INVESTIGATION,
        RESOLVED
    }
}
