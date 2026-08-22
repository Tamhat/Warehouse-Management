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
@Table(name = "pick_lists")
public class PickList {


    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @NotBlank(message = "pickListId is required")
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @NotBlank(message = "pickListId is required")
    private String pickListId;
    @NotBlank(message = "outboundOrderId is required")
    @NotBlank(message = "outboundOrderId is required")
    private String outboundOrderId;
    private List<String> items;
    @NotBlank(message = "assignedPickerId is required")
    @NotBlank(message = "assignedPickerId is required")
    private String assignedPickerId;
    private LocalDateTime createdDate;
    @Enumerated(EnumType.STRING)
    @Enumerated(EnumType.STRING)
    private PickListStatus status;

    public enum PickListStatus {
        PENDING,
        IN_PROGRESS,
        COMPLETED,
        EXCEPTION
    }
}