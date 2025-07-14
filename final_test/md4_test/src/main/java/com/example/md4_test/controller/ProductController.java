package com.example.md4_test.controller;

import com.example.md4_test.dto.ProductFormDTO;
import com.example.md4_test.dto.ProductSearchDTO;
import com.example.md4_test.model.Category;
import com.example.md4_test.model.Product;
import com.example.md4_test.service.ICategoryService;
import com.example.md4_test.service.IProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
public class ProductController {

    @GetMapping("/")
    public String home() {
        return "redirect:/products";
    }
    @Autowired
    private IProductService productService;

    @Autowired
    private ICategoryService categoryService;

    @GetMapping("/products")
    public String listProducts(
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "5") int size,
            @RequestParam(name = "name", required = false) String name,
            @RequestParam(name = "price", required = false) Double price,
            @RequestParam(name = "categoryId", required = false) Long categoryId,
            Model model) {

        // Tạo Pageable object với số trang và số item mỗi trang
        Pageable pageable = PageRequest.of(page, size, Sort.by("id").ascending());
        
        // Tạo DTO để lưu thông tin tìm kiếm
        ProductSearchDTO searchDTO = new ProductSearchDTO();
        if (name != null && !name.trim().isEmpty()) {
            searchDTO.setName(name);
        }
        if (price != null) {
            searchDTO.setPrice(price);
        }
        if (categoryId != null) {
            searchDTO.setCategoryId(categoryId);
        }
        
        // Thực hiện tìm kiếm hoặc lấy tất cả sản phẩm
        Page<Product> productPage;
        if (name != null || price != null || categoryId != null) {
            productPage = productService.searchProducts(name, price, categoryId, pageable);
        } else {
            productPage = productService.findAll(pageable);
        }

        List<Category> categories = categoryService.findAll();

        model.addAttribute("productPage", productPage);
        
        int totalPages = productPage.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(0, totalPages - 1)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }

        model.addAttribute("searchDTO", searchDTO);
        model.addAttribute("categories", categories);
        
        return "products/list";
    }
    
    @PostMapping("/delete")
    public String deleteSelectedProducts(
            @RequestParam(value = "selectedIds", required = false) List<Long> selectedIds,
            RedirectAttributes redirectAttributes) {
        
        if (selectedIds != null && !selectedIds.isEmpty()) {
            productService.deleteProducts(selectedIds);
            redirectAttributes.addFlashAttribute("successMessage", "Xóa sản phẩm thành công!");
        } else {
            redirectAttributes.addFlashAttribute("errorMessage", "Vui lòng chọn sản phẩm cần xóa!");
        }
        
        return "redirect:/products";
    }
    
    @GetMapping("/add")
    public String showAddProductForm(Model model) {
        ProductFormDTO productForm = new ProductFormDTO();

        // Mặc định giá trị tình trạng là "chờ duyệt"
        productForm.setStatus("chờ duyệt");

        List<Category> categories = categoryService.findAll();
        
        model.addAttribute("productForm", productForm);
        model.addAttribute("categories", categories);
        model.addAttribute("title", "Thêm sản phẩm");
        
        return "products/form";
    }
    
    @PostMapping("/add")
    public String addProduct(
            @Valid @ModelAttribute("productForm") ProductFormDTO productForm,
            BindingResult result,
            Model model,
            RedirectAttributes redirectAttributes) {
        
        // Kiểm tra lỗi validation
        if (result.hasErrors()) {
            List<Category> categories = categoryService.findAll();
            model.addAttribute("categories", categories);
            model.addAttribute("title", "Thêm sản phẩm");
            return "products/form";
        }
        
        // Chuyển từ DTO sang entity
        Product product = new Product();
        product.setName(productForm.getName());
        product.setPrice(productForm.getPrice());
        product.setStatus(productForm.getStatus());
        
        // Tìm category theo ID và gán cho product
        Optional<Category> category = categoryService.findById(productForm.getCategoryId());
        if (category.isPresent()) {
            product.setCategory(category.get());
        } else {
            result.rejectValue("categoryId", "error.productForm", "Loại sản phẩm không hợp lệ");
            List<Category> categories = categoryService.findAll();
            model.addAttribute("categories", categories);
            model.addAttribute("title", "Thêm sản phẩm");
            return "products/form";
        }

        productService.save(product);
        redirectAttributes.addFlashAttribute("successMessage", "Thêm sản phẩm thành công!");
        
        return "redirect:/products";
    }
    
    @GetMapping("/edit/{id}")
    public String showEditProductForm(@PathVariable("id") Long id, Model model, RedirectAttributes redirectAttributes) {

        Optional<Product> productOptional = productService.findById(id);
        
        if (!productOptional.isPresent()) {
            redirectAttributes.addFlashAttribute("errorMessage", "Không tìm thấy sản phẩm!");
            return "redirect:/products";
        }
        
        Product product = productOptional.get();
        
        // Chuyển từ entity sang DTO
        ProductFormDTO productForm = new ProductFormDTO();
        productForm.setId(product.getId());
        productForm.setName(product.getName());
        productForm.setPrice(product.getPrice());
        productForm.setStatus(product.getStatus());
        productForm.setCategoryId(product.getCategory().getCid());

        List<Category> categories = categoryService.findAll();
        
        model.addAttribute("productForm", productForm);
        model.addAttribute("categories", categories);
        model.addAttribute("title", "Sửa sản phẩm");
        model.addAttribute("isEdit", true);
        
        return "products/form";
    }
    
    @PostMapping("/edit/{id}")
    public String updateProduct(
            @PathVariable("id") Long id,
            @Valid @ModelAttribute("productForm") ProductFormDTO productForm,
            BindingResult result,
            Model model,
            RedirectAttributes redirectAttributes) {
        
        // Kiểm tra lỗi validation
        if (result.hasErrors()) {
            List<Category> categories = categoryService.findAll();
            model.addAttribute("categories", categories);
            model.addAttribute("title", "Sửa sản phẩm");
            model.addAttribute("isEdit", true);
            return "products/form";
        }
        
        // Tìm sản phẩm hiện tại trong database
        Optional<Product> productOptional = productService.findById(id);
        if (!productOptional.isPresent()) {
            redirectAttributes.addFlashAttribute("errorMessage", "Không tìm thấy sản phẩm!");
            return "redirect:/products";
        }
        
        Product product = productOptional.get();
        
        // Cập nhật thông tin sản phẩm
        product.setName(productForm.getName());
        product.setPrice(productForm.getPrice());
        product.setStatus(productForm.getStatus());
        
        // Tìm category theo ID và gán cho product
        Optional<Category> category = categoryService.findById(productForm.getCategoryId());
        if (category.isPresent()) {
            product.setCategory(category.get());
        } else {
            result.rejectValue("categoryId", "error.productForm", "Loại sản phẩm không hợp lệ");
            List<Category> categories = categoryService.findAll();
            model.addAttribute("categories", categories);
            model.addAttribute("title", "Sửa sản phẩm");
            model.addAttribute("isEdit", true);
            return "products/form";
        }

        productService.save(product);
        redirectAttributes.addFlashAttribute("successMessage", "Cập nhật sản phẩm thành công!");
        
        return "redirect:/products";
    }
} 