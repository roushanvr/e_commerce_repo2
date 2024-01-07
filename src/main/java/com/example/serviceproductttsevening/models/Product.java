package com.example.serviceproductttsevening.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@Getter
@Setter
@Entity
public class Product extends BaseModels{
    private String title;
    private double price;
    @ManyToOne
    private Category category;
    private String description;
    private String imageUrl;

}
