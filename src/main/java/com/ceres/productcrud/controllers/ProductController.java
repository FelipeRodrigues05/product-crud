package com.ceres.productcrud.controllers;

import com.ceres.productcrud.domain.product.Product;
import com.ceres.productcrud.dto.product.CreateProductRequestDTO;
import com.ceres.productcrud.dto.product.UpdateProductRequestDTO;
import com.ceres.productcrud.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @PostMapping("/create")
    public ResponseEntity<Product> createProduct(@RequestBody @Validated CreateProductRequestDTO body) {
        Product newProduct = new Product(body);
        productRepository.save(newProduct);

        return ResponseEntity.ok(newProduct);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable String id, @RequestBody @Validated UpdateProductRequestDTO body) {
        Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));

        product.setDescription(body.description());
        product.setPrice(body.price());
        product.setStock(body.stock());

        productRepository.save(product);

        return ResponseEntity.ok(product);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok(productRepository.findAll());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable String id) {
        productRepository.deleteById(id);
        return ResponseEntity.ok("Product deleted");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable String id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product Not Found"));
        return ResponseEntity.ok(product);
    }
}
