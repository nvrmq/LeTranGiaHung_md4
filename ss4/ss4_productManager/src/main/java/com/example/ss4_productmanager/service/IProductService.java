package com.example.ss4_productmanager.service;

import com.example.ss4_productmanager.model.Product;

import java.util.List;

public interface IProductService {
    public List<Product> findAll();
    public void save(Product product);
    public Product findById(int id);
    public void update(Product product, int id);
    public void delete(int id);
}
