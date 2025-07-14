package com.example.md4_test.repository;

import com.example.md4_test.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository extends JpaRepository<Product, Long> {

    Page<Product> findByNameContaining(String name, Pageable pageable);
    Page<Product> findByPriceGreaterThanEqual(Double price, Pageable pageable);
    Page<Product> findByCategoryCid(Long categoryId, Pageable pageable);
    Page<Product> findByNameContainingAndPriceGreaterThanEqual(String name, Double price, Pageable pageable);
    Page<Product> findByNameContainingAndCategoryCid(String name, Long categoryId, Pageable pageable);
    Page<Product> findByPriceGreaterThanEqualAndCategoryCid(Double price, Long categoryId, Pageable pageable);
    Page<Product> findByNameContainingAndPriceGreaterThanEqualAndCategoryCid(
            String name, Double price, Long categoryId, Pageable pageable);
            
    // Query với JPQL để tìm kiếm linh hoạt hơn
    @Query("SELECT p FROM Product p WHERE " +
           "(:name IS NULL OR p.name LIKE %:name%) AND " +
           "(:price IS NULL OR p.price >= :price) AND " +
           "(:categoryId IS NULL OR p.category.cid = :categoryId)")
    Page<Product> searchProducts(
            @Param("name") String name, 
            @Param("price") Double price, 
            @Param("categoryId") Long categoryId, 
            Pageable pageable);
} 