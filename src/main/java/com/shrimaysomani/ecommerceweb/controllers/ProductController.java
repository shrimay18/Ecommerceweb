package com.shrimaysomani.ecommerceweb.controllers;

import com.shrimaysomani.ecommerceweb.DTOS.ExceptionDTO;
import com.shrimaysomani.ecommerceweb.DTOS.FakeStoreProductDTO;
import com.shrimaysomani.ecommerceweb.models.Product;
import com.shrimaysomani.ecommerceweb.services.FakeStoreProductService;
import com.shrimaysomani.ecommerceweb.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //This means that this controller is capable of hosting http api's
@RequestMapping("/products")
public class ProductController { //waiter
    private ProductService productService;
    ProductController(@Qualifier("selfProductService") ProductService productService){
        this.productService = productService;
    }
    @GetMapping("/{id}") //As per REST what function you are performing like get , set should not be mentioned in the api
    public Product getProductById(@PathVariable("id") Long id){ //PathVariable is used when we want to pass the parameter as a varible from the path of the url
            return productService.getProductById(id);
    }
    //localhost:8080/products
    @GetMapping
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product){ //RequestBody is used to pass the data in the body of the request
        return productService.createProduct(product);
    }
}

