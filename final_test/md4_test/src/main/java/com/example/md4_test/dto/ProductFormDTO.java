package com.example.md4_test.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class ProductFormDTO {
    
    private Long id;
    
    @NotEmpty(message = "Tên sản phẩm không được để trống")
    @Size(min = 5, max = 50, message = "Tên sản phẩm phải từ 5 đến 50 ký tự")
    private String name;
    
    @NotNull(message = "Giá bắt đầu không được để trống")
    @Min(value = 100000, message = "Giá bắt đầu phải ít nhất 100,000 VND")
    private Double price;
    
    @NotEmpty(message = "Tình trạng không được để trống")
    private String status;
    
    @NotNull(message = "Loại sản phẩm không được để trống")
    private Long categoryId;
    
    public ProductFormDTO() {
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public Double getPrice() {
        return price;
    }
    
    public void setPrice(Double price) {
        this.price = price;
    }
    
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    public Long getCategoryId() {
        return categoryId;
    }
    
    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
} 