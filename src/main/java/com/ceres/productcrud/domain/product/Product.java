package com.ceres.productcrud.domain.product;

import com.ceres.productcrud.dto.product.CreateProductRequestDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "products")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String name;
    private String description;
    private Double price;
    private Integer stock;

    public Product(CreateProductRequestDTO body) {
        this.name           = body.name();
        this.description    = body.description();
        this.price          = body.price();
        this.stock          = body.stock();
    }
}
