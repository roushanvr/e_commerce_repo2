package com.example.serviceproductttsevening.inheritanceexamples.tablePerClass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="tpc_instructor")
public class Instructor extends User {
    private boolean isHandsome;
}
