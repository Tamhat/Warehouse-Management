package com.warehouse.management.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "invoices")
public class Invoice {


    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @NotBlank(message = "invoiceId is required")
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @NotBlank(message = "invoiceId is required")
    private String invoiceId;
    @NotBlank(message = "outboundOrderId is required")
    @NotBlank(message = "outboundOrderId is required")
    private String outboundOrderId;
    @PositiveOrZero(message = "amount must be positive or zero")
    private BigDecimal amount;
    private LocalDateTime issueDate;
    private LocalDateTime dueDate;
    @Enumerated(EnumType.STRING)
    @Enumerated(EnumType.STRING)
    private InvoiceStatus status;

    public enum InvoiceStatus {
        ISSUED,
        PAID,
        OVERDUE
    }
}