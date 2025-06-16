package com.example.ss7_blog.controller;

import com.example.ss7_blog.model.Blog;
import com.example.ss7_blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("blog")
public class BlogController {

    @Autowired
    private BlogService blogService;
    @GetMapping
    public String showList(Model model) {
        model.addAttribute("blogs", blogService.findAll());
        return "list";
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("blog", new Blog());
        return "create";
    }

    @PostMapping("/create")
    public String createBlog(@ModelAttribute Blog blog){
        blogService.save(blog);
        return "redirect:/blog";
    }

    @GetMapping("/detail/{id}")
    public String showDetail(@PathVariable Long id, Model model) {
        model.addAttribute("blog", blogService.findById(id));
        return "detail";
    }

    @GetMapping("/delete/{id}")
    public String deleteBlog(@PathVariable Long id, Model model) {
        blogService.delete(id);
        return "redirect:/blog";
    }

    @GetMapping("/edit/{id}")
    public String showEdit(@PathVariable Long id, Model model) {
        model.addAttribute("blog", blogService.findById(id));
        return "edit";
    }

    @PostMapping("/edit")
    public String editBlog(@ModelAttribute Blog blog) {
        blogService.save(blog);
        return "redirect:/blog";
    }
}
