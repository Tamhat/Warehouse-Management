package com.warehouse.management.entity;

import java.time.LocalDateTime;

public class BarcodeTag {

    private String tagId;
    private String productId;
    private TagType tagType;
    private LocalDateTime assignedDate;
    private String currentLocationId;
    private TagStatus status;

    public enum TagType {
        BARCODE,
        RFID
    }

    public enum TagStatus {
        ACTIVE,
        RETIRED
    }
}
