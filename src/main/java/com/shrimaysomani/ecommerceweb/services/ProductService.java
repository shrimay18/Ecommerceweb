package com.shrimaysomani.ecommerceweb.services;

import com.shrimaysomani.ecommerceweb.models.Product;

import java.util.List;

public interface ProductService { // it is created as interface as product service will have multiple implementation
    //interface methods are by default public and static
    Product getProductById(Long id);  // we are returning product bcoz dtos of deifferent api like fakestore , our own database may be different whereas the product return type is more generic
    List<Product> getAllProducts();
    Product createProduct(Product product);
}
