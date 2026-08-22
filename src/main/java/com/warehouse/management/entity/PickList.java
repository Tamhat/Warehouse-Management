package com.warehouse.management.entity;

import java.time.LocalDateTime;
import java.util.List;

public class PickList {

    private String pickListId;
    private String outboundOrderId;
    private List<String> items;
    private String assignedPickerId;
    private LocalDateTime createdDate;
    private PickListStatus status;

    public enum PickListStatus {
        PENDING,
        IN_PROGRESS,
        COMPLETED,
        EXCEPTION
    }
}
