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
@Table(name = "outbound_orders")
public class OutboundOrder {


    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @NotBlank(message = "orderId is required")
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @NotBlank(message = "orderId is required")
    private String orderId;
    @NotBlank(message = "customerId is required")
    @NotBlank(message = "customerId is required")
    private String customerId;
    private List<String> items;
    private LocalDateTime orderDate;
    private LocalDateTime requestedShipDate;
    @Enumerated(EnumType.STRING)
    @Enumerated(EnumType.STRING)
    private OutboundOrderStatus status;

    public enum OutboundOrderStatus {
        PLACED,
        CONFIRMED,
        PICKING,
        PACKED,
        SHIPPED,
        DELIVERED,
        CANCELLED
    }
}