package com.example.serviceproductttsevening.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@Entity
public class Category extends BaseModels{
    private String name;
    private String description;
    @OneToMany(mappedBy ="category")
    private List<Product> product;
}
