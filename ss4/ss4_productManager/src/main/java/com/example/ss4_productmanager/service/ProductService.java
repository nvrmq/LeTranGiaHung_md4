package com.example.ss4_productmanager.service;

import com.example.ss4_productmanager.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService implements IProductService {
    private static List<Product> products = new ArrayList<>();

    static {
        products.add(new Product(1, "Galaxy S25 Ultra", 25.06, 3, "Samsung" ));
        products.add(new Product(2, "Iphone 15 Plus", 26.06, 10, "Apple" ));
        products.add(new Product(3, "Galaxy Tab S9 Ultra", 37.90, 5, "Samsung" ));
        products.add(new Product(4, "Oppo Find X3 Pro", 22.06, 4, "Oppo" ));
    }

    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public void save(Product product) {
        products.add(product);
    }

    @Override
    public Product findById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    @Override
    public void update(Product product, int id) {
        int index  = -1;
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == id) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            products.set(index, product);
        }
    }

    @Override
    public void delete(int id) {
        products.removeIf(product -> product.getId() == id);
    }
}
