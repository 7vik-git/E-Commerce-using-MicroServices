package com.bridgelabz.product.controller;

import com.bridgelabz.product.entity.Category;
import com.bridgelabz.product.entity.Product;
import com.bridgelabz.product.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping("/add")
    public ResponseEntity<Category> createCategory(@RequestBody Category category) {
        return ResponseEntity.ok(categoryService.createCategory(category));
    }

    @GetMapping("/{category-id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable("category-id") Integer categoryId) {
        return ResponseEntity.ok(categoryService.getCategoryById(categoryId));
    }

    @GetMapping
    public ResponseEntity<List<Category>> getAllCategories() {
        return ResponseEntity.ok(categoryService.getAllCategories());
    }

    @GetMapping("/{category-id}/products")
    public ResponseEntity<List<Product>> getProductsByCategoryId(@PathVariable("category-id") Integer categoryId) {
        return ResponseEntity.ok(categoryService.getProductsByCategoryId(categoryId));
    }
}
