package com.example.serviceproductttsevening.services;

import com.example.serviceproductttsevening.models.Category;
import com.example.serviceproductttsevening.models.Product;
import com.example.serviceproductttsevening.models.ProductForGetProductsInCategory;

import java.util.List;

public interface CategoryService {
    String[] getAllCategories();
    List<ProductForGetProductsInCategory> getProductsInCategory(Long categoryId);
}
