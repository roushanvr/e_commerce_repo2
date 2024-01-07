package com.example.serviceproductttsevening.controllers;

import com.example.serviceproductttsevening.models.Category;
import com.example.serviceproductttsevening.models.Product;
import com.example.serviceproductttsevening.models.ProductForGetProductsInCategory;
import com.example.serviceproductttsevening.services.CategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryController {
    private CategoryService categoryService;
    public CategoryController(CategoryService categoryService){
        this.categoryService=categoryService;
    }
    @GetMapping("/products/categories")
    public String[] getAllCategories(){
        return categoryService.getAllCategories();
    }
    @GetMapping("/products/categories/{categoryId}")
    public List<ProductForGetProductsInCategory> getProductsInCategory(@PathVariable ("categoryId") Long categoryId){
        return categoryService.getProductsInCategory(categoryId);
    }
}
