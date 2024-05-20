package com.ceres.productcrud.dto.product;

public record CreateProductRequestDTO(String name, String description, Double price, Integer stock) {
}
