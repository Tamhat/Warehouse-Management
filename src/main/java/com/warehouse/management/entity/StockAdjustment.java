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
@Table(name = "stock_adjustments")
public class StockAdjustment {


    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @NotBlank(message = "adjustmentId is required")
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @NotBlank(message = "adjustmentId is required")
    private String adjustmentId;
    @NotBlank(message = "inventoryId is required")
    @NotBlank(message = "inventoryId is required")
    private String inventoryId;
    @Enumerated(EnumType.STRING)
    @Enumerated(EnumType.STRING)
    private AdjustmentReason reason;
    @Min(value = 0, message = "quantityChange cannot be negative")
    private Integer quantityChange;
    private LocalDateTime adjustmentDate;
    @Enumerated(EnumType.STRING)
    @Enumerated(EnumType.STRING)
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