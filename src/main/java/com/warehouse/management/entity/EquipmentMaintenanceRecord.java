package com.warehouse.management.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class EquipmentMaintenanceRecord {

    private String recordId;
    private String equipmentId;
    private LocalDateTime serviceDate;
    private String description;
    private BigDecimal cost;
    private LocalDateTime nextServiceDue;
    private MaintenanceStatus status;

    public enum MaintenanceStatus {
        SCHEDULED,
        COMPLETED
    }
}
