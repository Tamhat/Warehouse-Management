package com.warehouse.management.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @NotBlank(message = "userId is required")
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @NotBlank(message = "userId is required")
    private String userId;
    @NotBlank(message = "name is required")
    @NotBlank(message = "name is required")
    private String name;
    @Enumerated(EnumType.STRING)
    @Enumerated(EnumType.STRING)
    private UserRole role;
    @NotBlank(message = "warehouseId is required")
    @NotBlank(message = "warehouseId is required")
    private String warehouseId;
    @Enumerated(EnumType.STRING)
    @Enumerated(EnumType.STRING)
    private UserStatus status;

    public enum UserRole {
        WAREHOUSE_MANAGER,
        INVENTORY_CLERK,
        PICKER,
        PACKER,
        RECEIVING_CLERK,
        FORKLIFT_OPERATOR,
        QUALITY_CONTROL_INSPECTOR,
        SUPPLIER,
        CUSTOMER,
        DELIVERY_DRIVER,
        PROCUREMENT_OFFICER,
        WAREHOUSE_ADMIN,
        AUDITOR,
        MAINTENANCE_TECHNICIAN
    }

    public enum UserStatus {
        ACTIVE,
        SUSPENDED,
        DEACTIVATED
    }
}