package com.example.md4_test.service;

import com.example.md4_test.model.Product;
import com.example.md4_test.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository productRepository;
    
    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }
    
    @Override
    public Page<Product> findAll(Pageable pageable) {
        return productRepository.findAll(pageable);
    }
    
    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }
    
    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }
    
    @Override
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }
    
    @Override
    @Transactional
    public void deleteProducts(List<Long> ids) {
        for(Long id : ids) {
            productRepository.deleteById(id);
        }
    }
    
    @Override
    public Page<Product> searchProducts(String name, Double price, Long categoryId, Pageable pageable) {
        if (name != null && name.trim().isEmpty()) {
            name = null;
        }
        
        return productRepository.searchProducts(name, price, categoryId, pageable);
    }
} 