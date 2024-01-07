package com.example.serviceproductttsevening.inheritanceexamples.JoinedTable;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="jt_ta")
@PrimaryKeyJoinColumn(name="user_id")
//The column that will allow to join with the primary key of parent table
public class Ta extends User {
    private double averageRating;
}
