package com.example.ss5_product_update.repository;

import com.example.ss5_product_update.model.Product;

import java.util.List;

public interface IProductRepository {
    public List<Product> findAll();
    public Product findById(int id);
    public void save(Product product);
    public void update(Product product);
    public void delete(int id);
}
