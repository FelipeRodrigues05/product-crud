package com.ceres.productcrud.repositories;

import com.ceres.productcrud.domain.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> {

}
