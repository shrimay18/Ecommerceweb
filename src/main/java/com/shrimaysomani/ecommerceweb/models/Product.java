package com.shrimaysomani.ecommerceweb.models;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor //This is a lombok annotation to create a no args constructor
@AllArgsConstructor //This is a lombok annotation to create a all args constructor
@Entity // This tells Hibernate to make a table out of this class
public class Product {
    @Id // This means that this field is the primary key
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private  String description;
    private  Double price;
    @ManyToOne //This is the way to tell hibernate that this is a many to one relationship
    private  Category category; //We have to attach the category table to product table  & way is called cardinality
    //One category can have multiple products but one product can have only one category
    private String image;
}
