package com.example.ss7_blog.controller;

import com.example.ss7_blog.model.Blog;
import com.example.ss7_blog.service.BlogService;
import com.example.ss7_blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("blog")
public class BlogController {

    @Autowired
    private BlogService blogService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public String showList(@RequestParam(defaultValue = "0") int page, Model model) {
        Page<Blog> blogPage = blogService.findAll(PageRequest.of(page, 5));
        model.addAttribute("blogPages", blogPage);
        return "blog/list";
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("blog", new Blog());
        model.addAttribute("categories", categoryService.findAll());
        return "blog/create";
    }

    @PostMapping("/create")
    public String createBlog(@ModelAttribute Blog blog){
        blogService.save(blog);
        return "redirect:/blog";
    }

    @GetMapping("/detail/{id}")
    public String showDetail(@PathVariable Long id, Model model) {
        model.addAttribute("blog", blogService.findById(id));
        return "blog/detail";
    }

    @GetMapping("/delete/{id}")
    public String deleteBlog(@PathVariable Long id, Model model) {
        blogService.delete(id);
        return "redirect:/blog";
    }

    @GetMapping("/edit/{id}")
    public String showEdit(@PathVariable Long id, Model model) {
        model.addAttribute("blog", blogService.findById(id));
        model.addAttribute("categories", categoryService.findAll());
        return "blog/edit";
    }

    @PostMapping("/edit")
    public String editBlog(@ModelAttribute Blog blog) {
        blogService.save(blog);
        return "redirect:/blog";
    }

    @GetMapping("/category/{id}")
    public String viewByCategory(@PathVariable Long id, Model model) {
        List<Blog> blogs = blogService.searchByCategory(id);
        model.addAttribute("blogPage", blogs);
        return "blog/list";
    }

    @GetMapping("/search")
    public String search(@RequestParam String keyword, Model model) {
        List<Blog> blogs = blogService.searchByTitle(keyword);
        model.addAttribute("blogs", blogs);
        return "blog/list";
    }
}
