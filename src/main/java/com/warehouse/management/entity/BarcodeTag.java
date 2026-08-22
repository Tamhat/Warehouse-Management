package com.warehouse.management.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "barcode_tags")
public class BarcodeTag {


    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @NotBlank(message = "tagId is required")
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @NotBlank(message = "tagId is required")
    private String tagId;
    @NotBlank(message = "productId is required")
    @NotBlank(message = "productId is required")
    private String productId;
    @Enumerated(EnumType.STRING)
    @Enumerated(EnumType.STRING)
    private TagType tagType;
    private LocalDateTime assignedDate;
    @NotBlank(message = "currentLocationId is required")
    @NotBlank(message = "currentLocationId is required")
    private String currentLocationId;
    @Enumerated(EnumType.STRING)
    @Enumerated(EnumType.STRING)
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