package com.warehouse.management.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "products")
public class Product {


    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @NotBlank(message = "productId is required")
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @NotBlank(message = "productId is required")
    private String productId;
    @NotBlank(message = "sku is required")
    @NotBlank(message = "sku is required")
    private String sku;
    @NotBlank(message = "name is required")
    @NotBlank(message = "name is required")
    private String name;
    @NotBlank(message = "category is required")
    @NotBlank(message = "category is required")
    private String category;
    @NotBlank(message = "unitOfMeasure is required")
    @NotBlank(message = "unitOfMeasure is required")
    private String unitOfMeasure;
    private Integer reorderThreshold;
    @Enumerated(EnumType.STRING)
    @Enumerated(EnumType.STRING)
    private ProductStatus status;

    public enum ProductStatus {
        ACTIVE,
        DISCONTINUED
    }
}