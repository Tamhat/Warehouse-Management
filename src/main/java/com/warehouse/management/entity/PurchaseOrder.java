package com.warehouse.management.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "purchase_orders")
public class PurchaseOrder {


    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @NotBlank(message = "orderId is required")
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @NotBlank(message = "orderId is required")
    private String orderId;
    @NotBlank(message = "supplierId is required")
    @NotBlank(message = "supplierId is required")
    private String supplierId;
    private List<String> items;
    private LocalDateTime orderDate;
    private LocalDateTime expectedDeliveryDate;
    @Enumerated(EnumType.STRING)
    @Enumerated(EnumType.STRING)
    private PurchaseOrderStatus status;

    public enum PurchaseOrderStatus {
        DRAFT,
        APPROVED,
        SENT,
        PARTIALLY_RECEIVED,
        RECEIVED,
        CANCELLED
    }
}