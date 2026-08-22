package com.warehouse.management.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "zones")
public class Zone {


    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @NotBlank(message = "zoneId is required")
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @NotBlank(message = "zoneId is required")
    private String zoneId;
    @NotBlank(message = "warehouseId is required")
    @NotBlank(message = "warehouseId is required")
    private String warehouseId;
    @Enumerated(EnumType.STRING)
    @Enumerated(EnumType.STRING)
    private ZoneType zoneType;
    @NotBlank(message = "aisle is required")
    @NotBlank(message = "aisle is required")
    private String aisle;
    @NotBlank(message = "rack is required")
    @NotBlank(message = "rack is required")
    private String rack;
    @NotBlank(message = "bin is required")
    @NotBlank(message = "bin is required")
    private String bin;
    @Min(value = 0, message = "capacity cannot be negative")
    private Integer capacity;
    @Enumerated(EnumType.STRING)
    @Enumerated(EnumType.STRING)
    private ZoneStatus status;

    public enum ZoneType {
        RECEIVING,
        STORAGE,
        PICKING,
        SHIPPING
    }

    public enum ZoneStatus {
        ACTIVE,
        FULL,
        INACTIVE
    }
}