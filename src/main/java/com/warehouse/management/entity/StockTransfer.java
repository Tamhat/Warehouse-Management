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
@Table(name = "stock_transfers")
public class StockTransfer {


    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @NotBlank(message = "transferId is required")
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @NotBlank(message = "transferId is required")
    private String transferId;
    @NotBlank(message = "productId is required")
    @NotBlank(message = "productId is required")
    private String productId;
    @NotBlank(message = "fromZoneId is required")
    @NotBlank(message = "fromZoneId is required")
    private String fromZoneId;
    @NotBlank(message = "toZoneId is required")
    @NotBlank(message = "toZoneId is required")
    private String toZoneId;
    @Min(value = 0, message = "quantity cannot be negative")
    private Integer quantity;
    private LocalDateTime requestedDate;
    @Enumerated(EnumType.STRING)
    @Enumerated(EnumType.STRING)
    private StockTransferStatus status;

    public enum StockTransferStatus {
        REQUESTED,
        APPROVED,
        IN_TRANSIT,
        COMPLETED
    }
}