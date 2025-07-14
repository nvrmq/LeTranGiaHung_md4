package com.example.md4_test.service;

import com.example.md4_test.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IProductService {
    List<Product> findAll();
    Page<Product> findAll(Pageable pageable);
    Optional<Product> findById(Long id);
    Product save(Product product);
    void deleteById(Long id);
    void deleteProducts(List<Long> ids);
    Page<Product> searchProducts(String name, Double price, Long categoryId, Pageable pageable);
} 