package com.example.serviceproductttsevening.inheritanceexamples.mappedSuperClass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="ms_ta")
public class Ta extends User {
    private double averageRating;
}
