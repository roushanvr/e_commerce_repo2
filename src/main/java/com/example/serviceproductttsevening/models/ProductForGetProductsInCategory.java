package com.example.serviceproductttsevening.models;

import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductForGetProductsInCategory {
    private Long id;
    private String title;
    private double price;
    //@ManyToOne
    private String category;
    private String description;
    private String imageUrl;
}
