package com.warehouse.management.entity;

import java.time.LocalDateTime;

public class QualityInspection {

    private String inspectionId;
    private TargetType targetType;
    private String targetId;
    private LocalDateTime inspectionDate;
    private String result;
    private InspectionStatus status;

    public enum TargetType {
        INBOUND_SHIPMENT,
        OUTBOUND_ORDER
    }

    public enum InspectionStatus {
        SCHEDULED,
        PASSED,
        FAILED
    }
}
