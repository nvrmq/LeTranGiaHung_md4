package com.example.ss7_blog.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity(name = "blog")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "VARCHAR(200)")
    private String title;
    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    @Column(columnDefinition = "VARCHAR(50)")
    private LocalDateTime createdTime;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public Blog() {
        this.createdTime = LocalDateTime.now();
    }

    public Blog(String title, String content, Category category) {
        this.title = title;
        this.content = content;
        this.createdTime = LocalDateTime.now();
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
    }
    public Category getCategory() {
        return category;
    }
    public void setCategory(Category category) {
        this.category = category;
    }
}
