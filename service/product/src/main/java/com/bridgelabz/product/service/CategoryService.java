package com.bridgelabz.product.service;

import com.bridgelabz.product.entity.Category;
import com.bridgelabz.product.entity.Product;
import com.bridgelabz.product.repository.CategoryRepository;
import com.bridgelabz.product.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;

    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    public Category getCategoryById(Integer id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Category not found with ID:: " + id));
    }

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public List<Product> getProductsByCategoryId(Integer categoryId) {
        Category category = getCategoryById(categoryId);
        return category.getProducts();
    }
}
