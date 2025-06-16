package com.example.ss7_blog.service;

import com.example.ss7_blog.model.Blog;
import com.example.ss7_blog.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService {
    @Autowired
    private BlogRepository blogRepository;

    public List<Blog> findAll(){
        return blogRepository.findAll();
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
}
