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
@Table(name = "pack_lists")
public class PackList {


    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @NotBlank(message = "packListId is required")
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @NotBlank(message = "packListId is required")
    private String packListId;
    @NotBlank(message = "outboundOrderId is required")
    @NotBlank(message = "outboundOrderId is required")
    private String outboundOrderId;
    @NotBlank(message = "pickListId is required")
    @NotBlank(message = "pickListId is required")
    private String pickListId;
    private List<String> packedItems;
    private LocalDateTime packedDate;
    @Enumerated(EnumType.STRING)
    @Enumerated(EnumType.STRING)
    private PackListStatus status;

    public enum PackListStatus {
        PENDING,
        IN_PROGRESS,
        COMPLETED
    }
}