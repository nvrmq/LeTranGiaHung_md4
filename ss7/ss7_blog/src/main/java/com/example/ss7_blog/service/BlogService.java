package com.example.ss7_blog.service;

import com.example.ss7_blog.model.Blog;
import com.example.ss7_blog.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService {
    @Autowired
    private BlogRepository blogRepository;

    public Page<Blog> findAll(Pageable pageable){
        return blogRepository.findAll(pageable);
    }

    public Blog findById(Long id){
        return blogRepository.findById(id).orElse(null);
    }

    public Blog save(Blog blog){
        return blogRepository.save(blog);
    }
    public void delete(Long id){
        blogRepository.deleteById(id);
    }

    public List<Blog> searchByTitle(String title){
        return blogRepository.findByTitleContainingIgnoreCase(title);
    }
    public List<Blog> searchByCategory(Long categoryId){
        return blogRepository.findByCategoryId(categoryId);
    }
}
