package com.example.ss5_product_update.controller;

import com.example.ss5_product_update.model.Product;
import com.example.ss5_product_update.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public String showProductsList(Model model) {
        model.addAttribute("products", productService.findAll());
        return "list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("product", new Product());
        return "create";
    }

    @PostMapping("/add")
    public String addProdct(@ModelAttribute("product") Product product) {
        productService.save(product);
        return "redirect:/";
    }

    @GetMapping("/edit")
    public String showEditForm(Model model, @RequestParam int id) {
        model.addAttribute("product", productService.findById(id));
        return "edit";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Product product) {
        productService.update(product, product.getId());
        return "redirect:/";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam int id) {
        productService.delete(id);
        return "redirect:/";
    }

    @GetMapping("/view")
    public String showProductView(Model model, @RequestParam int id) {
        model.addAttribute("product", productService.findById(id));
        return "view";
    }
}
