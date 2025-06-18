package com.example.ss7_blog.repository;


import com.example.ss7_blog.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BlogRepository extends JpaRepository<Blog,Long> {

    List<Blog> findByTitleContainingIgnoreCase(String keyword);
    List<Blog> findByCategoryId(Long id);
}
