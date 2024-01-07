package com.example.serviceproductttsevening.dtos;

import com.example.serviceproductttsevening.models.Product;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class CategoryDto {
    private Long id;
    private String name;
    private String description;
    private String product;
}
