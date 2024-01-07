package com.example.serviceproductttsevening.services;

import com.example.serviceproductttsevening.dtos.ProductDto;
import com.example.serviceproductttsevening.exceptions.NotFoundException;
import com.example.serviceproductttsevening.models.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> getAllProducts();
    Optional<Product> getSingleProduct(Long productId) throws NotFoundException;
    //Product addNewProduct(ProductDto productDto);//methods of service don't take Dto object
    Product addNewProduct(ProductDto productDto);
    Product updateProduct(Long productId, Product product);
    Product replaceProduct(Long productId, Product product);
    Product deleteProduct(Long productId, Product product);
}
