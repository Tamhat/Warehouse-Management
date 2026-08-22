package com.warehouse.management.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Invoice {

    private String invoiceId;
    private String outboundOrderId;
    private BigDecimal amount;
    private LocalDateTime issueDate;
    private LocalDateTime dueDate;
    private InvoiceStatus status;

    public enum InvoiceStatus {
        ISSUED,
        PAID,
        OVERDUE
    }
}
